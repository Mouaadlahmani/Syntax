package com.mouad.Syntax.service.impl;

import com.mouad.Syntax.dto.ContenuDto;
import com.mouad.Syntax.mapper.ContenuMapper;
import com.mouad.Syntax.model.Contenu;
import com.mouad.Syntax.model.Lecon;
import com.mouad.Syntax.repository.ContenuRepository;
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

class ContenuServiceImplTest {

    @Mock
    private ContenuRepository contenuRepository;

    @Mock
    private LeconRepository leconRepository;

    @Mock
    private ContenuMapper contenuMapper;

    @InjectMocks
    private ContenuServiceImpl contenuService;

    private Contenu contenu;
    private ContenuDto contenuDto;
    private Lecon lecon;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Setup dummy data
        lecon = new Lecon();
        lecon.setId(1L);

        contenu = new Contenu();
        contenu.setId(1L);
        contenu.setLecon(lecon);

        contenuDto = new ContenuDto();
        contenuDto.setId(1L);
    }

    @Test
    void addContenu() {
        when(leconRepository.findById(1L)).thenReturn(Optional.of(lecon));
        when(contenuMapper.toEntity(contenuDto)).thenReturn(contenu);
        when(contenuRepository.save(contenu)).thenReturn(contenu);
        when(contenuMapper.toDto(contenu)).thenReturn(contenuDto);

        ContenuDto result = contenuService.addContenu(1L, contenuDto);

        assertNotNull(result);
        assertEquals(contenuDto.getId(), result.getId());
        verify(contenuRepository).save(contenu);
        verify(leconRepository).findById(1L);
    }

    @Test
    void editContenu() {
        // You can implement this test after completing the logic in `editContenu()`
    }

//    @Test
//    void contenuList() {
//        when(contenuRepository.findAll()).thenReturn(Arrays.asList(contenu));
//        when(contenuMapper.toDto(contenu)).thenReturn(contenuDto);
//
//        var result = contenuService.contenuList();
//
//        assertEquals(1, result.size());
//        assertEquals(contenuDto.getId(), result.get(0).getId());
//        verify(contenuRepository).findAll();
//    }

    @Test
    void contenuById() {
        when(contenuRepository.findById(1L)).thenReturn(Optional.of(contenu));
        when(contenuMapper.toDto(contenu)).thenReturn(contenuDto);

        Optional<ContenuDto> result = contenuService.contenuById(1L);

        assertTrue(result.isPresent());
        assertEquals(contenuDto.getId(), result.get().getId());
        verify(contenuRepository).findById(1L);
    }

    @Test
    void deleteContenu() {
        doNothing().when(contenuRepository).deleteById(1L);

        contenuService.deleteContenu(1L);

        verify(contenuRepository).deleteById(1L);
    }
}
