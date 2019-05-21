/* Inserts de la tabla EQUIPO */

INSERT INTO EQUIPO (nombre,presupuesto,puntos)  VALUES ('fnatic',170000,0);
INSERT INTO EQUIPO (nombre,presupuesto,puntos)  VALUES ('sk telecom t1',180000,0);
INSERT INTO EQUIPO (nombre,presupuesto,puntos)  VALUES ('cloud9',160000,0);
INSERT INTO EQUIPO (nombre,presupuesto,puntos)  VALUES ('tsm',150000,0);
INSERT INTO EQUIPO (nombre,presupuesto,puntos)  VALUES ('thunderx3 baskonia',50000,0);
INSERT INTO EQUIPO (nombre,presupuesto,puntos)  VALUES ('mamecorp',100000,5);

COMMIT;


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

INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('yasin','dinçer','nisqy','midlane',1000,1,3);
INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('eric','rtichie','licorice','toplane',1000,1,3);
INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('robert','huang','blaber','jungler',1000,1,3);
INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('tristan','stidam','zeyzal','support',1000,1,3);
INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('zachary','scuderi','sneaky','adcarry',1000,1,3);

--INSERTS JUGADORES TSM 4 

INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('soren','bjerg','bjergsen','midlane',1000,1,4);
INSERT INTO JUGADOR(nombre,apellido,nickname,posicion,sueldo,titularidad,equipo_id_equipo) VALUES ('sergen','çelik','broken blade','toplane',1000,1,4);
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

COMMIT;

--INSERT PRESIDENTES
INSERT INTO PRESIDENTE (nombre,apellido,equipo_id_equipo)VALUES('sam','mathews',1);
INSERT INTO PRESIDENTE (nombre,apellido,equipo_id_equipo)VALUES('sung','min ha',2);
INSERT INTO PRESIDENTE (nombre,apellido,equipo_id_equipo)VALUES('jack','etienne',3);
INSERT INTO PRESIDENTE (nombre,apellido,equipo_id_equipo)VALUES('andy','dinh',4);
INSERT INTO PRESIDENTE (nombre,apellido,equipo_id_equipo)VALUES('jose antonio','querejeta',5);
INSERT INTO PRESIDENTE (nombre,apellido,equipo_id_equipo)VALUES('eric','con c',6);

COMMIT;

--INSERT LIGA
--INSERT INTO LIGA (nombre,fecha_inicio,fecha_fin,en_curso) VALUES ('MameCorp league', SYSDATE,SYSDATE,1);

--COMMIT;

--INSERT JORNADA 
--INSERT INTO JORNADA (FECHA_INICIO,FECHA_FIN,LIGA_ID_LIGA) VALUES (SYSDATE,SYSDATE+7,1);

--COMMIT;

--INSERT USUARIOS

INSERT INTO USUARIO(nombre,password,tipo) VALUES('mamecorp','mamecorp','admin');
INSERT INTO USUARIO(nombre,password,tipo) VALUES('user','user','user');

COMMIT;


