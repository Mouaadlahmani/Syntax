package com.mouad.syntax.dto;

import com.mouad.syntax.model.Lecon;
import lombok.Data;

@Data
public class ContenuDto {
    private Long id;
    private String titre;
    private String contenu;
    private Lecon lecon;
}
