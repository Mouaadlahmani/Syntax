package com.mouad.Syntax.service.impl;

import com.mouad.Syntax.dto.UtilisateurDto;
import com.mouad.Syntax.mapper.UtilisateurMapper;
import com.mouad.Syntax.model.Utilisateur;
import com.mouad.Syntax.repository.UtilisateurRepository;
import com.mouad.Syntax.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    UtilisateurMapper utilisateurMapper;


    @Override
    public List<UtilisateurDto> findAll() {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        return utilisateurs.stream()
                .map(utilisateurMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UtilisateurDto> findById(Long id) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        return utilisateur.map(utilisateurMapper::toDto);
    }

    @Override
    public UtilisateurDto editInfos(Long id, UtilisateurDto utilisateurDto) {
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(id);
        if (optionalUtilisateur.isPresent()) {
            Utilisateur utilisateur = optionalUtilisateur.get();
            utilisateur.setId(id);
            utilisateur.setPrenom(utilisateurDto.getPrenom());
            utilisateur.setNom(utilisateurDto.getNom());
            utilisateur.setEmail(utilisateurDto.getEmail());
            utilisateur.setPassword(utilisateurDto.getPassword());

            Utilisateur savedUtilisateur = utilisateurRepository.save(utilisateur);
            return utilisateurMapper.toDto(savedUtilisateur);
        }
        return null;
    }

    @Override
    public long count() {
        return utilisateurRepository.count();
    }
}
