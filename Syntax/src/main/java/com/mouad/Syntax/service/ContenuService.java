package com.mouad.Syntax.service;

import com.mouad.Syntax.dto.ContenuDto;
import com.mouad.Syntax.model.Contenu;

import java.util.List;
import java.util.Optional;

public interface ContenuService {
    ContenuDto addContenu(Long id, ContenuDto contenuDto);
    ContenuDto editContenu(Long id, ContenuDto contenuDto);
    List<ContenuDto> contenuList();
    Optional<ContenuDto> contenuById(Long id);
    void deleteContenu(Long id);
    List<ContenuDto>getLeconContenu(Long id);
}
