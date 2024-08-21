package com.mouad.CodeCraft.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Entity
@Data
public class Utilisateur extends Personne{
    @ManyToMany
    @JoinTable(
            name = "utilisateur_cours",
            joinColumns = @JoinColumn(name = "utilisateur_id"),
            inverseJoinColumns = @JoinColumn(name = "cours_id")
    )
    @JsonIgnore
    private Set<Cours> cours = new HashSet<>();
}
