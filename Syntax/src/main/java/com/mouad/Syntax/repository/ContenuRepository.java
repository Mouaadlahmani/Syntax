package com.mouad.Syntax.repository;

import com.mouad.Syntax.model.Contenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContenuRepository extends JpaRepository<Contenu, Long> {
    @Query("SELECT c FROM Contenu c ORDER BY c.id ASC")
    List<Contenu> findAllSortedById();
    List<Contenu> findByLeconId(Long id);
}
