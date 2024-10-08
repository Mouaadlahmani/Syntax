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
public class Lecon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;

    @OneToMany(mappedBy = "lecon", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Contenu> contenu;

    @ManyToOne
    @JoinColumn(name = "coursLecons")
    private Cours courses;
}
