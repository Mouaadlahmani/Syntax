package com.mouad.Syntax.repository;

import com.mouad.Syntax.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    @Override
    long count();
}
