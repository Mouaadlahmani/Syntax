package com.mouad.Syntax.service;

import com.mouad.Syntax.dto.CertificatDto;

import java.util.List;
import java.util.Optional;

public interface CertificatService {
    CertificatDto generateCertificat(Long userId , Long coursId, CertificatDto certificatDto);
    Optional<CertificatDto> getCertificatById(Long id);
    List<CertificatDto> getCertificatList();
    List<CertificatDto> getUtilisateurCertificatList(Long id);
    List<CertificatDto> getCoursCertificats(Long id);
}
