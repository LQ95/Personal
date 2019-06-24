ALTER TABLE EventoStorico
DISABLE ALL TRIGGERS;

ALTER TABLE PersonaggioStorico
DISABLE ALL TRIGGERS;

ALTER TABLE PeriodoStorico
DISABLE ALL TRIGGERS;

ALTER TABLE Localizzazione
DISABLE ALL TRIGGERS;

ALTER TABLE Cronologia
DISABLE ALL TRIGGERS;
INSERT INTO EventoStorico VALUES ('Caduta impero romano d°occidente',TO_DATE('14/8/476','DD/MM/YYYY'));
INSERT INTO EventoStorico VALUES ('Nascita di Gesù',TO_DATE('25/12/-1','DD/MM/SYYYY'));
INSERT INTO EventoStorico VALUES ('Invenzione della scrittura',TO_DATE('1/1/-4712','DD/MM/SYYYY'));
INSERT INTO PeriodoStorico VALUES('Invenzione della scrittura','Caduta impero romano d°occidente',0,'Storia antica',NULL,NULL,'');
INSERT INTO Localizzazione VALUES(ReturnID('N'),'Nascita di Gesù','Storia antica');
INSERT INTO PersonaggioStorico VALUES('Hammurabi',NULL,NULL,1);
INSERT INTO Cronologia VALUES('Nascita di Gesù','Caduta impero romano d°occidente',32);
INSERT INTO Localizzazione VALUES (ReturnID('Hammurabi'),'x','Storia antica');
INSERT INTO EventoStorico  VALUES('Battaglia delle Termopili',TO_DATE('19/8/-480','DD/MM/SYYYY'));
INSERT INTO PersonaggioStorico VALUES('Leonida',NULL,TO_DATE('21/8/-480','DD/MM/SYYYY'),300);
INSERT INTO PersonaggioStorico VALUES('Gaio Giulio Cesare',NULL,TO_DATE('15/3/-44','DD/MM/SYYYY'),44);
INSERT INTO EventoStorico VALUES ('Attraversamento del Rubicone',TO_DATE('15/3/-49','DD/MM/SYYYY'));
INSERT INTO Localizzazione VALUES(ReturnID('Gaio Giulio Cesare'),'x','Storia antica');
INSERT INTO Coinvolgimento VALUES('Attraversamento del Rubicone',ReturnID('Gaio Giulio Cesare'),'Gaio Giulio Cesare');
INSERT INTO PeriodoStorico VALUES('Presa della Bastiglia','Congresso Di Vienna',0,'Rivoluzione Francese',NULL,NULL,'Evento storico in cui si affermano i principi di uguaglianza egalità e liberta che influenzeranno la vita politica dell°Occidente fino alla Grande Guerra');
INSERT INTO Attributo VALUES('DataIncerta','SoloAnno','S',NULL);
INSERT INTO Attributo VALUES('DataIncerta','Totalmente','S',NULL);
INSERT INTO AttInclasse VALUES(ReturnAttID('DataIncerta','SoloAnno'),NULL,'Battaglia delle Termopili',NULL);
INSERT INTO AttInclasse VALUES(ReturnAttID('DataIncerta','Totalmente'),NULL,'Invenzione della scrittura',NULL);
INSERT INTO EventoStorico VALUES('Presa della Bastiglia',TO_DATE('14/7/1789','DD/MM/YYYY'));
INSERT INTO EventoStorico VALUES('Congresso Di Vienna',TO_DATE('9/6/1815','DD/MM/YYYY'));
INSERT INTO PersonaggioStorico VALUES('Maximilien de Roberspierre',TO_DATE('6/5/1758','DD/MM/YYYY'),TO_DATE('28/7/1815','DD/MM/YYYY'),143);
INSERT INTO PersonaggioStorico VALUES('Napoleone Bonaparte',TO_DATE('15/8/1815','DD/MM/YYYY'),TO_DATE('5/5/1821','DD/MM/YYYY'),4124);

INSERT INTO EventoStorico VALUES ('x',NULL);    
INSERT INTO PersonaggioStorico VALUES ('N',NULL,NULL,0); 

/* Questi due valori qui sopra sono necessari per il funzionamento di due trigger dove sono valori nulli */
/* Le funzioni ReturnID e ReturnAttID si trovano nel file Funzioni.sql */
ALTER TABLE EventoStorico
ENABLE ALL TRIGGERS;

ALTER TABLE PersonaggioStorico
ENABLE ALL TRIGGERS;

ALTER TABLE PeriodoStorico
ENABLE ALL TRIGGERS;

ALTER TABLE Localizzazione
ENABLE ALL TRIGGERS;


ALTER TABLE Cronologia
ENABLE ALL TRIGGERS;