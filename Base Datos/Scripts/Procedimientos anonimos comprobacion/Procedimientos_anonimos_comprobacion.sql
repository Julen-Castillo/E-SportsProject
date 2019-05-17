set serveroutput on

--procedimiento_info_equipo
DECLARE 
    c_info_equipo SYS_REFCURSOR;
    v_id_equipo EQUIPO.id_equipo%TYPE;
    v_nombre_equipo EQUIPO.nombre%TYPE;
    v_presupuesto_equipo EQUIPO.presupuesto%TYPE;
    v_puntos_equipo EQUIPO.puntos%TYPE;
    v_id_presidente PRESIDENTE.id_presidente%TYPE;
    v_nombre_presidente PRESIDENTE.nombre%TYPE;
BEGIN
    paquete_mamecorp.procedimiento_info_equipo(c_info_equipo);
    LOOP
        FETCH c_info_equipo INTO 
            v_id_equipo,
            v_nombre_equipo,
            v_presupuesto_equipo,
            v_puntos_equipo,
            v_id_presidente,
            v_nombre_presidente;
        EXIT WHEN c_info_equipo%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_nombre_equipo || v_presupuesto_equipo);
    END LOOP;    
END;    
    
--procedimiento generar calendario
BEGIN
    paquete_mamecorp.generar_calendario();  
END; 

--function_count_jug_equipo
DECLARE 
v_num_jugadores NUMBER;
BEGIN
    v_num_jugadores := paquete_mamecorp.FUNCTION_COUNT_JUG_EQUIPO(1); 
    DBMS_OUTPUT.PUT_LINE(v_num_jugadores);
END; 



