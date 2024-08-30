package com.mouad.Syntax.controller;

import com.mouad.Syntax.dto.QuizDto;
import com.mouad.Syntax.model.Quiz;
import com.mouad.Syntax.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/quiz/")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("add")
    public QuizDto addQuiz(@RequestBody QuizDto quizDto) {
        return quizService.ajouterQuiz(quizDto);
    }

    @GetMapping("all")
    public List<QuizDto> getAllQuiz() {
        return quizService.getAllQuizzes();
    }

    @GetMapping("{id}")
    public Optional<QuizDto> getQuizById(@PathVariable Long id) {
        return quizService.getQuiz(id);
    }

    @PutMapping("edit/{id}")
    public QuizDto editQuiz(@PathVariable Long id, @RequestBody QuizDto quizDto) {
        return quizService.modifyQuiz(id, quizDto);
    }

    @DeleteMapping
    public void deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
    }
}
