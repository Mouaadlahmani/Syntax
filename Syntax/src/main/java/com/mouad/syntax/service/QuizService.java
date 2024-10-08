package com.mouad.syntax.service;


import com.mouad.syntax.dto.QuizDto;
import com.mouad.syntax.dto.QuestionWrapper;
import com.mouad.syntax.dto.Reponse;

import java.util.List;
import java.util.Optional;

public interface QuizService {
    QuizDto ajouterQuiz(String category, int numQ, String title);
    int calculateResult(Long id, List<Reponse> responses);
    Optional<QuizDto> getQuiz(Long id);
    List<QuestionWrapper> getQuizWithQuestions(Long id);
    List<QuizDto>getAllQuizzes();
    void deleteQuiz(Long id);
    long getQuizCount();
}
