package com.mouad.syntax.service.impl;

import com.mouad.syntax.dto.LeconDto;
import com.mouad.syntax.mapper.LeconMapper;
import com.mouad.syntax.model.Cours;
import com.mouad.syntax.model.Lecon;
import com.mouad.syntax.repository.CoursRepository;
import com.mouad.syntax.repository.LeconRepository;
import com.mouad.syntax.service.LeconService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LeconServiceImpl implements LeconService {

    private final LeconRepository leconRepository;

    private final CoursRepository coursRepository;

    private final LeconMapper leconMapper;


    @Override
    public LeconDto ajouterLecon(Long id, LeconDto leconDto) {
        Cours cours = coursRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Cours Not Found")
        );
        Lecon lecon = leconMapper.toEntity(leconDto);
        lecon.setCourses(cours);
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

    @Override
    public List<LeconDto> LeconsOfCours(Long id) {
        List<Lecon> leconList = leconRepository.findByCoursesIdOrderByIdAsc(id);
        return leconList.stream()
                .map(leconMapper::toDto)
                .collect(Collectors.toList());
    }
}
