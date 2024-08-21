package com.mouad.CodeCraft.model;

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
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;

    @OneToMany(mappedBy = "quiz")
    @JsonIgnore
    private List<Question> questions;

    @ManyToOne
    @JoinColumn(name = "quiz")
    private Cours cours;
}
