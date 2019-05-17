CREATE OR REPLACE TRIGGER MAX_PRESUPUESTO_EQUIPO
BEFORE INSERT OR UPDATE ON EQUIPO
FOR EACH ROW
DECLARE
v_max_presupuesto NUMBER(6) := 200000;
BEGIN
    IF(:new.presupuesto >= v_max_presupuesto) THEN
        raise_application_error(-20002, 'El presupuesto del equipo no puede ser superior a 200k');
    END IF;  
END MAX_PRESUPUESTO_EQUIPO; 