package com.mouad.Syntax.controller;

import com.mouad.Syntax.dto.CertificatDto;
import com.mouad.Syntax.service.CertificatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/certificat/")
public class CertificatController {

    @Autowired
    CertificatService certificatService;

    @PostMapping("generate/{id}")
    public CertificatDto generateCertificat(@PathVariable Long id, @RequestBody CertificatDto certificatDto){
        return certificatService.generateCertificat(id, certificatDto);
    }

    @GetMapping("{id}")
    public Optional<CertificatDto> getCertificat(@PathVariable Long id){
        return certificatService.getCertificatById(id);
    }

    @GetMapping("all")
    public List<CertificatDto> getAllCertificat(){
        return certificatService.getCertificatList();
    }

    @GetMapping("my-certificates/{id}")
    public List<CertificatDto> utilisateurCertificats(@PathVariable Long id){
        return certificatService.getUtilisateurCertificatList(id);
    }

    @GetMapping("cours-certificates/{id}")
    public List<CertificatDto> coursCertificats(@PathVariable Long id){
        return certificatService.getCoursCertificats(id);
    }

}
