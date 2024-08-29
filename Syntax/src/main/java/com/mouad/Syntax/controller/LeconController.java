package com.mouad.Syntax.controller;

import com.mouad.Syntax.dto.LeconDto;
import com.mouad.Syntax.service.LeconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lecon/")
public class LeconController {
    @Autowired
    LeconService leconService;

    @PostMapping("add")
    public LeconDto ajouterLecon(@RequestBody LeconDto leconDto){
        return leconService.ajouterLecon(leconDto);
    }

    @GetMapping("all")
    public List<LeconDto> allLecons(){
        return leconService.allLecons();
    }

    @GetMapping("{id}")
    public Optional<LeconDto> leconById(@PathVariable Long id){
        return leconService.LeconById(id);
    }

    @PutMapping("edit/{id}")
    public LeconDto editLecon(@PathVariable Long id, @RequestBody LeconDto leconDto){
        return leconService.editLecon(id, leconDto);
    }

    @DeleteMapping("delete/{id}")
    public void deleteLecon(@PathVariable Long id){
        leconService.deleteLecon(id);
    }
}
