package com.mouad.Syntax.service.impl;

import com.mouad.Syntax.dto.CertificatDto;
import com.mouad.Syntax.mapper.CertificatMapper;
import com.mouad.Syntax.model.Certificat;
import com.mouad.Syntax.model.Cours;
import com.mouad.Syntax.model.Utilisateur;
import com.mouad.Syntax.repository.CertificatRepository;
import com.mouad.Syntax.repository.CoursRepository;
import com.mouad.Syntax.repository.PersonneRepository;
import com.mouad.Syntax.repository.UtilisateurRepository;
import com.mouad.Syntax.service.CertificatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CertificatServiceImpl implements CertificatService {

    @Autowired
    CertificatRepository certificatRepository;
    @Autowired
    CertificatMapper certificatMapper;
    @Autowired
    PersonneRepository personneRepository;
    @Autowired
    CoursRepository coursRepository;

    @Override
    public CertificatDto generateCertificat(Long id, CertificatDto certificatDto) {
        Certificat certificat = certificatMapper.toEntity(certificatDto);
        Utilisateur utilisateur = (Utilisateur) personneRepository.findById(id).orElseThrow();
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
                .collect(Collectors.toList());
    }

    @Override
    public List<CertificatDto> getUtilisateurCertificatList(Long id) {
        Utilisateur utilisateur = (Utilisateur) personneRepository.findById(id).orElseThrow();
        List<Certificat> utilisateurCertificats = certificatRepository.findAllByUtilisateur(utilisateur);
        return utilisateurCertificats.stream()
                .map(certificatMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CertificatDto> getCoursCertificats(Long id) {
        Cours cours = coursRepository.findById(id).orElseThrow();
        List<Certificat> coursCertificats = certificatRepository.findAllByCourses(cours);
        return coursCertificats.stream()
                .map(certificatMapper::toDto)
                .collect(Collectors.toList());
    }
}
