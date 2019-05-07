--INSERT INTO table_name
--VALUES (value1, value2, value3, ...); 



/* Inserts de la tabla EQUIPO */

INSERT INTO EQUIPO VALUES (1,'fnatic',170000,0);
INSERT INTO EQUIPO VALUES (2,'sk telecom t1',180000,0);
INSERT INTO EQUIPO VALUES (3,'cloud9',160000,0);
INSERT INTO EQUIPO VALUES (4,'tsm',150000,0);
INSERT INTO EQUIPO VALUES (5,'thunderx3 baskonia',50000,0);
INSERT INTO EQUIPO VALUES (6,'mamecorp',200000,5);


/* Inserts de la tabla CLASIFICACION */
INSERT INTO CLASIFICACION VALUES (1,'liga justicia',1);


/* Inserts de la tabla EQUIPOPARTIDO */


/* Inserts de la tabla ESTADISTICAS */


/* Inserts de la tabla JORNADA */ 

INSERT INTO JORNADA VALUES (1,1,SYSDATE,SYSDATE+5);


/* Inserts de la tabla JUGADOR */

--INSERTS JUGADORES FNATIC 1
INSERT INTO JUGADOR VALUES (1,'tim','liposev','nemesis','midlane',1000,1);
INSERT INTO JUGADOR VALUES (2,'gabriel','rau','bwipo','toplane',1000,1);
INSERT INTO JUGADOR VALUES (3,'mads','brok-pedersen','broxah','jungler',1000,1);
INSERT INTO JUGADOR VALUES (4,'zdravets','galabov','hylissang','support',1000,1);
INSERT INTO JUGADOR VALUES (5,'martin','larsson','rekkles','adcarry',1000,1);

--INSERTS JUGADORES SK TELECOM T1 2
INSERT INTO JUGADOR VALUES (6,'lee','sang-hyeok','faker','midlane',1000,2);
INSERT INTO JUGADOR VALUES (7,'kim','jae-hee','crazy','toplane',1000,2);
INSERT INTO JUGADOR VALUES (8,'kang','min-seung','haru','jungler',1000,2);
INSERT INTO JUGADOR VALUES (9,'cho','se-hyeong','mata','support',1000,2);
INSERT INTO JUGADOR VALUES (10,'park','jin-seong','teddy','adcarry',1000,2);

--INSERTS JUGADORES CLOUD9 3

INSERT INTO JUGADOR VALUES (11,'yasin','dinçer','nisqy','midlane',1000,3);
INSERT INTO JUGADOR VALUES (12,'eric','rtichie','licorice','toplane',1000,3);
INSERT INTO JUGADOR VALUES (13,'robert','huang','blaber','jungler',1000,3);
INSERT INTO JUGADOR VALUES (14,'tristan','stidam','zeyzal','support',1000,3);
INSERT INTO JUGADOR VALUES (15,'zachary','scuderi','sneaky','adcarry',1000,3);

--INSERTS JUGADORES TSM 4 

INSERT INTO JUGADOR VALUES (16,'soren','bjerg','bjergsen','midlane',1000,4);
INSERT INTO JUGADOR VALUES (17,'sergen','çelik','broken blade','toplane',1000,4);
INSERT INTO JUGADOR VALUES (18,'matthew','higginotham','akaadian','jungler',1000,4);
INSERT INTO JUGADOR VALUES (19,'andy','ta','smoothie','support',1000,4);
INSERT INTO JUGADOR VALUES (20,'jesper','svenningsen','zven','adcarry',1000,4);

--INSERTS JUGADORES THUNDERX3 BASKONIA 5

INSERT INTO JUGADOR VALUES (21,'danny','le comite','dan dan','toplane',1000,5);
INSERT INTO JUGADOR VALUES (22,'sergio','martin','diamond','midlane',1000,5);
INSERT INTO JUGADOR VALUES (23,'ignacio','garcia','itsi','jungler',1000,5);
INSERT INTO JUGADOR VALUES (24,'adrain','moldes','homi','support',1000,5);
INSERT INTO JUGADOR VALUES (25,'alejandro','gonzalez','darkside','adcarry',1000,5);

--INSERT JUGADORES MAMECORP 6
INSERT INTO JUGADOR VALUES (26,'julen','castillo','castiskate','midlane',3000,6);
INSERT INTO JUGADOR VALUES (27,'adrian','danlos','godskater','toplane',3000,6);
INSERT INTO JUGADOR VALUES (28,'julen','prieto','peto','jungler',3000,6);


/* Inserts de la tabla PARTIDO */

/* Inserts de la tabla PRESIDENTE */





/* Inserts de la tabla SESION */

INSERT INTO SESION VALUES(1,'mamecorp','mamecorp','admin');
INSERT INTO SESION VALUES(2,'user','user','user');