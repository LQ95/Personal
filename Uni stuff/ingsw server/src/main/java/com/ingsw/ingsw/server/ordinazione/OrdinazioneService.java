package com.ingsw.ingsw.server.ordinazione;

import com.ingsw.ingsw.server.pietanza.Pietanza;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.ingsw.ingsw.server.pietanza.PietanzaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrdinazioneService {
    private final OrdinazioneRepository ordinazioneRepository;
    private final PietanzaRepository pietanzaRepository;

    @Autowired
    public OrdinazioneService(OrdinazioneRepository ordinazioneRepository, PietanzaRepository pietanzaRepository) {
        this.ordinazioneRepository = ordinazioneRepository;
        this.pietanzaRepository = pietanzaRepository;
    }
    public List<Ordinazione> getOrdinazione() { return ordinazioneRepository.findAll();}
    public void addNewOrdinazione(Ordinazione ordinazione) {
        boolean exists = ordinazioneRepository.existsByTavoloAndAperta(ordinazione.getTavolo(), true);
        if (!exists) {
            ordinazioneRepository.save(ordinazione);
        } else {
            throw new RuntimeException("Esiste già un'ordinazione aperta per il tavolo specificato");
        }
    }


    public void deleteOrdinazione(Long ordinazioneId) {
        if(!ordinazioneRepository.existsById(ordinazioneId))
            throw new IllegalStateException("L'ordinazione con l'id " + ordinazioneId + " non esiste");
        else
            ordinazioneRepository.deleteById(ordinazioneId);
    }
//    @Transactional
//    public void addPietanzaToOrdinazione(Long pietanzaId, Long ordinazId) {
//        ordinazioneRepository.addPietanzaToOrdinazione(pietanzaId, ordinazId);
//    }

    @Transactional
    public void addPietanzaToOrdinazione(Long pietanzaId, Long ordinazId) {
        Optional<Ordinazione> optionalOrdinazione = ordinazioneRepository.findOrdinazioneById(ordinazId);
        Ordinazione ordinazione = optionalOrdinazione.orElseThrow(() -> new RuntimeException("Ordinazione non trovata"));

        if (!ordinazione.getAperta()) {
            throw new RuntimeException("Impossibile aggiungere pietanza a un'ordinazione chiusa");
        }

        Pietanza pietanza = pietanzaRepository.findPietanzaById(pietanzaId)
                .orElseThrow(() -> new RuntimeException("Pietanza non trovata"));

        List<Pietanza> pietanze = ordinazione.getPietanze();
        pietanze.add(pietanza);
        ordinazione.setPietanze(pietanze);

        Float nuovoConto = ordinazione.getConto() + pietanza.getCosto();
        ordinazione.setConto(nuovoConto);

        ordinazioneRepository.save(ordinazione);
    }




    public Ordinazione getOrdinazioneById(Long ordinazioneId) {
        Optional<Ordinazione> optionalOrdinazione = ordinazioneRepository.findOrdinazioneById(ordinazioneId);
        return optionalOrdinazione.orElseThrow(() -> new RuntimeException("Ordinazione non trovata"));
    }


    @Transactional
    public void deletePietanzaFromOrdinazione(Long pietanzaId, Long ordinazioneId) {
        ordinazioneRepository.deletePietanzaFromOrdinazione(pietanzaId, ordinazioneId);
    }

    public Ordinazione getCurrentOrdinazione(Long tavoloId) {
        return ordinazioneRepository.getCurrentOrdinazione(tavoloId);

    }
    @Transactional
    public void closeCurrentOrdinazione(Long tavoloId) {
        ordinazioneRepository.closeCurrentOrdinazione(tavoloId);
    }

}
