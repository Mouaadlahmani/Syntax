package com.mouad.Syntax.dto;

import com.mouad.Syntax.model.Certificat;
import com.mouad.Syntax.model.enums.Role;
import lombok.Data;

import java.util.List;

@Data
public class UtilisateurDto {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private Role role;
    List<Certificat> certificats;
}
