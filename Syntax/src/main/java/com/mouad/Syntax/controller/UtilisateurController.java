package com.mouad.Syntax.controller;

import com.mouad.Syntax.model.Utilisateur;
import com.mouad.Syntax.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
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
