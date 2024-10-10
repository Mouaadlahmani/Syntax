package com.mouad.syntax.service.impl;

import com.mouad.syntax.dto.CertificatDto;
import com.mouad.syntax.exeption.CertificateAlreadyExistsException;
import com.mouad.syntax.exeption.CourseNotFoundException;
import com.mouad.syntax.exeption.UserNotFoundException;
import com.mouad.syntax.mapper.CertificatMapper;
import com.mouad.syntax.model.Certificat;
import com.mouad.syntax.model.Cours;
import com.mouad.syntax.model.Utilisateur;
import com.mouad.syntax.repository.CertificatRepository;
import com.mouad.syntax.repository.CoursRepository;
import com.mouad.syntax.repository.PersonneRepository;
import com.mouad.syntax.service.CertificatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CertificatServiceImpl implements CertificatService {

    private final CertificatRepository certificatRepository;

    private final CertificatMapper certificatMapper;

    private final PersonneRepository personneRepository;

    private final CoursRepository coursRepository;

    @Override
    public CertificatDto generateCertificat(Long userId, Long coursId, CertificatDto certificatDto) {
        // Check if certificate already exists
        if (certificateExists(userId, coursId)) {
            throw new CertificateAlreadyExistsException("Certificate already exists for this user and course.");
        }

        Certificat certificat = certificatMapper.toEntity(certificatDto);
        Cours cours = coursRepository.findById(coursId)
                .orElseThrow(() -> new CourseNotFoundException("Course not found!"));

        Utilisateur utilisateur = (Utilisateur) personneRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found!"));

        certificat.setCourses(cours);
        certificat.setUtilisateur(utilisateur);
        certificat.setDateObtention(LocalDate.now());

        Certificat saved = certificatRepository.save(certificat);
        return certificatMapper.toDto(saved);
    }

    @Override
    public Optional<CertificatDto> getCertificatById(Long id) {
        Optional<Certificat> certificat = certificatRepository.findById(id);
        return certificat.map(certificatMapper::toDto);
    }

    @Override
    public List<CertificatDto> getCertificatList() {
        List<Certificat> certificats = certificatRepository.findAll();
        return certificats.stream()
                .map(certificatMapper::toDto)
                .toList();
    }

    @Override
    public List<CertificatDto> getUtilisateurCertificatList(Long id) {
        List<Certificat> utilisateurCertificats = certificatRepository.findAllByUtilisateurId(id);
        return utilisateurCertificats.stream()
                .map(certificatMapper::toDto)
                .toList();
    }

    @Override
    public List<CertificatDto> getCoursCertificats(Long id) {
        List<Certificat> coursCertificats = certificatRepository.findAllByCoursesId(id);
        return coursCertificats.stream()
                .map(certificatMapper::toDto)
                .toList();
    }

    @Override
    public Boolean certificateExists(Long userId, Long coursId) {
        return certificatRepository.existsByUtilisateurIdAndCoursesId(userId, coursId);
    }

    @Override
    public long countCertificats() {
        return certificatRepository.count();
    }
}
