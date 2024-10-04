package com.mouad.Syntax.controller;

import com.mouad.Syntax.dto.CoursDto;
import com.mouad.Syntax.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/cours/")
public class CoursController {
    @Autowired
    CoursService coursService;

    @PostMapping("add")
    public CoursDto ajouterCours(@RequestBody CoursDto coursDto){
        return coursService.ajouterCours(coursDto);
    }

    @GetMapping("all")
    public List<CoursDto> allCours(){
        return coursService.allCourses();
    }

    @GetMapping("{id}")
    public Optional<CoursDto> coursById(@PathVariable Long id){
        return coursService.coursById(id);
    }

    @GetMapping("question/{id}")
    public Optional<CoursDto> coursByQuestionId(@PathVariable Long id){
        return coursService.coursByQuestionId(id);
    }

    @PutMapping("edit/{id}")
    public CoursDto editCours(@PathVariable Long id, @RequestBody CoursDto coursDto){
        return coursService.editCours(id, coursDto);
    }

    @DeleteMapping("delete/{id}")
    public void deleteCours(@PathVariable Long id){
        coursService.deleteCours(id);
    }
}
