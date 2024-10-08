package com.mouad.syntax.service.impl;

import com.mouad.syntax.dto.LeconDto;
import com.mouad.syntax.mapper.LeconMapper;
import com.mouad.syntax.model.Cours;
import com.mouad.syntax.model.Lecon;
import com.mouad.syntax.repository.CoursRepository;
import com.mouad.syntax.repository.LeconRepository;
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
        // Arrange
        when(coursRepository.findById(1L)).thenReturn(Optional.of(cours));
        when(leconMapper.toEntity(leconDto)).thenReturn(lecon);
        when(leconRepository.save(lecon)).thenReturn(lecon);
        when(leconMapper.toDto(lecon)).thenReturn(leconDto);

        // Act
        LeconDto result = leconService.ajouterLecon(1L, leconDto);

        // Assert
        assertNotNull(result);
        assertEquals(leconDto.getId(), result.getId());
        verify(coursRepository).findById(1L);
        verify(leconRepository).save(lecon);
    }

    @Test
    void ajouterLecon_CoursNotFound() {
        // Arrange
        when(coursRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        Exception exception = assertThrows(RuntimeException.class, () -> {
            leconService.ajouterLecon(1L, leconDto);
        });

        assertEquals("Cours Not Found", exception.getMessage());
    }

    @Test
    void allLecons() {
        // Arrange
        when(leconRepository.findAll()).thenReturn(Arrays.asList(lecon));
        when(leconMapper.toDto(lecon)).thenReturn(leconDto);

        // Act
        var result = leconService.allLecons();

        // Assert
        assertEquals(1, result.size());
        assertEquals(leconDto.getId(), result.get(0).getId());
        verify(leconRepository).findAll();
    }

    @Test
    void leconById() {
        // Arrange
        when(leconRepository.findById(1L)).thenReturn(Optional.of(lecon));
        when(leconMapper.toDto(lecon)).thenReturn(leconDto);

        // Act
        Optional<LeconDto> result = leconService.leconById(1L);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(leconDto.getId(), result.get().getId());
        verify(leconRepository).findById(1L);
    }

    @Test
    void leconById_NotFound() {
        // Arrange
        when(leconRepository.findById(1L)).thenReturn(Optional.empty());

        // Act
        Optional<LeconDto> result = leconService.leconById(1L);

        // Assert
        assertFalse(result.isPresent());
        verify(leconRepository).findById(1L);
    }

    @Test
    void editLecon() {
        // Arrange
        when(leconRepository.findById(1L)).thenReturn(Optional.of(lecon));
        when(leconRepository.save(lecon)).thenReturn(lecon);
        when(leconMapper.toDto(lecon)).thenReturn(leconDto);

        // Act
        LeconDto result = leconService.editLecon(1L, leconDto);

        // Assert
        assertNotNull(result);
        assertEquals(leconDto.getId(), result.getId());
        verify(leconRepository).findById(1L);
        verify(leconRepository).save(lecon);
    }

    @Test
    void deleteLecon() {
        // Arrange
        doNothing().when(leconRepository).deleteById(1L);

        // Act
        leconService.deleteLecon(1L);

        // Assert
        verify(leconRepository).deleteById(1L);
    }

    @Test
    void deleteLecon_WhenNotFound() {
        // Arrange
        doThrow(new RuntimeException("Lecon not found")).when(leconRepository).deleteById(1L);

        // Act & Assert
        Exception exception = assertThrows(RuntimeException.class, () -> {
            leconService.deleteLecon(1L);
        });

        assertEquals("Lecon not found", exception.getMessage());
    }
}
