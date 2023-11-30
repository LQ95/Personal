package com.ingsw.ingsw.server.ordinazione;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrdinazioneRepository extends JpaRepository<Ordinazione, Long> {
    @Query("SELECT o FROM Ordinazione o WHERE o.id =?1")
    Optional<Ordinazione> findOrdinazioneById(Long id);

    @Modifying
    @Query(value="INSERT INTO pietanze_ordinazioni (categoria_id,ordinazione_id) VALUES (?2,?1)",nativeQuery = true)
    void addPietanzaToOrdinazione(Long pietanzaId, Long ordinazId);

    @Modifying
    @Query(value="DELETE FROM pietanze_ordinazioni WHERE (ordinazione_id = ?2 AND pietanza_id = ?1)",nativeQuery = true)
    void deletePietanzaFromOrdinazione(Long pietanzaId, Long ordinazioneId);

    @Query(value="SELECT o FROM Ordinazione o WHERE o.tavolo =?1 AND o.aperta=true")
    Ordinazione getCurrentOrdinazione(Long tavoloId);

    @Modifying
    @Query(value="UPDATE Ordinazione SET aperta=false WHERE tavolo =?1 AND aperta=true",nativeQuery = true)
    void closeCurrentOrdinazione(Long tavoloId);

    boolean existsByTavoloAndAperta(long tavolo, boolean aperta);
}
