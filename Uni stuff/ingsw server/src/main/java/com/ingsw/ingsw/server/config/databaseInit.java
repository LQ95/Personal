package com.ingsw.ingsw.server.config;

import com.ingsw.ingsw.server.categoria.Categoria;
import com.ingsw.ingsw.server.categoria.CategoriaRepository;
import com.ingsw.ingsw.server.messaggio.Messaggio;
import com.ingsw.ingsw.server.messaggio.MessaggioRepository;
import com.ingsw.ingsw.server.ordinazione.Ordinazione;
import com.ingsw.ingsw.server.ordinazione.OrdinazioneRepository;
import com.ingsw.ingsw.server.pietanza.Pietanza;
import com.ingsw.ingsw.server.pietanza.PietanzaRepository;
import com.ingsw.ingsw.server.tavolo.Tavolo;
import com.ingsw.ingsw.server.tavolo.TavoloRepository;
import com.ingsw.ingsw.server.utente.RuoliUtente;
import com.ingsw.ingsw.server.utente.Utente;
import com.ingsw.ingsw.server.utente.UtenteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.List;

@Configuration
public class databaseInit {
    @Bean
    CommandLineRunner commandLineRunner(UtenteRepository repositoryUtente, PietanzaRepository repositoryPietanza, MessaggioRepository repositoryMessaggio,
                                        TavoloRepository tavoloRepository, CategoriaRepository categoriaRepository, OrdinazioneRepository ordinazioneRepository) {
        return args -> {

            //Inizializzazione utenti
            Utente gennaro = new Utente(
                    "Gennaro",
                    "forzajuve",
                    RuoliUtente.AMMINISTRATORE
            );

            Utente a = new Utente(
                    "a",
                    "a",
                    RuoliUtente.AMMINISTRATORE,
                    false
            );

            Utente admin = new Utente(
                    "admin",
                    "password",
                    RuoliUtente.AMMINISTRATORE
            );

            Utente luisa = new Utente(
                    "Luisa",
                    "Libertas",
                    RuoliUtente.SALA
            );

            Utente test = new Utente(
                    "test",
                    "a",
                    RuoliUtente.SALA
            );

            Utente b = new Utente(
                    "b",
                    "b",
                    RuoliUtente.SALA,
                    false
            );

            //Inizializzazione Pietanze
            Pietanza pasta1 = new Pietanza(
                    "Pasta al sugo",
                    "Pasta con i pomodorini",
                    "pomodori",
                    7.50F
            );

            Pietanza pasta2 = new Pietanza(
                    "Carbonara",
                    "È molto buona",
                    "pepe",
                    9.00F
            );

            Pietanza secondo1 = new Pietanza(
                    "Bistecca alla Fiorentina",
                    "aaa",
                    "",
                    13.50F
            );

            Pietanza contorno = new Pietanza(
                    "Patate fritte",
                    "Patate novelle fritte",
                    "Grasso animale",
                    7.50F
            );

            //Inizializzazione messaggi
            Messaggio messggio1 = new Messaggio(
                    "Gennaro",
                    "Test messaggio amministratore"
            );

            Messaggio messaggio2 = new Messaggio(
                    "admin",
                    "test 2"
            );

            //Inizializzazione Categorie

            Categoria categoria1 = new Categoria(
                    "Primi",
                    List.of(pasta1, pasta2)
            );

            Categoria categoria2 = new Categoria(
                    "Secondi",
                    List.of(secondo1)
            );

            Categoria categoria3 = new Categoria(
                    "Contorni",
                    List.of(contorno)
            );

            //Inizializzazione tavoli

            Tavolo tavolo1 = new Tavolo(1);
            Tavolo tavolo2 = new Tavolo(2);
            Tavolo tavolo3 = new Tavolo(3);
            Tavolo tavolo4 = new Tavolo(4);
            Tavolo tavolo5 = new Tavolo(5);


            //Inizializzazione Ordinazioni
            Ordinazione ordinazione1 = new Ordinazione(
                    1
            );

            Ordinazione ordinazione2 = new Ordinazione(
                    2,
                    false
            );

            //Ordinazioni con liste di pietanze
            Ordinazione ordinazione3 = new Ordinazione(
                    3,
                    false,
                    List.of(pasta1, secondo1, contorno)
            );

            Ordinazione ordinazione4 = new Ordinazione(
                    4,
                    false,
                    List.of(pasta1, pasta1, pasta1, secondo1)
            );

            Ordinazione ordinazione5 = new Ordinazione(
                    3,
                    true,
                    List.of(pasta2, pasta2, contorno)
            );


            //Ordinazioni con liste di pietanze avvenute in date passate
            Ordinazione ordinazione6 = new Ordinazione(
                    3,
                    false,
                    List.of(pasta2, pasta2, contorno, contorno),
                    new SimpleDateFormat("dd-MM-yyyy").parse("21-05-2023")
            );

            Ordinazione ordinazione7 = new Ordinazione(
                    3,
                    false,
                    List.of(pasta2, pasta2, contorno),
                    new SimpleDateFormat("dd-MM-yyyy").parse("27-04-2023")
            );

            Ordinazione ordinazione8 = new Ordinazione(
                    3,
                    false,
                    List.of(pasta2, pasta2, contorno, contorno, secondo1),
                    new SimpleDateFormat("dd-MM-yyyy").parse("21-03-2023")
            );

            Ordinazione ordinazione9 = new Ordinazione(
                    3,
                    false,
                    List.of(pasta2, pasta2, contorno, contorno),
                    new SimpleDateFormat("dd-MM-yyyy").parse("12-02-2023")
            );

            Ordinazione ordinazione10 = new Ordinazione(
                    3,
                    false,
                    List.of(pasta2, pasta2, contorno, contorno, pasta1, secondo1),
                    new SimpleDateFormat("dd-MM-yyyy").parse("04-01-2023")
            );

            Ordinazione ordinazione11 = new Ordinazione(
                    3,
                    false,
                    List.of(pasta2, pasta2, contorno, contorno, pasta1, pasta1, pasta1, secondo1, secondo1, secondo1),
                    new SimpleDateFormat("dd-MM-yyyy").parse("21-12-2022")
            );


            //Ordinazioni stesso mese

            Ordinazione ordinazioneMese1 = new Ordinazione(
                    3,
                    false,
                    List.of(pasta2, pasta2, pasta1, pasta1, secondo1, secondo1, secondo1),
                    new SimpleDateFormat("dd-MM-yyyy").parse("05-11-2022")
            );

            Ordinazione ordinazioneMese2 = new Ordinazione(
                    3,
                    false,
                    List.of(pasta2, pasta2, secondo1, secondo1),
                    new SimpleDateFormat("dd-MM-yyyy").parse("09-11-2022")
            );

            Ordinazione ordinazioneMese3 = new Ordinazione(
                    3,
                    false,
                    List.of(pasta2, pasta1, pasta1, secondo1),
                    new SimpleDateFormat("dd-MM-yyyy").parse("17-11-2022")
            );

            Ordinazione ordinazioneMese4 = new Ordinazione(
                    3,
                    false,
                    List.of(pasta2, pasta2),
                    new SimpleDateFormat("dd-MM-yyyy").parse("24-11-2022")
            );

            //Ordinazioni con lo stesso giorno
            Ordinazione ordinazioneGiorno1 = new Ordinazione(
                    3,
                    false,
                    List.of(pasta2, pasta2),
                    new SimpleDateFormat("dd-MM-yyyy").parse("02-02-2023")
            );

            Ordinazione ordinazioneGiorno2 = new Ordinazione(
                    3,
                    false,
                    List.of(pasta2, pasta2, secondo1),
                    new SimpleDateFormat("dd-MM-yyyy").parse("02-02-2023")
            );

            Ordinazione ordinazioneGiorno3 = new Ordinazione(
                    3,
                    false,
                    List.of(pasta2, pasta2, contorno),
                    new SimpleDateFormat("dd-MM-yyyy").parse("02-02-2023")
            );

            //Ordinazione con orario
            Ordinazione ordinazioneOrario = new Ordinazione(
                    3,
                    false,
                    List.of(pasta2, pasta2, pasta1, pasta1, secondo1, secondo1, secondo1),
                    new SimpleDateFormat("dd-MM-yyyy HH:mm").parse("20-02-2023 12:00")
            );


            tavoloRepository.saveAll(List.of(tavolo1, tavolo2, tavolo3, tavolo4, tavolo5));

            repositoryMessaggio.saveAll(List.of(messggio1, messaggio2));

            repositoryPietanza.saveAll(List.of(pasta1, pasta2, secondo1, contorno));

            repositoryUtente.saveAll(List.of(gennaro, luisa, admin, test, a, b));

            ordinazioneRepository.saveAll(List.of(ordinazione1, ordinazione2, ordinazione3, ordinazione4, ordinazione5));

            //Inserimento ordinazioni con data specifica
            ordinazioneRepository.saveAll(List.of(ordinazione6, ordinazione7, ordinazione8, ordinazione9, ordinazione10, ordinazione11, ordinazioneOrario));

            //Inserimento ordinazioni con stessa data
            ordinazioneRepository.saveAll(List.of(ordinazioneMese1, ordinazioneMese2, ordinazioneMese3, ordinazioneMese4));

            //Inserimento ordinazioni con lo stesso giorno
            ordinazioneRepository.saveAll(List.of(ordinazioneGiorno1, ordinazioneGiorno2, ordinazioneGiorno3));

            categoriaRepository.saveAll(List.of(categoria1, categoria2, categoria3));
        };
    }
}
