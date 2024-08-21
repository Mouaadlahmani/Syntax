package com.mouad.CodeCraft.dto;

import com.mouad.CodeCraft.model.Cours;
import com.mouad.CodeCraft.model.Utilisateur;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CertificatDto {
    private Long id;
    private LocalDate dateObtention;
    private Utilisateur utilisateur;
    private Cours cours;
}
