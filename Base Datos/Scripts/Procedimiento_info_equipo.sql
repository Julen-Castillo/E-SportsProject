CREATE OR REPLACE PROCEDURE procedimiento_info_equipo IS
CURSOR c_info_equipo IS
    SELECT E.ID_EQUIPO, E.NOMBRE, E.PRESUPUESTO, E.PUNTOS, P.ID_PRESIDENTE, P.NOMBRE AS PRESIDENTE
    FROM EQUIPO E, PRESIDENTE P
    WHERE P.EQUIPO_ID_EQUIPO(+) = E.ID_EQUIPO;   
v_info c_info_equipo%ROWTYPE;
BEGIN
    OPEN c_info_equipo;
    LOOP
    FETCH c_info_equipo INTO v_info; 
        DBMS_OUTPUT.PUT_LINE(v_info.ID_EQUIPO);
    EXIT WHEN c_info_equipo%notfound;
    END LOOP;
    CLOSE c_info_equipo;
END;

execute procedimiento_info_equipo;


CREATE OR REPLACE PROCEDURE procedimiento_info_equipo IS
CURSOR c_info_equipo IS
    SELECT E.ID_EQUIPO, E.NOMBRE, E.PRESUPUESTO, E.PUNTOS, P.ID_PRESIDENTE, P.NOMBRE
    INTO c_info_equipo
    FROM EQUIPO E, PRESIDENTE P
    WHERE P.EQUIPO_ID_EQUIPO(+) = E.ID_EQUIPO;   
v_info c_info_equipo%ROWTYPE;
BEGIN
    FOR c_info_equipo IN v_info LOOP
        EXIT WHEN c_info_equipo%notfound;
        --DBMS_OUTPUT.PUT_LINE(c_info_equipo);
    END LOOP;
END;

SELECT * FROM PRESIDENTE;
FOR V_EMP IN C_EMP LOOP
