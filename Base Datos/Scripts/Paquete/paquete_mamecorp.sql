/*CABECERA DEL PAQUETE */

CREATE OR REPLACE PACKAGE paquete_mamecorp AS
	FUNCTION FUNCTION_COUNT_JUG_EQUIPO (ID_EQUIPO IN EQUIPO.ID_EQUIPO%TYPE)
   
		RETURN NUMBER;
        

	PROCEDURE generar_calendario;
  
    CURSOR c_info_equipo is  SELECT E.ID_EQUIPO, E.NOMBRE, E.PRESUPUESTO, E.PUNTOS, P.ID_PRESIDENTE, P.NOMBRE AS PRESIDENTE
		    FROM EQUIPO E, PRESIDENTE P
		    WHERE P.EQUIPO_ID_EQUIPO(+) = E.ID_EQUIPO;   
    
	PROCEDURE procedimiento_info_equipo;
        --c_info_equipo CURSOR,
	
        
END paquete_mamecorp;


CREATE OR REPLACE PACKAGE BODY paquete_mamecorp AS

	FUNCTION FUNCTION_COUNT_JUG_EQUIPO (ID_EQUIPO IN EQUIPO.ID_EQUIPO%TYPE)
	RETURN NUMBER
		AS
		NUM_JUGADORES NUMBER;
		BEGIN
		    SELECT COUNT(*) INTO NUM_JUGADORES 
		    FROM JUGADOR
		    WHERE Equipo_id_equipo = id_equipo;
		RETURN(NUM_JUGADORES );
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
		    INSERT INTO LIGA VALUES (1, 'MAMECORPLEAGUE', SYSDATE, NULL, 0); --Creamos la liga sin fecha fin
		    SELECT FECHA_INICIO INTO v_f_inicio_liga 
		    FROM liga
		    WHERE id_liga = 1;
		    WHILE(v_num_jornadas < v_jornadas_totales) --Queremos 10 iteraciones dado que queremos 10 jornadas
		        LOOP
		            INSERT INTO JORNADA VALUES(v_increment_id_jornada, v_f_inicio_liga  + v_dias_next_jornada, v_f_inicio_liga  + 2 + v_dias_next_jornada, 1);
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
	END generar_calendario;

   
	PROCEDURE procedimiento_info_equipo IS
		CURSOR c_info_equipo IS
		    SELECT E.ID_EQUIPO, E.NOMBRE, E.PRESUPUESTO, E.PUNTOS, P.ID_PRESIDENTE, P.NOMBRE AS PRESIDENTE
		    FROM EQUIPO E, PRESIDENTE P
		    WHERE P.EQUIPO_ID_EQUIPO(+) = E.ID_EQUIPO;   
		v_info c_info_equipo%ROWTYPE;
		v_num_jugadores NUMBER;
		BEGIN
		    OPEN c_info_equipo;
		    LOOP
		    FETCH c_info_equipo INTO v_info; 
		        v_num_jugadores := FUNCTION_COUNT_JUG_EQUIPO(v_info.ID_EQUIPO);
		        DBMS_OUTPUT.PUT_LINE('ID EQUIPO: ' || v_info.ID_EQUIPO || ' / NOMBRE: ' || v_info.NOMBRE || ' / PRESUPUESTO: ' || v_info.PRESUPUESTO || ' / PUNTOS: ' || v_info.PUNTOS || ' / NUM JUGADORES: ' || v_num_jugadores || ' / ID_PRESIDENTE: ' || NVL(TO_CHAR(v_info.ID_PRESIDENTE), 'No tiene presidente') || ' / NOMBRE: ' || NVL(v_info.PRESIDENTE, 'No tiene presidente'));
		    EXIT WHEN c_info_equipo%notfound;
		    END LOOP;
		    CLOSE c_info_equipo;
		END;

	END paquete_mamecorp;

--PRUEBA DE PAQUETE 

/* DECLARE
jugadores_msg NUMBER(2);
BEGIN
    jugadores_msg := paquete_mamecorp.FUNCTION_COUNT_JUG_EQUIPO(10);
    DBMS_OUTPUT.PUT_LINE(jugadores_msg);
END;


BEGIN
paquete_mamecorp.generar_calendario;
END;

select * from jornada;

*/
