package com.mouad.syntax.service.impl;

import com.mouad.syntax.dto.QuizDto;
import com.mouad.syntax.mapper.QuizMapper;
import com.mouad.syntax.model.Question;
import com.mouad.syntax.dto.QuestionWrapper;
import com.mouad.syntax.model.Quiz;
import com.mouad.syntax.dto.Reponse;
import com.mouad.syntax.repository.QuestionRepository;
import com.mouad.syntax.repository.QuizRepository;
import com.mouad.syntax.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {


    private final QuizRepository quizRepository;

    private final QuestionRepository questionRepository;

    private final QuizMapper quizMapper;

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
        Optional<Quiz> optionalQuiz = quizRepository.findById(id);

        if (optionalQuiz.isPresent()){
            Quiz quiz = optionalQuiz.get();
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
        else {
            // Handle the case where the quiz is not found (e.g., throw an exception or return 0)
            throw new NoSuchElementException("Quiz not found with ID: " + id);
        }
    }


    @Override
    public Optional<QuizDto> getQuiz(Long id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        return quiz.map(quizMapper::toDto);
    }

    @Override
    public List<QuestionWrapper> getQuizWithQuestions(Long id) {
        Optional<Quiz> optionalQuiz = quizRepository.findById(id);
        if (optionalQuiz.isPresent()){
            Quiz quiz = optionalQuiz.get();
            List<Question> questionList = quiz.getQuestions();
            List<QuestionWrapper> questionsForUser = new ArrayList<>();
            for (Question q : questionList) {
                QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3());
                questionsForUser.add(qw);
            }
            return questionsForUser;
        }
        else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<QuizDto> getAllQuizzes() {
        List<Quiz> quizzes = quizRepository.findAll();
        return quizzes.stream()
                .map(quizMapper::toDto)
                .toList();
    }

    @Override
    public void deleteQuiz(Long id) {
            quizRepository.deleteById(id);
    }

    @Override
    public long getQuizCount() {
        return quizRepository.count();
    }

}
