CREATE OR REPLACE TRIGGER SALARIO_MIN_JUGADOR
BEFORE INSERT OR UPDATE ON Jugador
FOR EACH ROW
DECLARE
v_smi NUMBER(4) := 900;
--v_sueldo_jugador NUMBER(4);
BEGIN
    --v_sueldo_jugador := :new.sueldo;
    IF(:new.sueldo <= v_smi) THEN
        raise_application_error(-20001, 'El salario del jugador debe ser superior al SMI');
    END IF;  
END SALARIO_MIN_JUGADOR;    