CREATE OR REPLACE TRIGGER TRIGGER_5_TITULARES
BEFORE INSERT OR UPDATE ON JUGADOR
FOR EACH ROW
DECLARE
v_num_titulares NUMBER(2);
BEGIN
    SELECT COUNT(*)
    INTO v_num_titulares
    FROM JUGADOR
    WHERE titularidad = 1;
    IF INSERTING THEN
        IF(v_num_titulares >= 5 AND :new.titularidad = 1) THEN
            RAISE_APPLICATION_ERROR(-20008, 'Solo puede haber 5 titulares en la plantilla');
        END IF;
    ELSIF UPDATING THEN
        IF(v_num_titulares = 5 AND :old.titularidad = 0 AND :new.titularidad = 1) THEN
            RAISE_APPLICATION_ERROR(-20008, 'Solo puede haber 5 titulares en la plantilla');
        END IF;
    END IF;    
END TRIGGER_5_TITULARES;

--ELSIF NOT TESTED, WORKS WITH IF