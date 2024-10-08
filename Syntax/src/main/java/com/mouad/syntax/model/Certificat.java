package com.mouad.syntax.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Certificat implements Serializable {
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
