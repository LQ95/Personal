package com.ingsw.ingsw.server.tavolo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TavoloRepository  extends JpaRepository<Tavolo, Long> {
    @Query("SELECT u FROM Tavolo u WHERE u.id =?1")
    Optional<Tavolo> findTavoloById(Long id);

    @Query(value = "SELECT * FROM Tavolo ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Optional<Tavolo> findTopByOrderByIdDesc();
}
