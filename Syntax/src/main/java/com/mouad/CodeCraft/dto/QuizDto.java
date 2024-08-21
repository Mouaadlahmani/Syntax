package com.mouad.CodeCraft.dto;

import com.mouad.CodeCraft.model.Quiz;
import com.mouad.CodeCraft.model.enums.CorrectReponse;
import lombok.Data;

@Data
public class QuizDto {
    private Long id;
    private String question;
    private CorrectReponse correctReponse;
    private Quiz quiz;
}
