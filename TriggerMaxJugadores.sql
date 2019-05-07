set serveroutput on


CREATE OR REPLACE TRIGGER MAX_JUGADOR
BEFORE INSERT OR UPDATE ON Jugador
FOR EACH ROW
DECLARE
v_max_jugadores NUMBER(1) := 6;
v_count_jugadores NUMBER(3);

BEGIN
    SELECT count(*) AS "NUMERO JUGADORES" INTO v_count_jugadores FROM jugador
    WHERE equipo_id_equipo = (:new.equipo_id_equipo);

    IF(v_count_jugadores > v_max_jugadores) THEN
        raise_application_error(-20000, 'No puede superar los 6 jugadores');
    END IF;  
END MAX_JUGADOR;    
    
    

    
    
    