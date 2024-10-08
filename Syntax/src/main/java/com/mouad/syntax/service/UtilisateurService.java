package com.mouad.syntax.service;

import com.mouad.syntax.dto.UtilisateurDto;

import java.util.List;
import java.util.Optional;

public interface UtilisateurService {
    List<UtilisateurDto> findAll();
    Optional<UtilisateurDto> findById(Long id);
    UtilisateurDto editInfos(Long id, UtilisateurDto utilisateurDto);
    long count();
}
