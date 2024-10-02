package com.mouad.Syntax.controller;

import com.mouad.Syntax.dto.ContenuDto;
import com.mouad.Syntax.service.ContenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/contenu/")
public class ContenuController {

    @Autowired
    ContenuService contenuService;

    @PostMapping("add/{id}")
    public ContenuDto addContenu(@PathVariable Long id, @RequestBody ContenuDto contenu){
        return contenuService.addContenu(id, contenu);
    }

    @GetMapping("all")
    public List<ContenuDto> contenuList (){
        return contenuService.contenuList();
    }

    @GetMapping("{id}")
    public Optional<ContenuDto> contenuById(@PathVariable Long id){
        return contenuService.contenuById(id);
    }

    @GetMapping("lecon/{id}")
    public List<ContenuDto> contenuByLeconId(@PathVariable Long id){
        return contenuService.getLeconContenu(id);
    }


    @PutMapping("edit/{id}")
    public ContenuDto editContenu(@PathVariable Long id, @RequestBody ContenuDto contenu){
        return contenuService.editContenu(id,contenu);
    }

    @DeleteMapping("delete/{id}")
    public void deleteContenu(@PathVariable Long id){
        contenuService.deleteContenu(id);
    }
}
