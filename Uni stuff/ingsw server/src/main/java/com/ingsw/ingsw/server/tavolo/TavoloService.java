package com.ingsw.ingsw.server.tavolo;

import com.ingsw.ingsw.server.utente.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TavoloService {
    private final TavoloRepository tavoloRepository;

    @Autowired
    public TavoloService(TavoloRepository tavoloRepository) { this.tavoloRepository = tavoloRepository;}

    public List<Tavolo> getTavolo() { return tavoloRepository.findAll();}

    public void addNewTavolo(Tavolo tavolo) {
        List<Tavolo> tavoli = tavoloRepository.findAll();
        long highestId = tavoli.stream().mapToLong(Tavolo::getId).max().orElse(0L);
        long newId = highestId + 1;
        tavolo.setId(newId);
        tavoloRepository.save(tavolo);
    }



    public void deleteTavolo(Long tavoloId) {
        if (!tavoloRepository.existsById(tavoloId)) {
            throw new IllegalStateException("Il tavolo con l'id " + tavoloId + " non esiste");
        } else {
            tavoloRepository.deleteById(tavoloId);
        }
    }


    public void deleteHighestIdTavolo() {
        Optional<Tavolo> tavoloOptional = tavoloRepository.findTopByOrderByIdDesc();
        if (tavoloOptional.isPresent()) {
            Tavolo tavolo = tavoloOptional.get();
            tavoloRepository.deleteById(tavolo.getId());
        }
    }

}
