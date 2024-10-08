package com.mouad.syntax.controller;

import com.mouad.syntax.dto.LeconDto;
import com.mouad.syntax.service.LeconService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/lecon/")
@RequiredArgsConstructor
public class LeconController {

    private final LeconService leconService;

    @PostMapping("add/{id}")
    public LeconDto ajouterLecon(@PathVariable("id") Long id, @RequestBody LeconDto leconDto){
        return leconService.ajouterLecon(id,leconDto);
    }

    @GetMapping("all")
    public List<LeconDto> allLecons(){
        return leconService.allLecons();
    }

    @GetMapping("{id}")
    public Optional<LeconDto> leconById(@PathVariable("id") Long id){
        return leconService.leconById(id);
    }

    @GetMapping("cours/{id}")
    public List<LeconDto> leconByCoursId(@PathVariable("id") Long id){
        return leconService.leconsOfCours(id);
    }


    @PutMapping("edit/{id}")
    public LeconDto editLecon(@PathVariable("id") Long id, @RequestBody LeconDto leconDto){
        return leconService.editLecon(id, leconDto);
    }

    @DeleteMapping("delete/{id}")
    public void deleteLecon(@PathVariable("id") Long id){
        leconService.deleteLecon(id);
    }
}
