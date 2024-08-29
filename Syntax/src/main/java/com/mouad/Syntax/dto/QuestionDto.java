package com.mouad.Syntax.dto;

import com.mouad.Syntax.model.Quiz;
import com.mouad.Syntax.model.Reponse;
import lombok.Data;

import java.util.List;

@Data
public class QuestionDto {
    private Long id;
    private String question;
    private Quiz quiz;
    private List<Reponse> reponses;
}
