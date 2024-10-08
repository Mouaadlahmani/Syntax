package com.mouad.syntax.service.impl;

import com.mouad.syntax.dto.CoursDto;
import com.mouad.syntax.mapper.CoursMapper;
import com.mouad.syntax.model.Cours;
import com.mouad.syntax.repository.CoursRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CoursServiceImplTest {

    @Mock
    private CoursRepository coursRepository;

    @Mock
    private CoursMapper coursMapper;

    @InjectMocks
    private CoursServiceImpl coursService;

    private Cours cours;
    private CoursDto coursDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Setup dummy data
        cours = new Cours();
        cours.setId(1L);
        cours.setTitre("Java Programming");

        coursDto = new CoursDto();
        coursDto.setId(1L);
        coursDto.setTitre("Java Programming");
    }

    @Test
    void ajouterCours() {
        when(coursMapper.toEntity(coursDto)).thenReturn(cours);
        when(coursRepository.save(cours)).thenReturn(cours);
        when(coursMapper.toDto(cours)).thenReturn(coursDto);

        CoursDto result = coursService.ajouterCours(coursDto);

        assertNotNull(result);
        assertEquals(coursDto.getId(), result.getId());
        verify(coursRepository).save(cours);
    }

    @Test
    void allCourses() {
        when(coursRepository.findAllSortedById()).thenReturn(Arrays.asList(cours));  // Use the correct method here
        when(coursMapper.toDto(cours)).thenReturn(coursDto);

        List<CoursDto> result = coursService.allCourses();

        assertEquals(1, result.size());  // Expecting 1 course in the result
        assertEquals(coursDto.getId(), result.get(0).getId());
        verify(coursRepository).findAllSortedById();  // Verify the correct repository method was called
    }


    @Test
    void coursById() {
        when(coursRepository.findById(1L)).thenReturn(Optional.of(cours));
        when(coursMapper.toDto(cours)).thenReturn(coursDto);

        Optional<CoursDto> result = coursService.coursById(1L);

        assertTrue(result.isPresent());
        assertEquals(coursDto.getId(), result.get().getId());
        verify(coursRepository).findById(1L);
    }

    @Test
    void editCours() {
        when(coursRepository.findById(1L)).thenReturn(Optional.of(cours));
        when(coursMapper.toEntity(coursDto)).thenReturn(cours);
        when(coursRepository.save(cours)).thenReturn(cours);
        when(coursMapper.toDto(cours)).thenReturn(coursDto);

        CoursDto result = coursService.editCours(1L, coursDto);

        assertNotNull(result);
        assertEquals(coursDto.getId(), result.getId());
        verify(coursRepository).findById(1L);
        verify(coursRepository).save(cours);
    }

    @Test
    void deleteCours() {
        doNothing().when(coursRepository).deleteById(1L);

        coursService.deleteCours(1L);

        verify(coursRepository).deleteById(1L);
    }

    @Test
    void editCours_notFound() {
        when(coursRepository.findById(1L)).thenReturn(Optional.empty());

        CoursDto result = coursService.editCours(1L, coursDto);

        assertNull(result);
        verify(coursRepository).findById(1L);
        verify(coursRepository, never()).save(any(Cours.class));
    }
}
