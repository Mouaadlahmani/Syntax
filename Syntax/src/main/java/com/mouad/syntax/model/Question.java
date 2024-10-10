package com.mouad.syntax.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String rightAnswer;
    private String difficultyLevel;

    @ManyToOne
    @JoinColumn(name = "cours")
    private Cours cours;

    @ManyToMany(mappedBy = "questions", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Quiz> quizzes;

}
