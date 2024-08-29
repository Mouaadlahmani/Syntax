package com.mouad.Syntax.dto;

import com.mouad.Syntax.model.Cours;
import com.mouad.Syntax.model.Utilisateur;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CertificatDto {
    private Long id;
    private LocalDate dateObtention;
    private Utilisateur utilisateur;
    private Cours courses;
}
