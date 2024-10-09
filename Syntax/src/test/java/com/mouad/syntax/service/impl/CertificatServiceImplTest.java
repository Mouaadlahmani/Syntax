package com.mouad.syntax.service.impl;

import com.mouad.syntax.dto.CertificatDto;
import com.mouad.syntax.mapper.CertificatMapper;
import com.mouad.syntax.model.Certificat;
import com.mouad.syntax.model.Cours;
import com.mouad.syntax.model.Utilisateur;
import com.mouad.syntax.repository.CertificatRepository;
import com.mouad.syntax.repository.CoursRepository;
import com.mouad.syntax.repository.PersonneRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CertificatServiceImplTest {

    @Mock
    private CertificatRepository certificatRepository;

    @Mock
    private CertificatMapper certificatMapper;

    @Mock
    private PersonneRepository personneRepository;

    @Mock
    private CoursRepository coursRepository;

    @InjectMocks
    private CertificatServiceImpl certificatService;

    private CertificatDto certificatDto;
    private Certificat certificat;
    private Utilisateur utilisateur;
    private Cours cours;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Setup dummy data
        utilisateur = new Utilisateur();
        utilisateur.setId(1L);
        utilisateur.setNom("John Doe");

        cours = new Cours();
        cours.setId(1L);
        cours.setTitre("Spring Boot Basics");

        certificat = new Certificat();
        certificat.setId(1L);
        certificat.setUtilisateur(utilisateur);
        certificat.setCourses(cours);
        certificat.setDateObtention(LocalDate.now());

        certificatDto = new CertificatDto();
        certificatDto.setId(1L);
        CertificatDto certificatDto = new CertificatDto();
        certificatDto.setId(1L); // assuming you have an ID for the DTO

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1L);
        utilisateur.setNom("Lahmani");
        utilisateur.setPrenom("Mouaad");
    }

    @Test
    void generateCertificat() {
        // Arrange
        when(certificatRepository.existsByUtilisateurIdAndCoursesId(1L, 1L)).thenReturn(false);
        when(coursRepository.findById(1L)).thenReturn(Optional.of(cours));
        when(personneRepository.findById(1L)).thenReturn(Optional.of(utilisateur));
        when(certificatMapper.toEntity(certificatDto)).thenReturn(certificat);
        when(certificatRepository.save(certificat)).thenReturn(certificat);
        when(certificatMapper.toDto(certificat)).thenReturn(certificatDto);

        // Act
        CertificatDto result = certificatService.generateCertificat(1L, 1L, certificatDto);

        // Assert
        assertNotNull(result);
        assertEquals(certificatDto.getId(), result.getId());
        verify(certificatRepository).save(certificat);
    }

    @Test
    void getCertificatById() {
        // Arrange
        when(certificatRepository.findById(1L)).thenReturn(Optional.of(certificat));
        when(certificatMapper.toDto(certificat)).thenReturn(certificatDto);

        // Act
        Optional<CertificatDto> result = certificatService.getCertificatById(1L);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(certificatDto.getId(), result.get().getId());
        verify(certificatRepository).findById(1L);
    }

    @Test
    void getCertificatById_NotFound() {
        // Arrange
        when(certificatRepository.findById(1L)).thenReturn(Optional.empty());

        // Act
        Optional<CertificatDto> result = certificatService.getCertificatById(1L);

        // Assert
        assertFalse(result.isPresent());
        verify(certificatRepository).findById(1L);
    }

    @Test
    void getCertificatList() {
        // Arrange
        when(certificatRepository.findAll()).thenReturn(Arrays.asList(certificat));
        when(certificatMapper.toDto(certificat)).thenReturn(certificatDto);

        // Act
        var result = certificatService.getCertificatList();

        // Assert
        assertEquals(1, result.size());
        assertEquals(certificatDto.getId(), result.get(0).getId());
        verify(certificatRepository).findAll();
    }

    @Test
    void getUtilisateurCertificatList() {
        // Arrange
        when(certificatRepository.findAllByUtilisateurId(1L)).thenReturn(Arrays.asList(certificat));
        when(certificatMapper.toDto(certificat)).thenReturn(certificatDto);

        // Act
        var result = certificatService.getUtilisateurCertificatList(1L);

        // Assert
        assertEquals(1, result.size());
        assertEquals(certificatDto.getId(), result.get(0).getId());
        verify(certificatRepository).findAllByUtilisateurId(1L);
    }

    @Test
    void getCoursCertificats() {
        // Arrange
        when(certificatRepository.findAllByCoursesId(1L)).thenReturn(Arrays.asList(certificat));
        when(certificatMapper.toDto(certificat)).thenReturn(certificatDto);

        // Act
        var result = certificatService.getCoursCertificats(1L);

        // Assert
        assertEquals(1, result.size());
        assertEquals(certificatDto.getId(), result.get(0).getId());
        verify(certificatRepository).findAllByCoursesId(1L);
    }

    @Test
    void certificateExists() {
        // Arrange
        when(certificatRepository.existsByUtilisateurIdAndCoursesId(1L, 1L)).thenReturn(true);

        // Act
        Boolean exists = certificatService.certificateExists(1L, 1L);

        // Assert
        assertTrue(exists);
        verify(certificatRepository).existsByUtilisateurIdAndCoursesId(1L, 1L);
    }

    @Test
    void countCertificats() {
        // Arrange
        when(certificatRepository.count()).thenReturn(5L);

        // Act
        long count = certificatService.countCertificats();

        // Assert
        assertEquals(5L, count);
        verify(certificatRepository).count();
    }
}
