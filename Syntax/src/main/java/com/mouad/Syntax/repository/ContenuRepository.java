package com.mouad.Syntax.repository;

import com.mouad.Syntax.model.Contenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContenuRepository extends JpaRepository<Contenu, Long> {
}
