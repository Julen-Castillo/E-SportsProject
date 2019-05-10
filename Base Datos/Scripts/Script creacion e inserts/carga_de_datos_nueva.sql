/*SCRIPT DE CARGA DE DATOS A LA BASE DE DATOS E-SPORTS || MAMECORP COMPANY */

/* Inserts de la tabla EQUIPO */

DROP SEQUENCE seq_equipo;

  CREATE SEQUENCE seq_equipo
  	START WITH 10
  	INCREMENT BY 10
  	MAXVALUE 2000
  	MINVALUE 10
  	NOCYCLE;

INSERT INTO EQUIPO VALUES (seq_equipo.nextval,'fnatic',170000,0);
INSERT INTO EQUIPO VALUES (seq_equipo.nextval,'sk telecom t1',180000,0);
INSERT INTO EQUIPO VALUES (seq_equipo.nextval,'cloud9',160000,0);
INSERT INTO EQUIPO VALUES (seq_equipo.nextval,'tsm',150000,0);
INSERT INTO EQUIPO VALUES (seq_equipo.nextval,'thunderx3 baskonia',50000,0);
INSERT INTO EQUIPO VALUES (seq_equipo.nextval,'mamecorp',200000,5);

commit;
/* Inserts de la tabla JUGADOR */

DROP SEQUENCE seq_jugador;

 CREATE SEQUENCE seq_jugador
  	START WITH 1
  	INCREMENT BY 1
  	MAXVALUE 9999
  	MINVALUE 1
  	NOCYCLE;

--INSERTS JUGADORES FNATIC 1
INSERT INTO JUGADOR VALUES (seq_jugador.nextval,'tim','liposev','nemesis','midlane',1000,1,10);
INSERT INTO JUGADOR VALUES (seq_jugador.nextval,'gabriel','rau','bwipo','toplane',1000,1,10);
INSERT INTO JUGADOR VALUES (seq_jugador.nextval,'mads','brok-pedersen','broxah','jungler',1000,1,10);
INSERT INTO JUGADOR VALUES (seq_jugador.nextval,'zdravets','galabov','hylissang','support',1000,1,10);
INSERT INTO JUGADOR VALUES (seq_jugador.nextval,'martin','larsson','rekkles','adcarry',1000,1,10);

--INSERTS JUGADORES SK TELECOM T1 2
INSERT INTO JUGADOR VALUES (seq_jugador.nextval,'lee','sang-hyeok','faker','midlane',1000,1,20);
INSERT INTO JUGADOR VALUES (seq_jugador.nextval,'kim','jae-hee','crazy','toplane',1000,1,20);
INSERT INTO JUGADOR VALUES (seq_jugador.nextval,'kang','min-seung','haru','jungler',1000,1,20);
INSERT INTO JUGADOR VALUES (seq_jugador.nextval,'cho','se-hyeong','mata','support',1000,1,20);
INSERT INTO JUGADOR VALUES (seq_jugador.nextval,'park','jin-seong','teddy','adcarry',1000,1,20);

--INSERTS JUGADORES CLOUD9 3

INSERT INTO JUGADOR VALUES (seq_jugador.nextval,'yasin','dinçer','nisqy','midlane',1000,1,30);
INSERT INTO JUGADOR VALUES (seq_jugador.nextval,'eric','rtichie','licorice','toplane',1000,1,30);
INSERT INTO JUGADOR VALUES (seq_jugador.nextval,'robert','huang','blaber','jungler',1000,1,30);
INSERT INTO JUGADOR VALUES (seq_jugador.nextval,'tristan','stidam','zeyzal','support',1000,1,30);
INSERT INTO JUGADOR VALUES (seq_jugador.nextval,'zachary','scuderi','sneaky','adcarry',1000,1,30);

--INSERTS JUGADORES TSM 4 

INSERT INTO JUGADOR VALUES (seq_jugador.nextval,'soren','bjerg','bjergsen','midlane',1000,1,40);
INSERT INTO JUGADOR VALUES (seq_jugador.nextval,'sergen','çelik','broken blade','toplane',1000,1,40);
INSERT INTO JUGADOR VALUES (seq_jugador.nextval,'matthew','higginotham','akaadian','jungler',1000,1,40);
INSERT INTO JUGADOR VALUES (seq_jugador.nextval,'andy','ta','smoothie','support',1000,1,40);
INSERT INTO JUGADOR VALUES (seq_jugador.nextval,'jesper','svenningsen','zven','adcarry',1000,1,40);

