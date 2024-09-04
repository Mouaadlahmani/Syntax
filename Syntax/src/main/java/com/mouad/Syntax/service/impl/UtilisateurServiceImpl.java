package com.mouad.Syntax.service.impl;

import com.mouad.Syntax.model.Utilisateur;
import com.mouad.Syntax.repository.UtilisateurRepository;
import com.mouad.Syntax.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;


    @Override
    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Optional<Utilisateur> findById(Long id) {
        return utilisateurRepository.findById(id);
    }
}
