CREATE OR REPLACE TRIGGER TRIGGER_PRES_EQ_MEN_SAL_JUG
BEFORE INSERT OR UPDATE ON JUGADOR
FOR EACH ROW
DECLARE
v_sueldo_total_jug NUMBER(9);
v_presupuesto_equipo equipo.presupuesto%TYPE;
BEGIN
    SELECT SUM(SUELDO)
    INTO v_sueldo_total_jug
    FROM JUGADOR
    WHERE EQUIPO_ID_EQUIPO = :new.EQUIPO_ID_EQUIPO;
    SELECT PRESUPUESTO
    INTO v_presupuesto_equipo
    FROM EQUIPO
    WHERE ID_EQUIPO = :new.EQUIPO_ID_EQUIPO; 
    IF INSERTING THEN
        IF(v_sueldo_total_jug + :new.sueldo > v_presupuesto_equipo) THEN
            RAISE_APPLICATION_ERROR(-20009, 'El equipo no tiene suficiente prespuesto como para pagar a este jugador');
        END IF;
    ELSIF UPDATING THEN
        IF(v_sueldo_total_jug - :old.sueldo + :new.sueldo > v_presupuesto_equipo) THEN
            RAISE_APPLICATION_ERROR(-20009, 'El equipo no tiene suficiente prespuesto como para pagar a este jugador');
        END IF;
    END IF;
END TRIGGER_PRES_EQ_MEN_SAL_JUG;