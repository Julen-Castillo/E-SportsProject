CREATE OR REPLACE PROCEDURE generar_calendario IS
v_dias_next_jornada NUMBER(2) := 0; --variable que incrementa en 7 tras cada jornada. La utilizamos para establecer la fecha de la siguiente jornada.
v_num_jornadas NUMBER(2) := 0; --contador de jornadas
v_increment_id_jornada NUMBER(2) := 1; --id jornada autoincremental
BEGIN
    DELETE FROM JORNADA; --eliminamos todas las jornadas antes de crear el calendario
    WHILE(v_num_jornadas < 10) --Queremos 10 iteraciones dado que queremos 10 jornadas
        LOOP
            INSERT INTO JORNADA VALUES(v_increment_id_jornada, SYSDATE + v_dias_next_jornada, SYSDATE + 2 + v_dias_next_jornada, 1);
            v_dias_next_jornada := v_dias_next_jornada + 7;
            v_num_jornadas := v_num_jornadas + 1;
            v_increment_id_jornada := v_increment_id_jornada + 1;
        END LOOP;    
END generar_calendario;

