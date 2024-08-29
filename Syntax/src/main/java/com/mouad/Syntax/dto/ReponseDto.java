package com.mouad.Syntax.dto;

import com.mouad.Syntax.model.Question;
import lombok.Data;

@Data
public class ReponseDto {
    private Long id;
    private String response;
    private boolean correct;
    private Question question;
}
