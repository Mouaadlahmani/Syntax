package com.mouad.Syntax.service.impl;

import com.mouad.Syntax.dto.QuizDto;
import com.mouad.Syntax.mapper.QuizMapper;
import com.mouad.Syntax.model.Question;
import com.mouad.Syntax.model.Quiz;
import com.mouad.Syntax.repository.QuizRepository;
import com.mouad.Syntax.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    QuizRepository quizRepository;
    @Autowired
    QuizMapper quizMapper;


    @Override
    public QuizDto ajouterQuiz(QuizDto quizDto) {
        Quiz quiz = quizMapper.toEntity(quizDto);
        Quiz savedQuiz = quizRepository.save(quiz);
        return quizMapper.toDto(savedQuiz);
    }

    @Override
    public QuizDto modifyQuiz(Long id, QuizDto quizDto) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        if(quiz.isPresent()){
            Quiz quizToModify = quiz.get();
            quizToModify.setId(id);
            quizToModify.setTitre(quizDto.getTitre());
            quizToModify.setCourses(quizDto.getCourses());
            quizToModify.setQuestions(quizDto.getQuestions());

            Quiz savedQuiz = quizRepository.save(quizToModify);
            return quizMapper.toDto(savedQuiz);
        }
        return null;
    }

    @Override
    public Optional<QuizDto> getQuiz(Long id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        return quiz.map(quizMapper::toDto);
    }

    @Override
    public List<QuizDto> getAllQuizzes() {
        List<Quiz> quizzes = quizRepository.findAll();
        return quizzes.stream()
                .map(quizMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteQuiz(Long id) {
            quizRepository.deleteById(id);
    }

    @Override
    public void demarrerQuiz() {

    }
}
