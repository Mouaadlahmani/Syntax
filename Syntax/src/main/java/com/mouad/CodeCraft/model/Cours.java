package com.mouad.CodeCraft.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;

    @OneToMany(mappedBy = "cours")
    @JsonIgnore
    private List<Certificat> certificat;

    @OneToMany(mappedBy = "cours")
    @JsonIgnore
    private List<Lecon> lecon;

    @OneToMany(mappedBy = "cours")
    @JsonIgnore
    private List<Quiz> quiz;

    @ManyToMany(mappedBy = "cours")
    @JsonIgnore
    private Set<Utilisateur> utilisateurs = new HashSet<>();

}
