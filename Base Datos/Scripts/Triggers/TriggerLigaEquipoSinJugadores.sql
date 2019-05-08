CREATE OR REPLACE TRIGGER TRIGGER_LIGA_NO_JUGADORES
BEFORE UPDATE ON LIGA
DECLARE
v_count_equipos NUMBER(2);
v_id_equipo NUMBER(2) := 1;--v_id_equipo es la variable que se incrementa para avanzar en el loop
v_estado_liga liga.en_curso%TYPE;
v_count_jugadores NUMBER(2);

BEGIN
    SELECT en_curso INTO v_estado_liga FROM liga; --Almacenamos el estado de la liga (boolean en_curso)
    IF(v_estado_liga = 0) THEN --Si la liga no ha comenzado ejecutamos lo siguiente
        SELECT COUNT(*) INTO v_count_equipos FROM EQUIPO; --Almacenamos los equipos que hay
        LOOP --Iteramos a través de todos los equipos para determinar si algun equipo está vacío.
            SELECT COUNT(*) INTO v_count_jugadores --Almacenamos el numero de jugadores de cada equipo
            FROM JUGADOR 
            WHERE equipo_id_equipo = v_id_equipo; 
            IF(v_count_jugadores = 0) THEN
                RAISE_APPLICATION_ERROR(-20005, 'No se puede comenzar la liga con equipos sin jugadores');
            END IF;
            v_id_equipo := v_id_equipo + 1;
        END LOOP;
    END IF;
END TRIGGER_LIGA_NO_JUGADORES;
