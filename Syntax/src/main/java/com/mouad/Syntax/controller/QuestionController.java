package com.mouad.Syntax.controller;

import com.mouad.Syntax.dto.QuestionDto;
import com.mouad.Syntax.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/question/")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @PostMapping("create")
    QuestionDto create(@RequestBody QuestionDto questionDto){
        return questionService.addQuestion(questionDto);
    }

    @GetMapping("all")
    List<QuestionDto> reponseAll(){
        return questionService.getAll();
    }

    @GetMapping("{id}")
    Optional<QuestionDto> reponseById(@PathVariable Long id){
        return questionService.questionById(id);
    }

    @GetMapping("cours/{id}")
    List<QuestionDto> questionsCours(@PathVariable Long id){
        return questionService.findByCours(id);
    }

    @PutMapping("edit/{id}")
    QuestionDto editReponse(@PathVariable Long id, @RequestBody QuestionDto questionDto){
        return questionService.editQuestion(id, questionDto);
    }

    @DeleteMapping("delete/{id}")
    void delete(@PathVariable Long id){
        questionService.delete(id);
    }
}
