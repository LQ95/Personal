package com.ingsw.ingsw.server.messaggio;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Primary
public interface MessaggioRepository  extends JpaRepository<Messaggio, Long> {
    @Query("SELECT u FROM Messaggio u WHERE u.id =?1")
    Optional<Messaggio> findMessaggioById(Long id);

    /*@Query(value=
            "SELECT * FROM Messaggio LEFT JOIN Messaggi_letti ON messaggio.id = Messaggi_letti.messaggio_id WHERE (utente_id IS DISTINCT FROM ?1 AND mittente <> ?2)"
            ,nativeQuery = true)
    List<Messaggio> getUnreadMessages(Long userId, String username);*/
    @Modifying
    @Query(value="INSERT INTO Messaggi_letti (messaggio_id,utente_id) VALUES (?1,?2)",nativeQuery = true)
    void setMessageAsRead(Long messageId, Long userId);
}
