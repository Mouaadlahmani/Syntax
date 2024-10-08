package com.mouad.syntax.dto;

import com.mouad.syntax.model.Certificat;
import com.mouad.syntax.model.Lecon;
import com.mouad.syntax.model.Quiz;
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
