package com.ingsw.ingsw.server.messaggio;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessaggioService {

    private final MessaggioRepository MessaggioRepository;

    @Autowired
    public MessaggioService(MessaggioRepository MessaggioRepository) { this.MessaggioRepository = MessaggioRepository;}

    public List<Messaggio> getMessaggio() { return MessaggioRepository.findAll();}

    public void addNewMessaggio(Messaggio Messaggio) {
        Optional<Messaggio> MessaggioOptional = MessaggioRepository.findMessaggioById(Messaggio.getId());
        MessaggioRepository.save(Messaggio);
    }

    public void deleteMessaggio(Long MessaggioId) {
        if(!MessaggioRepository.existsById(MessaggioId))
            throw new IllegalStateException("Il Messaggio con l'id \" + utenteId + \" non esiste");
        else
            MessaggioRepository.deleteById(MessaggioId);
    }

    /*public List<Messaggio> getUnreadMessages(Long userId, String username) {

        return MessaggioRepository.getUnreadMessages(userId,username);
    }*/
    @Transactional
    public void setMessageAsRead(Long messageId, Long userId) {
        MessaggioRepository.setMessageAsRead(messageId,userId);
    }
}
