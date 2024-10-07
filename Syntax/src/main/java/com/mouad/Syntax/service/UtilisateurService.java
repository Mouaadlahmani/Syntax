package com.mouad.Syntax.service;

import com.mouad.Syntax.dto.UtilisateurDto;
import com.mouad.Syntax.model.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface UtilisateurService {
    List<UtilisateurDto> findAll();
    Optional<UtilisateurDto> findById(Long id);
    UtilisateurDto editInfos(Long id, UtilisateurDto utilisateurDto);
    long count();
}
