package com.mouad.Syntax.dto;

import com.mouad.Syntax.model.enums.Role;
import lombok.Data;

@Data
public class AdminDto {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private Role role;
}
