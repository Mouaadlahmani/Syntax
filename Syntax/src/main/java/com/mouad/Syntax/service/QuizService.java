package com.mouad.Syntax.service;


import com.mouad.Syntax.dto.QuizDto;
import com.mouad.Syntax.dto.QuestionWrapper;
import com.mouad.Syntax.dto.Reponse;

import java.util.List;
import java.util.Optional;

public interface QuizService {
    QuizDto ajouterQuiz(String category, int numQ, String title);
    int calculateResult(Long id, List<Reponse> responses);
//    QuizDto modifyQuiz(Long id,QuizDto quizDto);
    Optional<QuizDto> getQuiz(Long id);
    List<QuestionWrapper> getQuizWithQuestions(Long id);
    List<QuizDto>getAllQuizzes();
    void deleteQuiz(Long id);
    void demarrerQuiz();
}