--INSERTS JUGADORES THUNDERX3 BASKONIA 5

INSERT INTO JUGADOR VALUES (seq_jugador.nextval,'danny','le comite','dan dan','toplane',1000,1,50);
INSERT INTO JUGADOR VALUES (seq_jugador.nextval,'sergio','martin','diamond','midlane',1000,1,50);
INSERT INTO JUGADOR VALUES (seq_jugador.nextval,'ignacio','garcia','itsi','jungler',1000,1,50);
INSERT INTO JUGADOR VALUES (seq_jugador.nextval,'adrain','moldes','homi','support',1000,1,50);
INSERT INTO JUGADOR VALUES (seq_jugador.nextval,'alejandro','gonzalez','darkside','adcarry',1000,1,50);

--INSERT JUGADORES MAMECORP 6
INSERT INTO JUGADOR VALUES (seq_jugador.nextval,'julen','castillo','castiskate','midlane',3000,1,60);
INSERT INTO JUGADOR VALUES (seq_jugador.nextval,'adrian','danlos','godskater','toplane',3000,1,60);
INSERT INTO JUGADOR VALUES (seq_jugador.nextval,'julen','prieto','peto','jungler',3000,1,60);

commit;

/*Insert de la tabla PRESIDENTE*/

DROP SEQUENCE seq_presidente;

   CREATE SEQUENCE seq_presidente
  	START WITH 101
  	INCREMENT BY 1
  	MAXVALUE 99999
  	MINVALUE 1
  	NOCYCLE;

INSERT INTO PRESIDENTE VALUES(seq_presidente.nextval,'sam','mathews',10);
INSERT INTO PRESIDENTE VALUES(seq_presidente.nextval,'sung','min ha',20);
INSERT INTO PRESIDENTE VALUES(seq_presidente.nextval,'jack','etienne',30);
INSERT INTO PRESIDENTE VALUES(seq_presidente.nextval,'andy','dinh',40);
INSERT INTO PRESIDENTE VALUES(seq_presidente.nextval,'jose antonio','querejeta',50);
INSERT INTO PRESIDENTE VALUES(seq_presidente.nextval,'eric','con c',60);

commit;

/*Insert de la tabla LIGA*/

DROP SEQUENCE seq_liga;

 CREATE SEQUENCE seq_liga
  	START WITH 1
  	INCREMENT BY 1
  	MAXVALUE 99
  	MINVALUE 1
  	NOCYCLE;


INSERT INTO LIGA VALUES (seq_liga.nextval,'MameCorp league', SYSDATE,SYSDATE,1);

commit;

/* Inserts de la tabla JORNADA */ 

DROP SEQUENCE seq_jornada;

  CREATE  SEQUENCE seq_jornada
  	START WITH 1
  	INCREMENT BY 1
  	MAXVALUE 9999
  	MINVALUE 1
  	NOCYCLE;


INSERT INTO JORNADA VALUES (seq_jornada.nextval,SYSDATE,SYSDATE+7,1);

commit;

/* Inserts de la tabla PARTIDO */


INSERT INTO PARTIDO VALUES (10,1,20,10,0,SYSDATE,SYSDATE + 2595/86400,15,20,230000,250000);

commit;


/*ALTERAR EL SYSDATE PARA QUE MUESTRE HORAS24:MINUTOS:SEGUNDOS  */

ALTER SESSION SET nls_date_format = 'dd-mm-yyyy hh24:mi:ss';

--SUMAR 40 MINUTOS
--sysdate + 40 / 1440

--SUMAR 15 SEGUNDOS
--sysdate + 15 / 86400

--43 MINUTOS 15 SEGUNDOS
--SYSDATE + 2595/86400

/* Inserts de la tabla USUARIO */
DROP SEQUENCE seq_usuario;

  CREATE SEQUENCE seq_usuario
  	START WITH 1000
  	INCREMENT BY 100
  	MAXVALUE 9900
  	MINVALUE 1
  	NOCYCLE;

INSERT INTO USUARIO VALUES(1,'mamecorp','mamecorp','admin');
INSERT INTO USUARIO VALUES(2,'user','user','user');

commit;