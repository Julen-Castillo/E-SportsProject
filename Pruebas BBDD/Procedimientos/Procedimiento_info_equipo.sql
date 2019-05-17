CREATE OR REPLACE PROCEDURE procedimiento_info_equipo IS
CURSOR c_info_equipo IS
    SELECT E.ID_EQUIPO, E.NOMBRE, E.PRESUPUESTO, E.PUNTOS, P.ID_PRESIDENTE, P.NOMBRE AS PRESIDENTE
    FROM EQUIPO E, PRESIDENTE P
    WHERE P.EQUIPO_ID_EQUIPO(+) = E.ID_EQUIPO;   
v_info c_info_equipo%ROWTYPE;
v_num_jugadores NUMBER(2);
BEGIN
    OPEN c_info_equipo;
    LOOP
    FETCH c_info_equipo INTO v_info; 
        v_num_jugadores := FUNCTION_COUNT_JUG_EQUIPO(v_info.ID_EQUIPO);
        DBMS_OUTPUT.PUT_LINE('ID EQUIPO: ' || v_info.ID_EQUIPO || ' / NOMBRE: ' || v_info.NOMBRE || ' / PRESUPUESTO: ' || v_info.PRESUPUESTO || ' / PUNTOS: ' || v_info.PUNTOS || ' / NUM JUGADORES: ' || v_num_jugadores || ' / ID_PRESIDENTE: ' || NVL(TO_CHAR(v_info.ID_PRESIDENTE), 'No tiene presidente') || ' / NOMBRE: ' || NVL(v_info.PRESIDENTE, 'No tiene presidente'));
    EXIT WHEN c_info_equipo%notfound;
    END LOOP;
    CLOSE c_info_equipo;
END;

EXECUTE procedimiento_info_equipo;

