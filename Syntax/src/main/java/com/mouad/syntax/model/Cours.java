package com.mouad.syntax.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @OneToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Certificat> certificat;

    @OneToMany(mappedBy = "courses" , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Lecon> Lecons;

    @OneToMany(mappedBy = "cours", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Question> questions;
}
