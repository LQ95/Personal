package com.ingsw.ingsw.server.utente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtenteRepository  extends JpaRepository<Utente, Long> {
    @Query("SELECT u FROM Utente u WHERE u.id =?1")
    Optional<Utente> findUtenteById(Long id);


    @Modifying
    @Query("UPDATE Utente u SET u.firstAccess = ?1, u.password= ?3  WHERE u.id =?2")
    void updateAfterFirstAccess(boolean firstAccess, Long id, String password);
}
