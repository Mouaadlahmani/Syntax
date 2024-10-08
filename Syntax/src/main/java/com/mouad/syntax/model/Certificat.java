package com.mouad.syntax.model;

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
    @JoinColumn(name = "utilisateurCertificats")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "coursCertificates")
    private Cours courses;
}
