package com.ingsw.ingsw.server.pietanza;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PietanzaService {
    private final PietanzaRepository pietanzaRepository;

    @Autowired
    public PietanzaService(PietanzaRepository pietanzaRepository) { this.pietanzaRepository = pietanzaRepository;}
    public Pietanza getPietanza(Long pietanzaId) { return pietanzaRepository.findById(pietanzaId).get();
    }
    public List<Pietanza> getPietanze() {return pietanzaRepository.findAll();
    }
    public void addNewPietanza(Pietanza pietanza) {
        pietanzaRepository.save(pietanza);
    }
    @Transactional
    public void deletePietanza(Long id){
         boolean found = pietanzaRepository.existsById(id);
         if(!found){
             throw new IllegalStateException("Non esiste nessuna pietanza di id" + id);
         }
         else {
             pietanzaRepository.removePietanzafromCategorie(id);
             pietanzaRepository.deleteById(id);
         }
    }

    @Transactional
    public void updatePietanza(Pietanza pietanza) {
        boolean found = pietanzaRepository.existsById(pietanza.getId());
        if (!found){
            throw new IllegalStateException("Non esiste nessuna pietanza di id" + pietanza.getId());
        } else
            pietanzaRepository.updatePietanza(pietanza.getId(), pietanza.getName(), pietanza.getDescrizione(), pietanza.getAllergeni(), pietanza.getCosto());
    }
}
