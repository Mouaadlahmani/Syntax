package com.mouad.syntax.controller;

import com.mouad.syntax.dto.CertificatDto;
import com.mouad.syntax.service.CertificatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/certificat/")
@RequiredArgsConstructor
public class CertificatController {

    private final CertificatService certificatService;

    @PostMapping("generate/{userId}/{coursId}")
    public CertificatDto generateCertificat(@PathVariable("userId") Long userId, @PathVariable("coursId") Long coursId, @RequestBody CertificatDto certificatDto){
        return certificatService.generateCertificat(userId, coursId, certificatDto);
    }

    @GetMapping("{id}")
    public Optional<CertificatDto> getCertificat(@PathVariable("id") Long id){
        return certificatService.getCertificatById(id);
    }

    @GetMapping("all")
    public List<CertificatDto> getAllCertificat(){
        return certificatService.getCertificatList();
    }

    @GetMapping("my-certificates/{id}")
    public List<CertificatDto> utilisateurCertificats(@PathVariable("id") Long id){
        return certificatService.getUtilisateurCertificatList(id);
    }

    @GetMapping("/check/{userId}/{coursId}")
    public Boolean checkCertificateExists(@PathVariable("userId") Long userId, @PathVariable("coursId") Long coursId) {
        return certificatService.certificateExists(userId, coursId);
    }

    @GetMapping("cours-certificates/{id}")
    public List<CertificatDto> coursCertificats(@PathVariable("id") Long id){
        return certificatService.getCoursCertificats(id);
    }

    @GetMapping("count")
    public long count(){
        return certificatService.countCertificats();
    }

}
