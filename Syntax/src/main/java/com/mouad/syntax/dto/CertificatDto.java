package com.mouad.syntax.dto;

import com.mouad.syntax.model.Cours;
import com.mouad.syntax.model.Utilisateur;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CertificatDto {
    private Long id;
    private LocalDate dateObtention;
    private Utilisateur utilisateur;
    private Cours courses;
}
