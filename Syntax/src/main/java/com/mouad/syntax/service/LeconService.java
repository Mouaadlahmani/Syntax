package com.mouad.syntax.service;

import com.mouad.syntax.dto.LeconDto;

import java.util.List;
import java.util.Optional;

public interface LeconService {
    LeconDto ajouterLecon(Long id, LeconDto leconDto);
    List<LeconDto> allLecons();
    Optional<LeconDto> leconById(Long id);
    LeconDto editLecon(Long id, LeconDto leconDto);
    void deleteLecon(Long id);
    List<LeconDto> leconsOfCours(Long id);
}
