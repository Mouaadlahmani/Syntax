package com.mouad.Syntax.dto;

import com.mouad.Syntax.model.Certificat;
import com.mouad.Syntax.model.Lecon;
import com.mouad.Syntax.model.Quiz;
import lombok.Data;

import java.util.List;

@Data
public class CoursDto {
    private Long id;
    private String titre;
    private String description;
    private List<Certificat> certificat;
    private List<Lecon> Lecons;
    private List<Quiz> quizzes;
}
