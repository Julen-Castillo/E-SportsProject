CREATE OR REPLACE PROCEDURE generar_calendario IS
v_dias_next_jornada NUMBER(2) := 0; --variable que incrementa en 7 tras cada jornada. La utilizamos para establecer la fecha de la siguiente jornada.
v_num_jornadas NUMBER(2) := 0; --contador de jornadas
v_increment_id_jornada NUMBER(2) := 1; --id jornada autoincremental
v_jornadas_totales NUMBER(2) := 10;
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


