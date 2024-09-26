package com.mouad.Syntax.dto;

import com.mouad.Syntax.model.Lecon;
import lombok.Data;

@Data
public class ContenuDto {
    private Long id;
    private String titre;
    private String Contenu;
    private Lecon lecon;
}
