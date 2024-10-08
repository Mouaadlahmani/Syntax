package com.mouad.Syntax.controller;

import com.mouad.Syntax.dto.QuizDto;
import com.mouad.Syntax.dto.QuestionWrapper;
import com.mouad.Syntax.dto.Reponse;
import com.mouad.Syntax.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/quiz/")
@RequiredArgsConstructor
public class QuizController {


    private final QuizService quizService;

    @PostMapping("add")
    public QuizDto addQuiz(@RequestParam("category") String category, @RequestParam("numQ") int numQ, @RequestParam("title") String title) {
        return quizService.ajouterQuiz(category, numQ, title);
    }

    @PostMapping("submit/{id}")
    public int submitQuiz(@PathVariable("id") Long id, @RequestBody List<Reponse> responses){
        return quizService.calculateResult(id, responses);
    }

    @GetMapping("all")
    public List<QuizDto> getAllQuiz() {
        return quizService.getAllQuizzes();
    }

    @GetMapping("count")
    public long count() {
        return quizService.getQuizCount();
    }


    @GetMapping("num/{id}")
    public Optional<QuizDto> getQuizById(@PathVariable("id") Long id) {
        return quizService.getQuiz(id);
    }

    @GetMapping("{id}")
    public List<QuestionWrapper> getQuizWithQuestions(@PathVariable Long id) {
        return quizService.getQuizWithQuestions(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteQuiz(@PathVariable("id") Long id) {
        quizService.deleteQuiz(id);
    }
}
