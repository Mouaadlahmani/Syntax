package com.mouad.Syntax.service;


import com.mouad.Syntax.dto.QuizDto;

import java.util.List;
import java.util.Optional;

public interface QuizService {
    QuizDto ajouterQuiz(QuizDto quizDto);
    QuizDto modifyQuiz(Long id,QuizDto quizDto);
    Optional<QuizDto> getQuiz(Long id);
    List<QuizDto>getAllQuizzes();
    void deleteQuiz(Long id);
    void demarrerQuiz();
}
