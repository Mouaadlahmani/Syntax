package com.mouad.Syntax.service.impl;

import com.mouad.Syntax.dto.LeconDto;
import com.mouad.Syntax.mapper.LeconMapper;
import com.mouad.Syntax.model.Cours;
import com.mouad.Syntax.model.Lecon;
import com.mouad.Syntax.repository.CoursRepository;
import com.mouad.Syntax.repository.LeconRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LeconServiceImplTest {

    @Mock
    private LeconRepository leconRepository;

    @Mock
    private CoursRepository coursRepository;

    @Mock
    private LeconMapper leconMapper;

    @InjectMocks
    private LeconServiceImpl leconService;

    private Lecon lecon;
    private LeconDto leconDto;
    private Cours cours;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Setup dummy data
        cours = new Cours();
        cours.setId(1L);
        cours.setTitre("Spring Boot Basics");

        lecon = new Lecon();
        lecon.setId(1L);
        lecon.setTitre("Introduction to Spring Boot");

        leconDto = new LeconDto();
        leconDto.setId(1L);
        leconDto.setTitre("Introduction to Spring Boot");
    }

    @Test
    void ajouterLecon() {
        when(coursRepository.findById(1L)).thenReturn(Optional.of(cours));
        when(leconMapper.toEntity(leconDto)).thenReturn(lecon);
        when(leconRepository.save(lecon)).thenReturn(lecon);
        when(leconMapper.toDto(lecon)).thenReturn(leconDto);

        LeconDto result = leconService.ajouterLecon(1L, leconDto);

        assertNotNull(result);
        assertEquals(leconDto.getId(), result.getId());
        verify(coursRepository).findById(1L);
        verify(leconRepository).save(lecon);
    }

    @Test
    void allLecons() {
        when(leconRepository.findAll()).thenReturn(Arrays.asList(lecon));
        when(leconMapper.toDto(lecon)).thenReturn(leconDto);

        var result = leconService.allLecons();

        assertEquals(1, result.size());
        assertEquals(leconDto.getId(), result.get(0).getId());
        verify(leconRepository).findAll();
    }

    @Test
    void leconById() {
        when(leconRepository.findById(1L)).thenReturn(Optional.of(lecon));
        when(leconMapper.toDto(lecon)).thenReturn(leconDto);

        Optional<LeconDto> result = leconService.LeconById(1L);

        assertTrue(result.isPresent());
        assertEquals(leconDto.getId(), result.get().getId());
        verify(leconRepository).findById(1L);
    }

    @Test
    void editLecon() {
        when(leconRepository.findById(1L)).thenReturn(Optional.of(lecon));
        when(leconRepository.save(lecon)).thenReturn(lecon);
        when(leconMapper.toDto(lecon)).thenReturn(leconDto);

        LeconDto result = leconService.editLecon(1L, leconDto);

        assertNotNull(result);
        assertEquals(leconDto.getId(), result.getId());
        verify(leconRepository).findById(1L);
        verify(leconRepository).save(lecon);
    }

    @Test
    void deleteLecon() {
        doNothing().when(leconRepository).deleteById(1L);

        leconService.deleteLecon(1L);

        verify(leconRepository).deleteById(1L);
    }
}
