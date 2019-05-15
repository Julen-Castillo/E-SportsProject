/* Inserts de la tabla EQUIPO */

INSERT INTO EQUIPO (nombre,presupuesto,puntos)  VALUES ('fnatic',170000,0);
INSERT INTO EQUIPO (nombre,presupuesto,puntos)  VALUES ('sk telecom t1',180000,0);
INSERT INTO EQUIPO (nombre,presupuesto,puntos)  VALUES ('cloud9',160000,0);
INSERT INTO EQUIPO (nombre,presupuesto,puntos)  VALUES ('tsm',150000,0);
INSERT INTO EQUIPO (nombre,presupuesto,puntos)  VALUES ('thunderx3 baskonia',50000,0);
INSERT INTO EQUIPO (nombre,presupuesto,puntos)  VALUES ('mamecorp',200000,5);


/* Inserts de la tabla JUGADOR */

--INSERTS JUGADORES FNATIC 1
INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('tim','liposev','nemesis','midlane',1000,1,1);
INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('gabriel','rau','bwipo','toplane',1000,1,1);
INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('mads','brok-pedersen','broxah','jungler',1000,1,1);
INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('zdravets','galabov','hylissang','support',1000,1,1);
INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo)VALUES ('martin','larsson','rekkles','adcarry',1000,1,1);

--INSERTS JUGADORES SK TELECOM T1 2
INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('lee','sang-hyeok','faker','midlane',1000,1,2);
INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo)VALUES ('kim','jae-hee','crazy','toplane',1000,1,2);
INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('kang','min-seung','haru','jungler',1000,1,2);
INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('cho','se-hyeong','mata','support',1000,1,2);
INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('park','jin-seong','teddy','adcarry',1000,1,2);

--INSERTS JUGADORES CLOUD9 3

INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('yasin','dinÃ§er','nisqy','midlane',1000,1,3);
INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('eric','rtichie','licorice','toplane',1000,1,3);
INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('robert','huang','blaber','jungler',1000,1,3);
INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('tristan','stidam','zeyzal','support',1000,1,3);
INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('zachary','scuderi','sneaky','adcarry',1000,1,3);

--INSERTS JUGADORES TSM 4 

INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('soren','bjerg','bjergsen','midlane',1000,1,4);
INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('sergen','Ã§elik','broken blade','toplane',1000,1,4);
INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('matthew','higginotham','akaadian','jungler',1000,1,4);
INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('andy','ta','smoothie','support',1000,1,4);
INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('jesper','svenningsen','zven','adcarry',1000,1,4);

--INSERTS JUGADORES THUNDERX3 BASKONIA 5

INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('danny','le comite','dan dan','toplane',1000,1,5);
INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('sergio','martin','diamond','midlane',1000,1,5);
INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('ignacio','garcia','itsi','jungler',1000,1,5);
INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('adrain','moldes','homi','support',1000,1,5);
INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('alejandro','gonzalez','darkside','adcarry',1000,1,5);

--INSERT JUGADORES MAMECORP 6
INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('julen','castillo','castiskate','midlane',3000,1,6);
INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('adrian','danlos','godskater','toplane',3000,1,6);
INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('julen','prieto','peto','jungler',3000,1,6);


--INSERT PRESIDENTES
INSERT INTO PRESIDENTE (nombre,apellido,equipo_id_equipo)VALUES('sam','mathews',1);
INSERT INTO PRESIDENTE (nombre,apellido,equipo_id_equipo)VALUES('sung','min ha',2);
INSERT INTO PRESIDENTE (nombre,apellido,equipo_id_equipo)VALUES('jack','etienne',3);
INSERT INTO PRESIDENTE (nombre,apellido,equipo_id_equipo)VALUES('andy','dinh',4);
INSERT INTO PRESIDENTE (nombre,apellido,equipo_id_equipo)VALUES('jose antonio','querejeta',5);
INSERT INTO PRESIDENTE (nombre,apellido,equipo_id_equipo)VALUES('eric','con c',6);


--INSERT LIGA
INSERT INTO LIGA (nombre,fecha_inicio,fecha_fin,en_curso) VALUES ('MameCorp league', SYSDATE,SYSDATE,1);

--INSERT JORNADA 
INSERT INTO JORNADA (FECHA_INICIO,FECHA_FIN,LIGA_ID_LIGA) VALUES (SYSDATE,SYSDATE+7,1);

--INSERT USUARIOS

INSERT INTO USUARIO(nombre,password,tipo) VALUES('mamecorp','mamecorp','admin');
INSERT INTO USUARIO(nombre,password,tipo) VALUES('user','user','user');

--TRIGGERS

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

/

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

/

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

/

CREATE OR REPLACE TRIGGER BLOQUEO_CRUD_EQUIPO
BEFORE INSERT OR UPDATE OR DELETE ON EQUIPO
DECLARE
v_num_jornadas NUMBER(2);
BEGIN
    SELECT COUNT(*) INTO v_num_jornadas 
    FROM JORNADA; --Almacenamos el numero de jornadas en una variable
    IF(v_num_jornadas != 0) THEN --Si el numero de jornadas no es 0 quiere decir que el calendario ya se ha creado por lo que no pueden modificarse los equipos.
        RAISE_APPLICATION_ERROR(-20004, 'No puedes modificar los equipos una vez generado el calendario');
    END IF;    
END BLOQUEO_CRUD_EQUIPO;

/

CREATE OR REPLACE TRIGGER BLOQUEO_CRUD_JUGADOR
BEFORE INSERT OR UPDATE OR DELETE ON JUGADOR
DECLARE
v_num_jornadas NUMBER(2);
BEGIN
    SELECT COUNT(*) INTO v_num_jornadas 
    FROM JORNADA; --Almacenamos el numero de jornadas en una variable
    IF(v_num_jornadas != 0) THEN --Si el numero de jornadas no es 0 quiere decir que el calendario ya se ha creado por lo que no pueden modificarse los equipos.
        RAISE_APPLICATION_ERROR(-20004, 'No puedes modificar los jugadores una vez generado el calendario');
    END IF;    
END BLOQUEO_CRUD_JUGADOR;

/

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

/

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

/

CREATE OR REPLACE TRIGGER MAX_JUGADOR
BEFORE INSERT OR UPDATE ON Jugador
FOR EACH ROW
DECLARE
v_max_jugadores NUMBER(1) := 6;
v_count_jugadores NUMBER(3);

BEGIN
    SELECT COUNT(*) AS "NUMERO JUGADORES" INTO v_count_jugadores FROM jugador
    WHERE equipo_id_equipo = (:new.equipo_id_equipo);

    IF(v_count_jugadores >= v_max_jugadores) THEN
        raise_application_error(-20000, 'El numero de jugadores por equipo no puede ser superior a 6');
    END IF;  
END MAX_JUGADOR;   

/

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

/

CREATE OR REPLACE TRIGGER SALARIO_MIN_JUGADOR
BEFORE INSERT OR UPDATE ON Jugador
FOR EACH ROW
DECLARE
v_smi NUMBER(4) := 900;
BEGIN
    IF(:new.sueldo <= v_smi) THEN
        raise_application_error(-20001, 'El salario del jugador debe ser superior al SMI');
    END IF;  
END SALARIO_MIN_JUGADOR;   

/

