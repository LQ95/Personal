/*
This is HORRENDOUSLY unfinished lol
it was supposed to be an applet to access the database but I never finished it. I want to do exactly that ,sooner or later!
 */
package eventi.storici.java;
 import oracle.jdbc.pool.*;
 import java.sql.*;
 import java.io.Console;
 import java.lang.String;
/**
 *
 * @author LQ95
 */
public class EventiStoriciJava {

    /**
     * @throws java.sql.SQLException
     */
    public static void main(String[] args)throws SQLException{
    OracleDataSource ods;
    String selez,param1,param2,param3;
    ResultSet rSet1 = null;
    Console C;
    PreparedStatement Ricerca = null,Inserimento = null,Cancellazione = null,Modifica,StampaTutti = null,Associa = null; //prepared statements
    String userlog;
    String att1,att2,att3,att4,Keyword;
    int numdel,numup,attint;
    char[] pwlog;
    String log;
    C= System.console();
    ods = new oracle.jdbc.pool.OracleDataSource();
    String url="jdbc:oracle:thin:@//127.0.0.1:8080/xe";
    ods.setURL(url);
    String user="Utente";
    String pw="Password";
    Connection conn=null;
    ods.setUser(user);
    ods.setPassword(pw);
    ods.setDriverType("thin");
    ods.setPortNumber(1521);
    ods.setDatabaseName("xe");
    ods.setServerName("127.0.0.1");
    if (C!=null)
        {
        userlog=C.readLine("inserisci nome utente");
        pwlog=C.readPassword("Inserisci password");
        log= new String(pwlog);
        conn = ods.getConnection(userlog,log);
        selez=C.readLine("Benvenuto del database dei periodi storici.\n Scrivi PS per le operazioni sui periodi storici,E per quelle sugli eventi,A per quelle sugli attributi,P sui peronaggi,EX per uscire:");   
        while(!"EX".equalsIgnoreCase(selez))
            {
                if("PS".equalsIgnoreCase(selez))
                      {
                      while(!"MENU".equalsIgnoreCase(selez))
                                {          
                                selez=C.readLine("\nPersonaggi storici:Premi I per inserire,M per modificare un record preciso,,D per rimuovere un record specifico,R per cercare e stampare l'elemento cercato,S per stampare tutti i record di questa tabella,AS per associare un attributo esistente o nuovo a questa tabella,ASR per rimuoverlo,EV per legarlo ad un evento,EVEL per eliminare questa associazione,PER,per legarlo ad un periodo storico,PEREL per eliminare questa associazione,e MENU per tornare al menù principale:");
                                if("I".equals(selez))
                                     {
                                     att1=C.readLine("inserisci nome del personaggioc he vuoi inserire");
                                     Inserimento=conn.prepareStatement("INSERT INTO PersonaggioStorico VALUES(?,?,?,?)");
                                     Inserimento.setString(1,att1);
                                     Keyword=C.readLine("se vuoi inserire una data di nascita inserisci DN");
                                     if("DN".equalsIgnoreCase(selez))
                                     {
                                     att2=C.readLine("inserisci un mese (espresso come un numero di 2 cifre)");
                                     Inserimento.setString(2,att2);
                                     att2=C.readLine("inserisci un giorno (espresso come un numero di 2 cifre)");
                                     att2=C.readLine("inserisci un anno (espresso come un numero di 4 cifre,negativo se a.C.)");
                                     }
                                     else Inserimento.setString(2,null);
                                     Keyword=C.readLine("se vuoi inserire una data di morte inserisci DN");
                                     if("DM".equalsIgnoreCase(selez))
                                     {
                                     att2=C.readLine("inserisci un mese (espresso come un numero di 2 cifre)");
                                     Inserimento.setString(2,att2);

                                     }
                                     else Inserimento.setString(3,null);
                                     Inserimento.setString(4,null);
                                     rSet1=Inserimento.executeQuery();
                                 }
                        else if("D".equalsIgnoreCase(selez))     
                                {
                                 Keyword=C.readLine("Seleziona il nome del personaggio che vuoi cancellare");
                                 Cancellazione=conn.prepareStatement("DELETE FROM PersonaggioStorico WHERE Nome=?");
                                 Cancellazione.setString(1,Keyword);
                                 numdel=Cancellazione.executeUpdate();
                                }
                        else if("R".equalsIgnoreCase(selez))     
                                {
                                 Keyword=C.readLine("Seleziona il nome del personaggio che vuoi cercare");
                                 Ricerca=conn.prepareStatement("SELECT FROM PersonaggioStorico WHERE Nome=?");   
                                 Ricerca.setString(1,Keyword);
                                 rSet1=Ricerca.executeQuery();
                                 System.out.println(rSet1.getString(1) +"/n");
                                 

                                }
                        else if("M".equalsIgnoreCase(selez))     
                                {
                                Modifica=conn.prepareStatement("UPDATE PersonaggioStorico VALUES  WHERE Nome=? ");
                                Keyword=C.readLine("Seleziona il nome del personaggio che vuoi Modificare");
                                Modifica.setString(5,Keyword);
                                numup=Modifica.executeUpdate();
                                }
                        else if("S".equalsIgnoreCase(selez))     
                                {
                                StampaTutti=conn.prepareStatement("SELECT * FROM PersonaggioStorico ");
                                rSet1=StampaTutti.executeQuery();
                                for (int i=0; rSet1.next(); i++) 
                                            {
                                 System.out.println(rSet1.getString(i) +"/n");
                                            }
                                }
                        else if("AS".equalsIgnoreCase(selez))
                                {
                                
                                }
                         else if("ASR".equalsIgnoreCase(selez))
                                {
                                att1=C.readLine("Seleziona il nome delpersonaggio da cui vuoi cancellare l'attributo");
                                Cancellazione=conn.prepareStatement("SELECT AttID FROM AttInClasse WHERE PersID=(ReturnID(?))");
                                Cancellazione.setString(1,att1);
                                rSet1=Cancellazione.executeQuery();
                                for (int i=0; rSet1.next(); i++) 
                                {System.out.println(rSet1.getString(i) +"/n");}
                                att2=C.readLine("Seleziona il nome dell'attributo che vuoi cancellare");
                                Keyword=C.readLine("Scrivi VAL per cancellare un solo valore dell'attributo");                               
                                if("VAL".equalsIgnoreCase(selez))
                                    {
                                    Cancellazione=conn.prepareStatement("DELETE FROM AttInClasse WHERE PersID=(ReturnID(?)) AND AttID=(ReturnAttID(?,?))");
                                    att3=C.readLine("Seleziona il valore dell'attributo che vuoi cancellare");
                                    Cancellazione.setString(1,att1);
                                    Cancellazione.setString(2,att2);
                                    Cancellazione.setString(3,att3);
                                    numdel=Cancellazione.executeUpdate();
                                    }
                                else{
                                   Cancellazione=conn.prepareStatement("DELETE FROM AttInClasse WHERE PersID=(ReturnID(?)) AND AttID IN (SELECT AttID FROM Attributo WHERE Nome=?");
                                   Cancellazione.setString(1,att1);
                                   Cancellazione.setString(2,att2);
                                   numdel=Cancellazione.executeUpdate();
                                   };
                                }
                         else if("EV".equalsIgnoreCase(selez))
                                {
                                
                                }
                         else if("EVEL".equalsIgnoreCase(selez))
                                {
                                
                                } 
                        else if("PER".equalsIgnoreCase(selez))
                                {
                                
                                }
                        else if("PEREL".equalsIgnoreCase(selez))
                                {
                                
                                }
                             }
                        C.flush();
                        }
                 else if("A".equalsIgnoreCase(selez))
                        {
                        while(!"MENU".equalsIgnoreCase(selez))
                                { 
                                 selez=C.readLine("\nAttributi:Premi I per inserire,M per modificare un record preciso,D per rimuovere un record specifico ,R per cercare e stampare l'elemento cercato,S per stampare tutti i record di questa tabella,e MENU per tornare al menù principale:"); 
                                 if("I".equalsIgnoreCase(selez))
                                                {
                                          Inserimento=conn.prepareStatement("INSERT INTO Attributo VALUES(?,?,?)");
                                          Inserimento.setString(1," ");
                                           rSet1=Inserimento.executeQuery();
                                        }
                                else if("D".equalsIgnoreCase(selez))     
                                     {
                                       Keyword=C.readLine("Seleziona il nome dell'attributo che vuoi cancellare");
                                       Cancellazione=conn.prepareStatement("DELETE FROM Attributo WHERE Nome=?");
                                       Cancellazione.setString(1,Keyword);
                                       rSet1=Cancellazione.executeQuery();
                                       }
                                   else if("R".equalsIgnoreCase(selez))     
                                       {
                                        Keyword=C.readLine("Seleziona il nome dell'attributo che cerchi");
                                        Ricerca=conn.prepareStatement("SELECT FROM Attributo WHERE Nome=?");
                                        Ricerca.setString(1,Keyword);
                                        rSet1=Ricerca.executeQuery();
                                        for (int i=0; rSet1.next(); i++)
                                                    {
                                        System.out.println(rSet1.getString(i) +"/n"); 
                                                    }
                                        }
                                 else if("M".equalsIgnoreCase(selez))     
                                        {
                                        Modifica=conn.prepareStatement("UPDATE Attributo SET ");   
                                        }
                                  else if("S".equalsIgnoreCase(selez))     
                                         {
                                 StampaTutti=conn.prepareStatement("SELECT * FROM PersonaggioStorico ");
                                 rSet1=StampaTutti.executeQuery();
                                 for (int i=0; rSet1.next(); i++) 
                                             {
                                   System.out.println(rSet1.getString(i) +"/n");
                                               }
                                        }
                                }
                        C.flush();
                        }
           else if("E".equalsIgnoreCase(selez))
                 {
                 while(!"MENU".equalsIgnoreCase(selez))
                            {        
                         selez=C.readLine("\nEventi:Premi I per inserire,M per modificare un record preciso,R per cercare e stampare l'elemento cercato,D per rimuovere un record specifico ,S per stampare tutti i record di questa tabella,AS per associare un attributo esistente o nuovo a questa tabella,ASR per rimuoverlo,e qualunque altro tasto per tornare al menù principale:"); 
                          if("I".equalsIgnoreCase(selez))
                                        {
                                  
                                 Inserimento=conn.prepareStatement("INSERT INTO EventoStorico VALUES(?,?,?)");
                                 Keyword=C.readLine("Seleziona il nome dell'evento che vuoi inserire");
                                 Inserimento.setString(1,Keyword);
                                 Keyword=C.readLine("se vuoi inserire una data inserisci DAT");
                                     if("DAT".equalsIgnoreCase(selez))
                                     {
                                     att2=C.readLine("inserisci un mese (espresso come un numero di 2 cifre)");
                                     Inserimento.setString(2,att2);
                                     att2=C.readLine("inserisci un giorno (espresso come un numero di 2 cifre)");
                                     att2=C.readLine("inserisci un anno (espresso come un numero di 4 cifre,negativo se a.C.)");
                                     }
                                     else Inserimento.setString(2,null);
                                 rSet1=Inserimento.executeQuery();
                                         }
                        else if("D".equalsIgnoreCase(selez))     
                                {
                                Keyword=C.readLine("Seleziona il nome dell'evento che vuoi cancellare");
                                Cancellazione=conn.prepareStatement("DELETE FROM EventoStorico WHERE Nome=?");
                                Cancellazione.setString(1,Keyword);
                                numdel=Cancellazione.executeUpdate();
                                }
                        else if("R".equalsIgnoreCase(selez))     
                                {
                                Keyword=C.readLine("Seleziona il nome dell'evento che vuoi cercare");
                                Ricerca=conn.prepareStatement("SELECT FROM EventoStorico WHERE Nome=?");   
                                Ricerca.setString(1,Keyword);
                                rSet1=Ricerca.executeQuery();
                                System.out.println(rSet1.getString(1) +"/n");    
                                }
                        else if("M".equalsIgnoreCase(selez))     
                                {
                                Keyword=C.readLine("Seleziona il nome dell'Evento che vuoi modificare");
                                Modifica=conn.prepareStatement("UPDATE Attributo SET Nome=? Valore=? Tipo=? ");   
                                }
                        else if("S".equalsIgnoreCase(selez))     
                                {
                                StampaTutti=conn.prepareStatement("SELECT * FROM PersonaggioStorico ");
                                rSet1=StampaTutti.executeQuery();
                                for (int i=0; rSet1.next(); i++) 
                                            {
                                 System.out.println(rSet1.getString(i) +"/n");
                                            }   
                                }
                        else if("AS".equalsIgnoreCase(selez))
                                {
                                att1=C.readLine("Seleziona il nome delpersonaggio a cui vuoi associare l'attributo");
                                att2=C.readLine("Seleziona il nome dell'attributo che vuoi inserire");
                                
                                Inserimento=conn.prepareStatement("INSERT IN Attributo VALUES(?,?,?,NULL)");
                                Associa=conn.prepareStatement("INSERT IN AttInClasse VALUES(ReturnAttID(?,?),ReturnID(?),NULL,NULL)");
                                att3=C.readLine("Seleziona il valore dell'attributo che vuoi Inserire");
                                Inserimento.setString(1,att2);
                                Inserimento.setString(2,att3);
                                att4=C.readLine("Se desideri assegnare un tipo specifico all'attributo puoi scegliere I per decidere che è intero o S se una stringa");                               
                                if("I".equalsIgnoreCase(att4))
                                    {
                                       Inserimento.setString(3,att4); 
                                    }
                                else{
                                Inserimento.setString(3,"S");
                                }
                                Associa.setString(1,att2);
                                Associa.setString(2,att3);
                                Associa.setString(3,att1);
                                numdel=Inserimento.executeUpdate();
                                numdel=Associa.executeUpdate();
                                }
                         else if("ASR".equalsIgnoreCase(selez))
                                {
                                att1=C.readLine("Seleziona il nome delpersonaggio da cui vuoi cancellare l'attributo");
                                Cancellazione=conn.prepareStatement("SELECT AttID FROM AttInClasse WHERE EventId=?");
                                Cancellazione.setString(1,att1);
                                rSet1=Cancellazione.executeQuery();
                                for (int i=0; rSet1.next(); i++) 
                                {System.out.println(rSet1.getString(i) +"/n");}
                                att2=C.readLine("Seleziona il nome dell'attributo che vuoi cancellare");
                                Keyword=C.readLine("Scrivi VAL per cancellare un solo valore dell'attributo");                               
                                if("VAL".equalsIgnoreCase(selez))
                                    {
                                    Cancellazione=conn.prepareStatement("DELETE FROM AttInClasse WHERE EventId=? AND AttID=(ReturnAttID(?,?))");
                                    att3=C.readLine("Seleziona il valore dell'attributo che vuoi cancellare");
                                    Cancellazione.setString(1,att1);
                                    Cancellazione.setString(2,att2);
                                    Cancellazione.setString(3,att3);
                                    numdel=Cancellazione.executeUpdate();
                                    }
                                else{
                                   Cancellazione=conn.prepareStatement("DELETE FROM AttInClasse WHERE EventId=? AND AttID IN (SELECT AttID FROM Attributo WHERE Nome=?");
                                   Cancellazione.setString(1,att1);
                                   Cancellazione.setString(2,att2);
                                   numdel=Cancellazione.executeUpdate();
                                   };
                                }
                            }
                 C.flush();
                       }
          else if("P".equalsIgnoreCase(selez))
                 {
                 while(!"MENU".equalsIgnoreCase(selez))
                         { 
                         selez=C.readLine("\nPeriodi:Premi I per inserire,M per modificare un record preciso,R per cercare e stampare l'elemento cercato,D per rimuovere un record specifico,S per stampare tutti i record di questa tabella,e qualunque altro tasto per tornare al menù principale:");
                         if("I".equalsIgnoreCase(selez))
                                        {
                                Inserimento=conn.prepareStatement("INSERT INTO PeriodoStorico VALUES(?,?,?)");
                                Inserimento.setString(1," ");
                                rSet1=Inserimento.executeQuery();
                                        }
                         else if("D".equalsIgnoreCase(selez))     
                                {
                                 Keyword=C.readLine("Seleziona il nome del periodo che vuoi cancellare");
                                 Cancellazione=conn.prepareStatement("DELETE FROM PeriodoStorico WHERE Name=?");
                                 Cancellazione.setString(1,Keyword);
                                 numdel=Cancellazione.executeUpdate();
                                }
                        else if("R".equalsIgnoreCase(selez))     
                                {
                                 Keyword=C.readLine("Seleziona il nome del periodo che vuoi cercare");
                                 Ricerca=conn.prepareStatement("SELECT FROM PeriodoStorico WHERE Nome=?");   
                                 Ricerca.setString(1,Keyword);
                                 rSet1=Ricerca.executeQuery();
                                 System.out.println(rSet1.getString(1) +"/n");   
                                }
                        else if("M".equalsIgnoreCase(selez))     
                                {
                                    
                                }
                        else if("S".equalsIgnoreCase(selez))     
                                {
                                StampaTutti=conn.prepareStatement("SELECT * FROM PersonaggioStorico ");
                                rSet1=StampaTutti.executeQuery();
                                for (int i=0;rSet1.next(); i++) 
                                            {
                                    System.out.println(rSet1.getString(i));
                                            }
                                }
                         
                         }
                        }
            selez=C.readLine("\n Scrivi PS per le operazioni sui periodi storici,E per quelle sugli eventi,A per quelle sugli attributi,P sui peronaggi,EX per uscire:");   
            
            
            }
        rSet1.close();
        Cancellazione.close();
        Inserimento.close();
        Ricerca.close();
        StampaTutti.close();
        Associa.close();
        }
    else
        {
        System.err.println("Console non accessibile");
        System.exit(1);
        }
    }
  
}
