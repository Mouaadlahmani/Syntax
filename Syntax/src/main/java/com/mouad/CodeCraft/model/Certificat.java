package com.mouad.CodeCraft.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Certificat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateObtention;

    @ManyToOne
    @JoinColumn(name = "utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "certificat")
    private Cours cours;
}
