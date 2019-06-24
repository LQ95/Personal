CREATE SEQUENCE Personaggio_SEQ
INCREMENT BY 1
START WITH 1;
CREATE SEQUENCE Attributo_SEQ
INCREMENT BY 1
START WITH 1;
CREATE SEQUENCE AttInclasse_SEQ
INCREMENT BY 1
START WITH 1;
CREATE OR REPLACE TRIGGER ControlloEv
BEFORE INSERT OR UPDATE ON EventoStorico --Più che vincolare questo da solo un avvertimento
FOR EACH ROW
DECLARE CURSOR CronologiaC IS
    SELECT Segue,Precede FROM Cronologia;
    Cron CronologiaC%ROWTYPE;
    trovato BOOLEAN;
    Begin
    IF  :NEW.Data IS NULL
    THEN 
         trovato := FALSE;
         OPEN CronologiaC;
         LOOP
           FETCH CronologiaC  INTO Cron;
           EXIT WHEN CronologiaC%NOTFOUND;
           IF(Cron.Segue = :NEW.Nome OR Cron.Precede = :NEW.Nome)
               THEN
               trovato :=TRUE;
           END IF;
         END LOOP;
     IF(trovato=FALSE)
        THEN
        DBMS_OUTPUT.PUT_LINE('Questo evento non ha datazione,è suggeribile assegnargli una data od una cronologia');
      END IF;
    END IF;
    CLOSE CronologiaC;
    END;
 /  
    
CREATE OR REPLACE TRIGGER ControlloPeriodo
BEFORE INSERT OR UPDATE ON PeriodoStorico
FOR EACH ROW
    BEGIN
    IF((:NEW.Estremo1 IS NULL AND :NEW.Estremo2 IS NULL AND :New.Datainiz IS NULL AND :NEW.DataFine IS NULL)
        OR(:NEW.Estremo1 IS NULL AND :NEW.Datainiz IS NULL AND(:NEW.Offset IS NULL Or :NEW.Offset=0))
        OR(:New.Estremo2 IS NULL AND :NEW.DataFine IS NULL AND (:NEW.Offset IS NULL Or :NEW.Offset=0))
        )
    THEN
    RAISE_APPLICATION_ERROR(-20015,'Questo periodo non ha una datazione sensata');
    END IF;
    END;
/    
    
CREATE OR REPLACE TRIGGER ControlloLoc
BEFORE INSERT OR UPDATE ON Localizzazione
FOR EACH ROW
DECLARE 
 CURSOR DatePersStor(IDP NUMBER) IS
    Select DataN,DataM FROM PersonaggioStorico WHERE PersonaggioStorico.ID=IDP;
 DatePS DatePersStor%ROWTYPE;
 
 CURSOR DateEv(N CHAR ) IS
    SELECT Data FROM EventoStorico WHERE EventoStorico.Nome=N; 
 DateEventi DateEv%ROWTYPE;
 
 CURSOR DataP(S CHAR) IS
     SELECT Datainiz,DataFine FROM PeriodoStorico WHERE PeriodoStorico.Name=S; 
  DatePer DataP%ROWTYPE;
  BEGIN
  OPEN DataP(:NEW.NomePeriodo);
  LOOP
    FETCH DataP INTO DatePer;                             --Prendiamo i dati necessari dalla tabella dei periodi
    EXIT WHEN DataP%NOTFOUND;
  END LOOP;
  IF(:NEW.PersID IS NULL OR :NEW.PersID=0)
    THEN
        IF(:NEW.NomeE='x')
          THEN 
          RAISE_APPLICATION_ERROR(-20030,'Non sono stati definiti nè un personaggio nè un evento da localizzare');  --Annulla l'inserimento perchè privo di senso
        ELSE
          :NEW.PersID:=0 ;--Ridondante ma di sicurezza
          OPEN DateEv(:NEW.NomeE);           --Se il personaggio non è stato definito prendi i dati dall'evento
           LOOP
               FETCH DateEv INTO DateEventi;
               EXIT WHEN DateEv%NOTFOUND;
           END LOOP;
           IF(DateEventi.Data<DatePer.Datainiz OR DateEventi.Data>DatePer.DataFine)                                        
                THEN                                    --Controllo errori se definito l'evento
                RAISE_APPLICATION_ERROR(-20020,'Incoerenza temporale tra evento e tempo storico');
           END IF;
        END IF;
   ELSE
        IF(:NEW.NomeE='x' OR :NEW.NomeE IS NULL)
          THEN
              :NEW.NomeE :='x';
              OPEN DatePersStor(:NEW.PersID); --E viceversa se l'evento non è definito,prende i dati di entrambi se definiti
              LOOP
                 FETCH DatePersStor INTO DatePS;
                 EXIT WHEN DatePersStor%NOTFOUND;
              END LOOP;
              IF(DatePS.DataM<DatePer.Datainiz OR DatePS.DataN>DatePer.DataFine)                                        
                  THEN                                    --Controllo errori se definito solo il personaggio
                  RAISE_APPLICATION_ERROR(-20020,'Incoerenza temporale tra personaggio e tempo storico');
              END IF;
        ELSE 
             OPEN DatePersStor(:NEW.PersID);  --Sono definiti entrambi in questo caso
             OPEN DateEv(:NEW.NomeE); 
             LOOP
                 FETCH DatePersStor INTO DatePS;             
                 EXIT WHEN DatePersStor%NOTFOUND;
             END LOOP;
             LOOP
                 FETCH DateEv INTO DateEventi;
                 EXIT WHEN DateEv%NOTFOUND;
             END LOOP;
             IF((DateEventi.Data<DatePer.Datainiz OR DateEventi.Data>DatePer.DataFine)
                 OR(DatePS.DataM<DatePer.Datainiz OR DatePS.DataN>DatePer.DataFine))                                        
                 THEN                                    --Controllo errori se definiti entrambi
                 RAISE_APPLICATION_ERROR(-20020,'Incoerenza temporale tra personaggio e/o evento e tempo storico');
             END IF;
       END IF;
   END IF;
 END;
 /
    
