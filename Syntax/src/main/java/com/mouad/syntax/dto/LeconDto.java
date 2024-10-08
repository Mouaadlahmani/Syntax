package com.mouad.syntax.dto;

import com.mouad.syntax.model.Contenu;
import com.mouad.syntax.model.Cours;
import lombok.Data;

import java.util.List;

@Data
public class LeconDto {
    private Long id;
    private String titre;
    private List<Contenu> contenu;
    private Cours courses;
}
