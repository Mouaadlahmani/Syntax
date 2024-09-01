package com.mouad.Syntax.dto;


import com.mouad.Syntax.model.Question;
import lombok.Data;

import java.util.List;

@Data
public class QuizDto {
    private Long id;
    private String titre;
    private List<Question> questions;
}
