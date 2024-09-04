package com.mouad.Syntax.dto;

import com.mouad.Syntax.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;

}