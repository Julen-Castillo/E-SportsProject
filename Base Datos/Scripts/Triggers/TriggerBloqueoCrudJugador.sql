CREATE OR REPLACE TRIGGER BLOQUEO_CRUD_JUGADOR
BEFORE INSERT OR UPDATE OR DELETE ON JUGADOR
DECLARE
v_num_jornadas NUMBER(2);
BEGIN
    SELECT COUNT(*) INTO v_num_jornadas 
    FROM JORNADA; --Almacenamos el numero de jornadas en una variable
    IF(v_num_jornadas != 0) THEN --Si el numero de jornadas no es 0 quiere decir que el calendario ya se ha creado por lo que no pueden modificarse los equipos.
        RAISE_APPLICATION_ERROR(-20004, 'No puedes modificar los jugadores una vez generado el calendario');
    END IF;    
END BLOQUEO_CRUD_JUGADOR;
