package com.mouad.Syntax.dto;

import com.mouad.Syntax.model.Cours;
import lombok.Data;

@Data
public class LeconDto {
    private Long id;
    private String titre;
    private String contenu;
    private Cours courses;
}
