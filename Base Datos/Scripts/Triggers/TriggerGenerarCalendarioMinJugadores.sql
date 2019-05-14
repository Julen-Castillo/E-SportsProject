CREATE OR REPLACE TRIGGER GEN_CALENDAR_MIN_JUGADOR
BEFORE INSERT ON JORNADA
FOR EACH ROW
DECLARE
v_count_jugador NUMBER(3);
v_num_equipos NUMBER(2);
v_id_equipo NUMBER(2):= 1;
v_num_jornada NUMBER(2);
BEGIN
SELECT COUNT(*) INTO v_num_jornada FROM jornada;--Select para coger el numero de jornadas
IF (v_num_jornada = 0) THEN --Dado que vamos a crear todas las jornadas a la vez (a través de un script) solo necesitamos comprobar el numero de jugadores por equipo al insertar la primera jornada. 
                            --Una vez insertada la primera los requisitos de jugadores por equipo se van a cumplir por lo que no hace falta volver a disparar el trigger.
    SELECT COUNT(*) INTO v_num_equipos  --Select para coger la cantidad de equipos
    FROM equipo;
    LOOP --loop para saber cuantos jugadores hay por cada equipo y aplicar la restriccion
        SELECT COUNT(*) INTO v_count_jugador  
        FROM jugador
        WHERE equipo_id_equipo = (v_id_equipo); -- Select para coger la cantidad de jugadores por cada equipo
        v_id_equipo := v_id_equipo + 1;
        IF (v_count_jugador < 2) THEN 
        RAISE_APPLICATION_ERROR(-20003,'Los equipos tienen que tener minimo dos jugadores');
        END IF; 
    END LOOP;
END IF;
END;