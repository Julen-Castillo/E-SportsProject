DROP TABLE equipo CASCADE CONSTRAINTS;

DROP TABLE jornada CASCADE CONSTRAINTS;

DROP TABLE jugador CASCADE CONSTRAINTS;

DROP TABLE liga CASCADE CONSTRAINTS;

DROP TABLE partido CASCADE CONSTRAINTS;

DROP TABLE presidente CASCADE CONSTRAINTS;

DROP TABLE usuario CASCADE CONSTRAINTS;

CREATE TABLE equipo (
    id_equipo     NUMBER GENERATED ALWAYS AS IDENTITY, 
    nombre        VARCHAR2(20 CHAR) NOT NULL,
    presupuesto   INTEGER NOT NULL,
    puntos        INTEGER NOT NULL
);

ALTER TABLE equipo ADD CONSTRAINT equipo_pk PRIMARY KEY ( id_equipo );

CREATE TABLE jornada (
    id_jornada     NUMBER GENERATED ALWAYS AS IDENTITY, 
    fecha_inicio   DATE NOT NULL,
    fecha_fin      DATE NOT NULL,
    liga_id_liga   INTEGER NOT NULL
);

ALTER TABLE jornada ADD CONSTRAINT jornada_pk PRIMARY KEY ( id_jornada );

CREATE TABLE jugador (
    id_jugador         NUMBER GENERATED ALWAYS AS IDENTITY, 
    nombre             VARCHAR2(20 CHAR) NOT NULL,
    apellido           VARCHAR2(20 CHAR) NOT NULL,
    nickname           VARCHAR2(20 CHAR) NOT NULL,
    posicion           VARCHAR2(20 CHAR) NOT NULL,
    sueldo             INTEGER NOT NULL,
    titularidad        CHAR(1) NOT NULL,
    equipo_id_equipo   INTEGER NOT NULL
);

ALTER TABLE jugador ADD CONSTRAINT jugador_pk PRIMARY KEY ( id_jugador );

CREATE TABLE liga (
    id_liga        NUMBER GENERATED ALWAYS AS IDENTITY, 
    nombre         VARCHAR2(20 CHAR) NOT NULL,
    fecha_inicio   DATE NOT NULL,
    fecha_fin      DATE,
    en_curso       CHAR(1) NOT NULL
);

ALTER TABLE liga ADD CONSTRAINT liga_pk PRIMARY KEY ( id_liga );

CREATE TABLE partido (
    equipo_id_equipo         INTEGER NOT NULL,
    jornada_id_jornada       INTEGER NOT NULL,
    equipo_visitante         INTEGER NOT NULL,
    vencedor                 INTEGER,
    tipo                     CHAR(1),
    fecha_inicio             DATE,
    fecha_fin                DATE,
    kills_equipo_local       INTEGER,
    kills_equipo_visitante   INTEGER,
    oro_equipo_local         INTEGER,
    oro_equipo_visitante     INTEGER
);

ALTER TABLE partido ADD CONSTRAINT partido_pk PRIMARY KEY ( equipo_id_equipo,jornada_id_jornada );

CREATE TABLE presidente (
    id_presidente      NUMBER GENERATED ALWAYS AS IDENTITY, 
    nombre             VARCHAR2(20 CHAR) NOT NULL,
    apellido           VARCHAR2(20 CHAR) NOT NULL,
    equipo_id_equipo   INTEGER NOT NULL
);

ALTER TABLE presidente ADD CONSTRAINT presidente_pk PRIMARY KEY ( id_presidente );

CREATE TABLE usuario (
    id_usuario   NUMBER GENERATED ALWAYS AS IDENTITY, 
    nombre       VARCHAR2(20 CHAR) NOT NULL,
    password     VARCHAR2(20 CHAR) NOT NULL,
    tipo         VARCHAR2(20 CHAR) NOT NULL
);

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( id_usuario );

ALTER TABLE jornada
    ADD CONSTRAINT jornada_liga_fk FOREIGN KEY ( liga_id_liga )
        REFERENCES liga ( id_liga );

