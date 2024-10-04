package com.mouad.Syntax.repository;

import com.mouad.Syntax.model.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {
    Optional<Cours> findByQuestionsId(Long id);
}
