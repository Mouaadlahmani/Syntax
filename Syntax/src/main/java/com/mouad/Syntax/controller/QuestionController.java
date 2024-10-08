package com.mouad.Syntax.controller;

import com.mouad.Syntax.dto.QuestionDto;
import com.mouad.Syntax.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/question/")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping("create/{id}")
    QuestionDto create(@PathVariable("id") Long id, @RequestBody QuestionDto questionDto){
        return questionService.addQuestion(id, questionDto);
    }

    @GetMapping("all")
    List<QuestionDto> reponseAll(){
        return questionService.getAll();
    }

    @GetMapping("{id}")
    Optional<QuestionDto> reponseById(@PathVariable("id") Long id){
        return questionService.questionById(id);
    }

    @GetMapping("course/{id}")
    List<QuestionDto> questionsCours(@PathVariable("id") Long id){
        return questionService.findByCours(id);
    }

    @PutMapping("edit/{id}")
    QuestionDto editReponse(@PathVariable("id") Long id, @RequestBody QuestionDto questionDto){
        return questionService.editQuestion(id, questionDto);
    }

    @DeleteMapping("delete/{id}")
    void delete(@PathVariable("id") Long id){
        questionService.delete(id);
    }
}
