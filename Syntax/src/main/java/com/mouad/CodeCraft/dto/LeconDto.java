package com.mouad.CodeCraft.dto;

import com.mouad.CodeCraft.model.Cours;
import lombok.Data;

@Data
public class LeconDto {
    private Long id;
    private String titre;
    private String contenu;
    private Cours cours;
}
