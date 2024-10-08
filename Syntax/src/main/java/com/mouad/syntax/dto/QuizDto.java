package com.mouad.syntax.dto;


import com.mouad.syntax.model.Question;
import lombok.Data;

import java.util.List;

@Data
public class QuizDto {
    private Long id;
    private String titre;
    private List<Question> questions;
}
