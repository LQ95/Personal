package com.ingsw.ingsw.server.utente;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UtenteService {
    private final UtenteRepository utenteRepository;

    @Autowired
    public UtenteService(UtenteRepository utenteRepository) { this.utenteRepository = utenteRepository;}

    public List<Utente> getUtente(){ return utenteRepository.findAll();}

    public void addNewUtente(Utente utente) throws DataIntegrityViolationException {
        utenteRepository.save(utente);
    }

    public void deleteUtente(Long utenteId) {
        if(!utenteRepository.existsById(utenteId))
            throw new IllegalStateException("L'utente con l'id " + utenteId + " non esiste");
        else
            utenteRepository.deleteById(utenteId);
    }

    public Utente authenticateUtente(String utente,String password) {
        boolean found=false;
        Utente daAutenticare= null;
        List<Utente> Utenti=utenteRepository.findAll();
        var iter=Utenti.iterator();
        while (iter.hasNext() && !found) {
            Utente current = iter.next();
            if ((Objects.equals(current.getNome(), utente)) && (Objects.equals(current.getPassword(), password))) {
                found = true;
                daAutenticare = current;
            }
        }

        return daAutenticare;
    }

    @Transactional
    public void updateAfterFirstAccess(Utente updatedUser) {
        utenteRepository.updateAfterFirstAccess(updatedUser.isFirstAccess(),updatedUser.getId(),updatedUser.getPassword());

    }
}
