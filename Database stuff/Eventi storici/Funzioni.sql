CREATE OR REPLACE FUNCTION ReturnID (NameIN IN CHAR)
RETURN NUMBER IS
 CURSOR Identificativi(Name CHAR) IS
    SELECT ID FROM PersonaggioStorico
    WHERE PersonaggioStorico.Nome=Name;
Ident Identificativi%ROWTYPE;
Identificativo NUMBER(6);
 BEGIN
     Identificativo := -1;
     OPEN Identificativi(NameIN);
     LOOP
     FETCH Identificativi INTO Ident;
     EXIT WHEN Identificativi%NOTFOUND;
     IF(Identificativi%FOUND)
         THEN
     Identificativo:=Ident.ID;
     END IF;
     END LOOP;
RETURN Identificativo;
END ReturnID;
/
    
CREATE OR REPLACE FUNCTION ReturnName (IDIN IN NUMBER)
RETURN CHAR IS
 CURSOR Identificativi(Ident NUMBER) IS
    SELECT Nome FROM PersonaggioStorico
    WHERE PersonaggioStorico.ID=Ident;
Ident Identificativi%ROWTYPE;
Identificativo CHAR(60);
 BEGIN
     Identificativo := 'N';
     OPEN Identificativi(IDIN);
     LOOP
     FETCH Identificativi INTO Ident;
     EXIT WHEN Identificativi%NOTFOUND;
     IF(Identificativi%FOUND)
         THEN
     Identificativo:=Ident.Nome;
     END IF;
     END LOOP;
RETURN Identificativo;
END ReturnName;
/
CREATE OR REPLACE FUNCTION ReturnAttID (NameIN IN CHAR,ValIN IN CHAR)
RETURN NUMBER IS
 CURSOR Identificativi(Name CHAR,Valore CHAR) IS
    SELECT AttID FROM Attributo
    WHERE Attributo.Nome=Name AND Attributo.Valore=ValIN;
Ident Identificativi%ROWTYPE;
Identificativo NUMBER(5);
 BEGIN
     Identificativo := -1;
     OPEN Identificativi(NameIN,ValIN);
     LOOP
     FETCH Identificativi INTO Ident;
     EXIT WHEN Identificativi%NOTFOUND;
     IF(Identificativi%FOUND)
         THEN
     Identificativo:=Ident.AttID;
     END IF;
     END LOOP;
RETURN Identificativo;
END ReturnAttID;
/
    
CREATE OR REPLACE FUNCTION ReturnAttName (IDIN IN NUMBER)
RETURN CHAR IS
 CURSOR Identificativi(Ident NUMBER) IS
    SELECT Nome FROM Attributo
    WHERE Attributo.AttID=Ident;
Ident Identificativi%ROWTYPE;
Identificativo CHAR(25);
 BEGIN
     Identificativo := 'N';
     OPEN Identificativi(IDIN);
     LOOP
     FETCH Identificativi INTO Ident;
     EXIT WHEN Identificativi%NOTFOUND;
     IF(Identificativi%FOUND)
         THEN
     Identificativo:=Ident.Nome;
     END IF;
     END LOOP;
RETURN Identificativo;
END ReturnAttName;