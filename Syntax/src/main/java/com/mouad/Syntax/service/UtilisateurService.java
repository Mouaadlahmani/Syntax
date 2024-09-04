package com.mouad.Syntax.service;

import com.mouad.Syntax.model.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface UtilisateurService {
    List<Utilisateur> findAll();
    Optional<Utilisateur> findById(Long id);
}
