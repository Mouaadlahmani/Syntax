package com.mouad.syntax.service;

import com.mouad.syntax.dto.CertificatDto;

import java.util.List;
import java.util.Optional;

public interface CertificatService {
    CertificatDto generateCertificat(Long userId , Long coursId, CertificatDto certificatDto);
    Optional<CertificatDto> getCertificatById(Long id);
    List<CertificatDto> getCertificatList();
    List<CertificatDto> getUtilisateurCertificatList(Long id);
    List<CertificatDto> getCoursCertificats(Long id);
    Boolean certificateExists(Long userId, Long coursId);
    long countCertificats();
}
