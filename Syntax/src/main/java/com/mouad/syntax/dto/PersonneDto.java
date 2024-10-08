package com.mouad.syntax.dto;

import com.mouad.syntax.model.enums.Role;
import lombok.Data;

@Data
public class PersonneDto {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private Role role;
}
