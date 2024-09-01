//package com.mouad.Syntax.controller;
//
//
//import com.mouad.Syntax.dto.ReponseDto;
//import com.mouad.Syntax.service.ReponseService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/reponse/")
//public class ReponseController {
//    @Autowired
//    ReponseService reponseService;
//
//    @PostMapping("add")
//    ReponseDto create(@RequestBody ReponseDto questionDto){
//        return reponseService.addReponse(questionDto);
//    }
//
//    @GetMapping("all")
//    List<ReponseDto> reponseAll(){
//        return reponseService.getAll();
//    }
//
//    @GetMapping("{id}")
//    Optional<ReponseDto> reponseById(@PathVariable Long id){
//        return reponseService.ReponseById(id);
//    }
//
//    @PutMapping("edit/{id}")
//    ReponseDto editReponse(@PathVariable Long id, @RequestBody ReponseDto questionDto){
//        return reponseService.editReponse(id, questionDto);
//    }
//
//    @DeleteMapping("delete/{id}")
//    void delete(@PathVariable Long id){
//        reponseService.delete(id);
//    }
//}
