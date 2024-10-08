package com.mouad.syntax.service.impl;

import com.mouad.syntax.dto.ContenuDto;
import com.mouad.syntax.mapper.ContenuMapper;
import com.mouad.syntax.model.Contenu;
import com.mouad.syntax.model.Lecon;
import com.mouad.syntax.repository.ContenuRepository;
import com.mouad.syntax.repository.LeconRepository;
import com.mouad.syntax.service.ContenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContenuServiceImpl implements ContenuService {


    private final ContenuRepository contenuRepository;

    private final LeconRepository leconRepository;

    private final ContenuMapper contenuMapper;

    @Override
    public ContenuDto addContenu(Long id, ContenuDto contenuDto) {
        Lecon lecon = leconRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Lecon not found")
        );
        Contenu contenu = contenuMapper.toEntity(contenuDto);
        contenu.setLecon(lecon);
        Contenu saved = contenuRepository.save(contenu);
        return contenuMapper.toDto(saved);
    }

    @Override
    public ContenuDto editContenu(Long id, ContenuDto contenuDto) {
        Optional<Contenu> contenu = contenuRepository.findById(id);
        if (contenu.isPresent()) {
            Contenu editedContenu = contenu.get();
            editedContenu.setId(id);
            editedContenu.setTitre(contenuDto.getTitre());
            editedContenu.setLecon(contenuDto.getLecon());
            editedContenu.setContent(contenuDto.getContenu());
            Contenu saved = contenuRepository.save(editedContenu);
            return contenuMapper.toDto(saved);
        }

        return null;
    }

    @Override
    public List<ContenuDto> contenuList() {
        List<Contenu> contenus = contenuRepository.findAllSortedById();
        return contenus.stream()
                .map(contenuMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ContenuDto> contenuById(Long id) {
        Optional<Contenu> contenu = contenuRepository.findById(id);
        return contenu.map(contenuMapper::toDto);
    }

    @Override
    public void deleteContenu(Long id) {
            contenuRepository.deleteById(id);
    }

    @Override
    public List<ContenuDto> getLeconContenu(Long id) {
        List<Contenu> contenuList = contenuRepository.findByLeconIdOrderByIdAsc(id);
        return contenuList.stream()
                .map(contenuMapper::toDto)
                .collect(Collectors.toList());
    }
}
