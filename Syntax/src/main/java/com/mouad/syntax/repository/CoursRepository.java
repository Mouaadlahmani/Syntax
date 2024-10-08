package com.mouad.syntax.repository;

import com.mouad.syntax.model.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {
    @Query("SELECT c FROM Cours c ORDER BY c.id ASC")
    List<Cours> findAllSortedById();
    Optional<Cours> findByQuestionsId(Long id);

    @Override
    long count();
}
