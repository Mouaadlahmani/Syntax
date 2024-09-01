package com.mouad.Syntax.dto;

import com.mouad.Syntax.model.Cours;
import com.mouad.Syntax.model.Quiz;
import lombok.Data;

import java.util.List;

@Data
public class QuestionDto {
    private Long id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String rightAnswer;
    private String difficultyLevel;
    private Cours cours;
    private List<Quiz> quizzes;
}
