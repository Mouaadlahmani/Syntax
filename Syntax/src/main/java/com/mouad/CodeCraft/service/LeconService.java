package com.mouad.CodeCraft.service;

import com.mouad.CodeCraft.dto.LeconDto;

import java.util.List;
import java.util.Optional;

public interface LeconService {
    LeconDto ajouterLecon(LeconDto leconDto);
    List<LeconDto> allLecons();
    Optional<LeconDto> LeconById(Long id);
    LeconDto editLecon(Long id, LeconDto leconDto);
    void deleteLecon(Long id);
}
