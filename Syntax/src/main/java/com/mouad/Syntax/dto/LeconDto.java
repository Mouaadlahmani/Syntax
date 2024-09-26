package com.mouad.Syntax.dto;

import com.mouad.Syntax.model.Contenu;
import com.mouad.Syntax.model.Cours;
import lombok.Data;

import java.util.List;

@Data
public class LeconDto {
    private Long id;
    private String titre;
    private List<Contenu> contenu;
    private Cours courses;
}
