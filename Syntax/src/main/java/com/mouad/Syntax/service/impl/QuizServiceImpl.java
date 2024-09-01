package com.mouad.Syntax.service.impl;

import com.mouad.Syntax.dto.QuizDto;
import com.mouad.Syntax.mapper.QuizMapper;
import com.mouad.Syntax.model.Question;
import com.mouad.Syntax.model.QuestionWrapper;
import com.mouad.Syntax.model.Quiz;
import com.mouad.Syntax.model.Reponse;
import com.mouad.Syntax.repository.QuestionRepository;
import com.mouad.Syntax.repository.QuizRepository;
import com.mouad.Syntax.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    QuizRepository quizRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    QuizMapper quizMapper;



//    @Override
//    public QuizDto modifyQuiz(Long id, QuizDto quizDto) {
//        Optional<Quiz> quiz = quizRepository.findById(id);
//        if(quiz.isPresent()){
//            Quiz quizToModify = quiz.get();
//            quizToModify.setId(id);
//            quizToModify.setTitre(quizDto.getTitre());
//            quizToModify.setCourses(quizDto.getCourses());
//            quizToModify.setQuestions(quizDto.getQuestions());
//
//            Quiz savedQuiz = quizRepository.save(quizToModify);
//            return quizMapper.toDto(savedQuiz);
//        }
//        return null;
//    }

    @Override
    public QuizDto ajouterQuiz(String category, int numQ, String title) {
        List<Question> questions = questionRepository.findRandomQuestionByCours(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitre(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);
        return quizMapper.toDto(quiz);
    }

    public int calculateResult(Long id, List<Reponse> responses){
        Quiz quiz = quizRepository.findById(id).get();
        List<Question> questionList = quiz.getQuestions();
        int right = 0;
        int i = 0;
        for(Reponse response: responses){
            if(response.getResponse().equals(questionList.get(i).getRightAnswer())){
                right++;
            }

            i++;
        }
        return right;
    }

    @Override
    public Optional<QuizDto> getQuiz(Long id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        return quiz.map(quizMapper::toDto);
    }

    @Override
    public List<QuestionWrapper> getQuizWithQuestions(Long id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        List<Question> questionList = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();
        for (Question q : questionList) {
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3());
            questionsForUser.add(qw);
        }
        return questionsForUser;
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
