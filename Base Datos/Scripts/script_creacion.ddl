-- Generado por Oracle SQL Developer Data Modeler 17.2.0.188.1059
--   en:        2019-05-07 18:58:09 CEST
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g



DROP TABLE equipo CASCADE CONSTRAINTS;

DROP TABLE equipopartido CASCADE CONSTRAINTS;

DROP TABLE jornada CASCADE CONSTRAINTS;

DROP TABLE jugador CASCADE CONSTRAINTS;

DROP TABLE partido CASCADE CONSTRAINTS;

DROP TABLE presidente CASCADE CONSTRAINTS;

DROP TABLE usuario CASCADE CONSTRAINTS;

CREATE TABLE equipo (
    id_equipo     INTEGER NOT NULL,
    nombre        VARCHAR2(20 CHAR) NOT NULL,
    presupuesto   INTEGER NOT NULL,
    puntos        INTEGER NOT NULL
);

ALTER TABLE equipo ADD CONSTRAINT equipo_pk PRIMARY KEY ( id_equipo );

CREATE TABLE equipopartido (
    equipo_id_equipo     INTEGER NOT NULL,
    partido_id_partido   INTEGER NOT NULL
);

ALTER TABLE equipopartido ADD CONSTRAINT equipopartido_pk PRIMARY KEY ( equipo_id_equipo,partido_id_partido );

CREATE TABLE jornada (
    id_jornada     INTEGER NOT NULL,
    fecha_inicio   DATE NOT NULL,
    fecha_fin      DATE NOT NULL
);

ALTER TABLE jornada ADD CONSTRAINT jornada_pk PRIMARY KEY ( id_jornada );

CREATE TABLE jugador (
    id_jugador         INTEGER NOT NULL,
    nombre             VARCHAR2(20 CHAR) NOT NULL,
    apellido           VARCHAR2(20 CHAR) NOT NULL,
    nickname           VARCHAR2(20 CHAR) NOT NULL,
    posicion           VARCHAR2(20 CHAR) NOT NULL,
    sueldo             INTEGER NOT NULL,
    equipo_id_equipo   INTEGER NOT NULL
);

ALTER TABLE jugador ADD CONSTRAINT jugador_pk PRIMARY KEY ( id_jugador );

CREATE TABLE partido (
    id_partido               INTEGER NOT NULL,
    id_equipo_local          INTEGER NOT NULL,
    id_equipo_visitante      INTEGER NOT NULL,
    vencedor                 INTEGER,
    tipo                     VARCHAR2(20 CHAR) NOT NULL,
    fecha_inicio             TIMESTAMP NOT NULL,
    fecha_fin                TIMESTAMP,
    kills_equipo_local       INTEGER,
    kills_equipo_visitante   INTEGER,
    oro_equipo_local         INTEGER,
    oro_equipo_visitante     INTEGER,
    jornada_id_jornada       INTEGER NOT NULL,
    mvp                      INTEGER NOT NULL
);

ALTER TABLE partido ADD CONSTRAINT partido_pk PRIMARY KEY ( id_partido );

CREATE TABLE presidente (
    id_presidente      INTEGER NOT NULL,
    nombre             VARCHAR2(20 CHAR) NOT NULL,
    apellido           VARCHAR2(20 CHAR) NOT NULL,
    equipo_id_equipo   INTEGER NOT NULL
);

ALTER TABLE presidente ADD CONSTRAINT presidente_pk PRIMARY KEY ( id_presidente );

CREATE TABLE usuario (
    id_usuario   INTEGER NOT NULL,
    nombre       VARCHAR2(20 CHAR) NOT NULL,
    password     VARCHAR2(20 CHAR) NOT NULL,
    tipo         VARCHAR2(20 CHAR) NOT NULL
);

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( id_usuario );

ALTER TABLE equipopartido
    ADD CONSTRAINT equipopartido_equipo_fk FOREIGN KEY ( equipo_id_equipo )
        REFERENCES equipo ( id_equipo );

ALTER TABLE equipopartido
    ADD CONSTRAINT equipopartido_partido_fk FOREIGN KEY ( partido_id_partido )
        REFERENCES partido ( id_partido );

ALTER TABLE jugador
    ADD CONSTRAINT jugador_equipo_fk FOREIGN KEY ( equipo_id_equipo )
        REFERENCES equipo ( id_equipo );

ALTER TABLE partido
    ADD CONSTRAINT partido_jornada_fk FOREIGN KEY ( jornada_id_jornada )
        REFERENCES jornada ( id_jornada );

ALTER TABLE partido
    ADD CONSTRAINT partido_jugador_fk FOREIGN KEY ( mvp )
        REFERENCES jugador ( id_jugador );

ALTER TABLE presidente
    ADD CONSTRAINT presidente_equipo_fk FOREIGN KEY ( equipo_id_equipo )
        REFERENCES equipo ( id_equipo );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             7
-- CREATE INDEX                             0
-- ALTER TABLE                             13
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
