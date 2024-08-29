package com.mouad.Syntax.service.impl;

import com.mouad.Syntax.dto.LeconDto;
import com.mouad.Syntax.mapper.LeconMapper;
import com.mouad.Syntax.model.Lecon;
import com.mouad.Syntax.repository.LeconRepository;
import com.mouad.Syntax.service.LeconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LeconServiceImpl implements LeconService {

    @Autowired
    LeconRepository leconRepository;

    @Autowired
    LeconMapper leconMapper;


    @Override
    public LeconDto ajouterLecon(LeconDto leconDto) {
        Lecon lecon = leconMapper.toEntity(leconDto);
        Lecon saved = leconRepository.save(lecon);
        return leconMapper.toDto(saved);
    }

    @Override
    public List<LeconDto> allLecons() {
        List<Lecon> lecons = leconRepository.findAll();
        return lecons.stream()
                .map(leconMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<LeconDto> LeconById(Long id) {
        Optional<Lecon> lecon = leconRepository.findById(id);
        return lecon.map(leconMapper::toDto);
    }

    @Override
    public LeconDto editLecon(Long id, LeconDto leconDto) {
        Optional<Lecon> lecon = leconRepository.findById(id);
        if(lecon.isPresent()){
            Lecon editedLecon = lecon.get();
            editedLecon.setId(id);
            editedLecon.setTitre(leconDto.getTitre());
            editedLecon.setContenu(leconDto.getContenu());
            editedLecon.setCourses(leconDto.getCourses());

            Lecon edited = leconRepository.save(editedLecon);
            return leconMapper.toDto(edited);
        }
        return null;
    }

    @Override
    public void deleteLecon(Long id) {
        leconRepository.deleteById(id);
    }
}
