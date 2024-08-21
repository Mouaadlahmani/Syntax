package com.mouad.CodeCraft.dto;

import com.mouad.CodeCraft.model.Cours;
import com.mouad.CodeCraft.model.enums.Role;
import lombok.Data;
import java.util.HashSet;
import java.util.Set;

@Data
public class UtilisateurDto {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private Role role;
    private Set<Cours> cours = new HashSet<>();
}