CREATE OR REPLACE TRIGGER GestioneAttInClasse
BEFORE INSERT OR UPDATE ON AttInClasse
FOR EACH ROW
    Begin
    IF :NEW.PersID IS NULL AND :NEW.EventID IS NULL  --Uno di questi due deve essere non nullo
     THEN
    RAISE_APPLICATION_ERROR(-20019,'Questa associazione non ha senso.');
    END IF;
    END;
/
CREATE OR REPLACE TRIGGER GestionePersonaggio
BEFORE INSERT OR UPDATE ON PersonaggioStorico
FOR EACH ROW
DECLARE
  CURSOR Pers IS
  SELECT ID FROM PersonaggioStorico;
  IDRec Pers%ROWTYPE;
  tmp NUMBER(6);
    Begin
       IF :NEW.ID IS NULL OR :NEW.ID = 0 
         THEN
         tmp := Personaggio_SEQ.NEXTVAL;
         OPEN Pers;
         LOOP
           FETCH Pers INTO IDRec;
           EXIT WHEN Pers%NOTFOUND;
           IF :NEW.ID =IDrec.ID
             THEN  
             tmp := Personaggio_SEQ.NEXTVAL +1;
           END IF;
         END LOOP;
       :NEW.ID := tmp;
       END IF;
    EXCEPTION 
        WHEN DUP_VAL_ON_INDEX THEN
        :NEW.ID := :NEW.ID * Personaggio_SEQ.NEXTVAL;
        INSERT INTO PersonaggioStorico VALUES(:NEW.Nome,:NEW.DataN,:NEW.DataM,:NEW.ID);
    END;
 /

CREATE OR REPLACE TRIGGER ContCron
BEFORE INSERT OR UPDATE ON Cronologia
FOR EACH ROW
  DECLARE
  CURSOR Cronolog IS
  SELECT Segue,Precede FROM Cronologia;
  Crono Cronolog%ROWTYPE;
  BEGIN
  OPEN Cronolog;
      LOOP
      FETCH Cronolog INTO Crono;
      EXIT WHEN Cronolog%NOTFOUND;
      IF(:NEW.Precede = Crono.Segue AND :NEW.Segue = Crono.Precede)
          THEN
          RAISE_APPLICATION_ERROR(-20008,'Non possono esistere due cronologie opposte');
          END IF;
      END LOOP;
  END;
/

CREATE OR REPLACE TRIGGER IdentificazAutomAtt
BEFORE INSERT ON Attributo
FOR EACH ROW
  BEGIN
  :NEW.AttID:=Attributo_SEQ.NEXTVAL;
  END;
/
    
CREATE OR REPLACE TRIGGER IdentificazAutomAttInClasse
BEFORE INSERT ON AttInCLasse
FOR EACH ROW
  BEGIN
  :NEW.AssID:=AttInClasse_SEQ.NEXTVAL;
  END;