ALTER TABLE jugador
    ADD CONSTRAINT jugador_equipo_fk FOREIGN KEY ( equipo_id_equipo )
        REFERENCES equipo ( id_equipo );

ALTER TABLE partido
    ADD CONSTRAINT partido_equipo_fk FOREIGN KEY ( equipo_id_equipo )
        REFERENCES equipo ( id_equipo );

ALTER TABLE partido
    ADD CONSTRAINT partido_jornada_fk FOREIGN KEY ( jornada_id_jornada )
        REFERENCES jornada ( id_jornada );

ALTER TABLE presidente
    ADD CONSTRAINT presidente_equipo_fk FOREIGN KEY ( equipo_id_equipo )
        REFERENCES equipo ( id_equipo );
        

--TRIGGERS

--TRIGGER MUTANTE JUGADOR
CREATE OR REPLACE TRIGGER TRIGGER_MUTANTE_JUGADOR
AFTER INSERT OR UPDATE ON JUGADOR
FOR EACH ROW
BEGIN
    PAQUETE_MUTANTE.TITULARIDAD_NEW := :NEW.TITULARIDAD;
    PAQUETE_MUTANTE.TITULARIDAD_OLD := :OLD.TITULARIDAD;
    PAQUETE_MUTANTE.CODIGOEQUIPO := :NEW.EQUIPO_ID_EQUIPO;
    PAQUETE_MUTANTE.SUELDOJUGADOR := :NEW.SUELDO;
    PAQUETE_MUTANTE.SUELDOJUGADOR_OLD := :OLD.SUELDO;
END;

/
--TRIGGER MUTANTE EQUIPO

CREATE OR REPLACE TRIGGER TRIGGER_MUTANTE_EQUIPO
AFTER INSERT OR UPDATE ON EQUIPO
FOR EACH ROW
BEGIN 
    PAQUETE_MUTANTE.PRESUPUESTOEQUIPO := :NEW.PRESUPUESTO;
END;

/

CREATE OR REPLACE TRIGGER TRIGGER_5_TITULARES
AFTER INSERT OR UPDATE ON JUGADOR --ES MUTANTE
DECLARE
v_num_titulares NUMBER(2);
BEGIN
    SELECT COUNT(*)
    INTO v_num_titulares
    FROM JUGADOR
    WHERE titularidad = 1
    AND equipo_id_equipo = PAQUETE_MUTANTE.CODIGOEQUIPO;
    IF INSERTING THEN
        IF(v_num_titulares > 5 AND PAQUETE_MUTANTE.TITULARIDAD_NEW = 1) THEN
            RAISE_APPLICATION_ERROR(-20008, 'Solo puede haber 5 titulares en la plantilla');
        END IF;
    ELSIF UPDATING THEN
        IF(v_num_titulares = 5 AND PAQUETE_MUTANTE.TITULARIDAD_OLD = 0 AND PAQUETE_MUTANTE.TITULARIDAD_NEW = 1) THEN
            RAISE_APPLICATION_ERROR(-20008, 'Solo puede haber 5 titulares en la plantilla');
        END IF;
    END IF;    
END TRIGGER_5_TITULARES;


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
    IF(v_sueldo_total_jug > :new.presupuesto) THEN
        RAISE_APPLICATION_ERROR(-20009, 'El equipo no tiene suficiente prespuesto como para pagar a sus jugadores');
    END IF;
END TRIGGER_EQU_PRES_MEN_SAL_JUG;

/

