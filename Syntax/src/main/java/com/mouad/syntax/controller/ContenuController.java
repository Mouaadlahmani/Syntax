package com.mouad.syntax.controller;

import com.mouad.syntax.dto.ContenuDto;
import com.mouad.syntax.service.ContenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/contenu/")
@RequiredArgsConstructor
public class ContenuController {

    private final ContenuService contenuService;

    @PostMapping("add/{id}")
    public ContenuDto addContenu(@PathVariable("id") Long id, @RequestBody ContenuDto contenu){
        return contenuService.addContenu(id, contenu);
    }

    @GetMapping("all")
    public List<ContenuDto> contenuList (){
        return contenuService.contenuList();
    }

    @GetMapping("{id}")
    public Optional<ContenuDto> contenuById(@PathVariable("id") Long id){
        return contenuService.contenuById(id);
    }

    @GetMapping("lecon/{id}")
    public List<ContenuDto> contenuByLeconId(@PathVariable("id") Long id){
        return contenuService.getLeconContenu(id);
    }


    @PutMapping("edit/{id}")
    public ContenuDto editContenu(@PathVariable("id") Long id, @RequestBody ContenuDto contenu){
        return contenuService.editContenu(id,contenu);
    }

    @DeleteMapping("delete/{id}")
    public void deleteContenu(@PathVariable("id") Long id){
        contenuService.deleteContenu(id);
    }
}
