package com.mouad.CodeCraft.model;

import com.mouad.CodeCraft.model.enums.CorrectReponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    @Enumerated(EnumType.STRING)
    private CorrectReponse correctReponse;

    @ManyToOne
    @JoinColumn(name = "questions")
    private Quiz quiz;


}
