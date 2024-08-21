package com.mouad.CodeCraft.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mouad.CodeCraft.model.Certificat;
import com.mouad.CodeCraft.model.Lecon;
import com.mouad.CodeCraft.model.Quiz;
import com.mouad.CodeCraft.model.Utilisateur;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
public class CoursDto {
    private Long id;
    private String titre;
    private String description;
    private List<Certificat> certificat;
    private List<Lecon> lecon;
    private List<Quiz> quiz;
    private Set<Utilisateur> utilisateurs = new HashSet<>();
}
