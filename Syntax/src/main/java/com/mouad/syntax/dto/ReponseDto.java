package com.mouad.syntax.dto;

import com.mouad.syntax.model.Question;
import lombok.Data;

@Data
public class ReponseDto {
    private Long id;
    private String response;
    private boolean correct;
    private Question question;
}
