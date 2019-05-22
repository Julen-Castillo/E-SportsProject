/*CABECERA DEL PAQUETE */

CREATE OR REPLACE PACKAGE paquete_mamecorp AS
	FUNCTION FUNCTION_COUNT_JUG_EQUIPO (ID_EQUIPO IN EQUIPO.ID_EQUIPO%TYPE)
		RETURN NUMBER;
    PROCEDURE procedimiento_info_equipo (c_info_equipo OUT SYS_REFCURSOR);    
	PROCEDURE generar_calendario;
--    CURSOR c_info_equipo IS 
--        SELECT E.ID_EQUIPO, E.NOMBRE, E.PRESUPUESTO, E.PUNTOS, P.ID_PRESIDENTE, P.NOMBRE AS PRESIDENTE
--        FROM EQUIPO E, PRESIDENTE P
--        WHERE P.EQUIPO_ID_EQUIPO(+) = E.ID_EQUIPO;     
END paquete_mamecorp;
/

CREATE OR REPLACE PACKAGE BODY paquete_mamecorp AS

	FUNCTION FUNCTION_COUNT_JUG_EQUIPO (ID_EQUIPO IN EQUIPO.ID_EQUIPO%TYPE)
	RETURN NUMBER
		AS
		NUM_JUGADORES NUMBER; 
        e_equipo_not_found EXCEPTION;
		BEGIN
		    SELECT COUNT(*) INTO NUM_JUGADORES 
		    FROM JUGADOR
		    WHERE Equipo_id_equipo = id_equipo;
            IF SQL%NOTFOUND THEN
            RAISE e_equipo_not_found;
            end if;
		RETURN(NUM_JUGADORES);
    EXCEPTION 
        WHEN e_equipo_not_found THEN
            RAISE_APPLICATION_ERROR(-20021, 'El equipo no existe');
        WHEN VALUE_ERROR THEN
            RAISE_APPLICATION_ERROR(-06502, 'El tipo de dato a introducir es un numero de equipo');
	END FUNCTION_COUNT_JUG_EQUIPO;


	

	PROCEDURE generar_calendario IS
		v_dias_next_jornada NUMBER := 0; --variable que incrementa en 7 tras cada jornada. La utilizamos para establecer la fecha de la siguiente jornada.
		v_num_jornadas NUMBER := 0; --contador de jornadas
		v_increment_id_jornada NUMBER := 1; --id jornada autoincremental
		v_jornadas_totales NUMBER := 10;
		v_f_inicio_liga DATE;
		v_f_fin_liga LIGA.FECHA_FIN%TYPE;
		BEGIN
		    DELETE FROM JORNADA; --eliminamos todas las jornadas antes de crear el calendario
		    DELETE FROM LIGA; --eliminamos las ligas antes de crear el calendario
		    INSERT INTO LIGA (id_liga,nombre, fecha_inicio, fecha_fin,en_curso) VALUES (01,'MAMECORPLEAGUE', SYSDATE, NULL, 0); --Creamos la liga sin fecha fin
              commit;
		    SELECT FECHA_INICIO INTO v_f_inicio_liga 
		    FROM liga
		    WHERE id_liga = 1;
		    WHILE(v_num_jornadas < v_jornadas_totales) --Queremos 10 iteraciones dado que queremos 10 jornadas
		        LOOP
		            INSERT INTO JORNADA (fecha_inicio,fecha_fin,liga_id_liga) VALUES (v_f_inicio_liga  + v_dias_next_jornada, v_f_inicio_liga  + 2 + v_dias_next_jornada, 1);
                    commit;
		            v_dias_next_jornada := v_dias_next_jornada + 7;
		            v_num_jornadas := v_num_jornadas + 1;
		            v_increment_id_jornada := v_increment_id_jornada + 1;
		        END LOOP;  
		    SELECT FECHA_FIN 
		    INTO v_f_fin_liga
		    FROM JORNADA
		    WHERE ID_JORNADA = (SELECT MAX(ID_JORNADA) FROM JORNADA);
		    UPDATE LIGA 
		    SET FECHA_FIN = v_f_fin_liga
		    WHERE ID_LIGA = 1;
                 commit;
            
	END generar_calendario;

   
	PROCEDURE procedimiento_info_equipo (c_info_equipo OUT SYS_REFCURSOR) IS
    BEGIN
        OPEN c_info_equipo FOR
        SELECT E.ID_EQUIPO, E.NOMBRE, E.PRESUPUESTO, E.PUNTOS, P.ID_PRESIDENTE, P.NOMBRE AS PRESIDENTE
        FROM EQUIPO E, PRESIDENTE P
        WHERE P.EQUIPO_ID_EQUIPO(+) = E.ID_EQUIPO;
        --DBMS_OUTPUT.PUT_LINE('ID EQUIPO: ' || v_info.ID_EQUIPO || ' / NOMBRE: ' || v_info.NOMBRE || ' / PRESUPUESTO: ' || v_info.PRESUPUESTO || ' / PUNTOS: ' || v_info.PUNTOS || ' / NUM JUGADORES: ' || v_num_jugadores || ' / ID_PRESIDENTE: ' || NVL(TO_CHAR(v_info.ID_PRESIDENTE), 'No tiene presidente') || ' / NOMBRE: ' || NVL(v_info.PRESIDENTE, 'No tiene presidente'));
    END procedimiento_info_equipo;
END paquete_mamecorp;
