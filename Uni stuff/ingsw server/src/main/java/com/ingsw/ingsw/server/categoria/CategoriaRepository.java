package com.ingsw.ingsw.server.categoria;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@Primary
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

    @Query("SELECT c FROM Categoria c WHERE c.id =?1")
    Optional<Categoria> findCategoriaById(Long id);
    @Modifying
    @Query(value="DELETE FROM pietanze_categorie WHERE (categoria_id = ?2 AND pietanza_id = ?1)",nativeQuery = true)
    void deletePietanza(Long pietanzaId, Long categoriaId);
    @Modifying
    @Query(value="INSERT INTO pietanze_categorie (categoria_id,pietanza_id) VALUES (?2,?1)",nativeQuery = true)
    void addPietanza(Long pietanzaId, Long categoriaId);
}
