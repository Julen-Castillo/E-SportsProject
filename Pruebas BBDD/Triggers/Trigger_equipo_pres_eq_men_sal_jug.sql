CREATE OR REPLACE TRIGGER TRIGGER_EQU_PRES_MEN_SAL_JUG
BEFORE UPDATE ON EQUIPO
FOR EACH ROW
DECLARE
v_sueldo_total_jug NUMBER(9);
BEGIN
    SELECT SUM(SUELDO)
    INTO v_sueldo_total_jug
    FROM JUGADOR
    WHERE EQUIPO_ID_EQUIPO = :new.ID_EQUIPO;
    IF UPDATING THEN
        IF(v_sueldo_total_jug > :new.presupuesto) THEN
            RAISE_APPLICATION_ERROR(-20009, 'El equipo no tiene suficiente prespuesto como para pagar a sus jugadores');
        END IF;
    END IF;
END TRIGGER_EQU_PRES_MEN_SAL_JUG;