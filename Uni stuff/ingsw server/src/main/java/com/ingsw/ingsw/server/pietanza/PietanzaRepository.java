package com.ingsw.ingsw.server.pietanza;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PietanzaRepository extends JpaRepository<Pietanza, Long> {
    @Query("SELECT p FROM Pietanza p WHERE p.id =?1")
    Optional<Pietanza> findPietanzaById(Long id);

    @Modifying
    @Query("UPDATE Pietanza p SET p.name = :name, p.descrizione = :descrizione, p.allergeni = :allergeni, p.costo = :costo WHERE p.id = :id")
    void updatePietanza(@Param("id") Long id, @Param("name") String name, @Param("descrizione") String descrizione, @Param("allergeni") String allergeni, @Param("costo") Float costo);
    @Modifying
    @Query(value="DELETE FROM pietanze_categorie WHERE pietanza_id = ?1",nativeQuery = true)
    void removePietanzafromCategorie(Long pietanzaId);
}