CREATE OR REPLACE TRIGGER TRIGGER_PRES_EQ_MEN_SAL_JUG
AFTER INSERT OR UPDATE ON JUGADOR --ES MUTANTE
DECLARE
v_sueldo_total_jug NUMBER(9);
v_presupuesto_equipo equipo.presupuesto%TYPE;
BEGIN
    SELECT SUM(SUELDO)
    INTO v_sueldo_total_jug
    FROM JUGADOR
    WHERE EQUIPO_ID_EQUIPO = PAQUETE_MUTANTE.CODIGOEQUIPO;
    SELECT PRESUPUESTO
    INTO v_presupuesto_equipo
    FROM EQUIPO
    WHERE ID_EQUIPO = PAQUETE_MUTANTE.CODIGOEQUIPO; 
    IF INSERTING THEN
        IF(v_sueldo_total_jug + PAQUETE_MUTANTE.SUELDOJUGADOR > v_presupuesto_equipo) THEN
            RAISE_APPLICATION_ERROR(-20009, 'El equipo no tiene suficiente prespuesto como para pagar a este jugador');
        END IF;
    ELSIF UPDATING THEN
        IF(v_sueldo_total_jug - PAQUETE_MUTANTE.SUELDOJUGADOR_OLD + PAQUETE_MUTANTE.SUELDOJUGADOR > v_presupuesto_equipo) THEN
            RAISE_APPLICATION_ERROR(-20009, 'El equipo no tiene suficiente prespuesto como para pagar a este jugador');
        END IF;
    END IF;
    EXCEPTION
    WHEN NO_DATA_FOUND THEN
    v_sueldo_total_jug := 0;
END TRIGGER_PRES_EQ_MEN_SAL_JUG;

/

CREATE OR REPLACE TRIGGER BLOQUEO_CRUD_EQUIPO
BEFORE INSERT OR UPDATE OF ID_EQUIPO, NOMBRE, PRESUPUESTO OR DELETE ON EQUIPO
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
BEFORE INSERT OR UPDATE OF ID_JUGADOR, NOMBRE, APELLIDO, NICKNAME, SUELDO, EQUIPO_ID_EQUIPO OR DELETE ON JUGADOR
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
    WHILE v_id_equipo <= v_num_equipos LOOP --loop para saber cuantos jugadores hay por cada equipo y aplicar la restriccion
        SELECT COUNT(*) INTO v_count_jugador  
        FROM jugador
        WHERE equipo_id_equipo = (v_id_equipo); -- Select para coger la cantidad de jugadores por cada equipo
        IF (v_count_jugador < 2) THEN 
        RAISE_APPLICATION_ERROR(-20003,'Los equipos tienen que tener minimo dos jugadores');
        END IF; 
        v_id_equipo := v_id_equipo + 1;
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
        WHILE v_id_equipo <= v_count_equipos LOOP --Iteramos a través de todos los equipos para determinar si algun equipo está vacío.
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
AFTER INSERT OR UPDATE ON JUGADOR --ES MUTANTE
DECLARE
v_max_jugadores NUMBER(1) := 6;
v_count_jugadores NUMBER(3);
BEGIN
    SELECT COUNT(*) AS "NUMERO JUGADORES" INTO v_count_jugadores FROM jugador
    WHERE equipo_id_equipo = (PAQUETE_MUTANTE.CODIGOEQUIPO);
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
    IF(PAQUETE_MUTANTE.PRESUPUESTOEQUIPO >= v_max_presupuesto) THEN
        raise_application_error(-20002, 'El presupuesto del equipo no puede ser superior a 200k');
    END IF;  
END MAX_PRESUPUESTO_EQUIPO;

/

CREATE OR REPLACE TRIGGER SALARIO_MIN_JUGADOR
BEFORE INSERT OR UPDATE ON JUGADOR 
FOR EACH ROW
DECLARE
v_smi NUMBER(4) := 900;
BEGIN
    IF(:NEW.SUELDO <= v_smi) THEN
        raise_application_error(-20001, 'El salario del jugador debe ser superior al SMI');
    END IF;  
END SALARIO_MIN_JUGADOR;   

/


CREATE OR REPLACE VIEW vista_estadisticas AS
    SELECT FECHA_INICIO "HORA INICIO", ROUND(FECHA_FIN - FECHA_INICIO, 2)*1440 "TIEMPO PARTIDA", KILLS_EQUIPO_LOCAL, KILLS_EQUIPO_VISITANTE, ORO_EQUIPO_LOCAL, ORO_EQUIPO_VISITANTE
    FROM PARTIDO;
    
    

    



