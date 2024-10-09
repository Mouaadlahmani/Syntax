package com.mouad.syntax.service.impl;

import com.mouad.syntax.dto.ContenuDto;
import com.mouad.syntax.exeption.ContenuNotFoundException;
import com.mouad.syntax.exeption.LeconNotFoundException;
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
        Lecon lecon = leconRepository.findById(id)
                .orElseThrow(() -> new LeconNotFoundException("Leçon not found!"));
        Contenu contenu = contenuMapper.toEntity(contenuDto);
        contenu.setLecon(lecon);
        Contenu saved = contenuRepository.save(contenu);
        return contenuMapper.toDto(saved);
    }

    @Override
    public ContenuDto editContenu(Long id, ContenuDto contenuDto) {
        Contenu contenu = contenuRepository.findById(id)
                .orElseThrow(() -> new ContenuNotFoundException("Contenu not found!"));
        contenu.setTitre(contenuDto.getTitre());
        contenu.setLecon(contenuDto.getLecon());
        contenu.setDescription(contenuDto.getDescription());
        Contenu saved = contenuRepository.save(contenu);
        return contenuMapper.toDto(saved);
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
        Contenu contenu = contenuRepository.findById(id)
                .orElseThrow(() -> new ContenuNotFoundException("Contenu not found!"));
        return Optional.of(contenuMapper.toDto(contenu));
    }

    @Override
    public void deleteContenu(Long id) {
        if (!contenuRepository.existsById(id)) {
            throw new ContenuNotFoundException("Contenu not found!");
        }
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
