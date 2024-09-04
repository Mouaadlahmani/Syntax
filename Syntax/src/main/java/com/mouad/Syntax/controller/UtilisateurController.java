package com.mouad.Syntax.controller;

import com.mouad.Syntax.model.Utilisateur;
import com.mouad.Syntax.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/utilisateur/")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("all")
    public List<Utilisateur> getAll() {
        return utilisateurService.findAll();
    }

    @GetMapping("{id}")
    public Optional<Utilisateur> getById(@PathVariable Long id) {
        return utilisateurService.findById(id);
    }
}
