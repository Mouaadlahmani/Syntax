package com.mouad.CodeCraft.service.impl;

import com.mouad.CodeCraft.dto.CoursDto;
import com.mouad.CodeCraft.mapper.CoursMapper;
import com.mouad.CodeCraft.model.Cours;
import com.mouad.CodeCraft.repository.CoursRepository;
import com.mouad.CodeCraft.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoursServiceImpl implements CoursService {

    @Autowired
    CoursRepository coursRepository;
    @Autowired
    CoursMapper coursMapper;

    @Override
    public CoursDto ajouterCours(CoursDto coursDto) {
        Cours cours = coursMapper.toEntity(coursDto);
        Cours saved = coursRepository.save(cours);
        return coursMapper.toDto(saved);
    }

    @Override
    public List<CoursDto> allCourses() {
        List<Cours> coursList = coursRepository.findAll();
        return coursList.stream()
                .map(coursMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CoursDto> coursById(Long id) {
        Optional<Cours> optionalCours = coursRepository.findById(id);
        return optionalCours.map(coursMapper::toDto);
    }

    @Override
    public CoursDto editCours(Long id, CoursDto coursDto) {
        Optional<Cours> cours = coursRepository.findById(id);
        if (cours.isPresent()){
            Cours editedCours = cours.get();
            editedCours.setId(id);
            editedCours.setTitre(coursDto.getTitre());
            editedCours.setDescription(coursDto.getDescription());
            editedCours.setLecon(coursDto.getLecon());
            editedCours.setUtilisateurs(coursDto.getUtilisateurs());
            editedCours.setCertificat(coursDto.getCertificat());
            editedCours.setQuiz(editedCours.getQuiz());
        }
        return null;
    }

    @Override
    public void deleteCours(Long id) {
        coursRepository.deleteById(id);
    }
}
