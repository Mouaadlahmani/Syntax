package com.mouad.Syntax.service;

import com.mouad.Syntax.dto.AuthenticationRequest;
import com.mouad.Syntax.dto.AuthenticationResponse;
import com.mouad.Syntax.dto.RegisterRequest;
import com.mouad.Syntax.model.Admin;
import com.mouad.Syntax.model.Personne;
import com.mouad.Syntax.model.Utilisateur;
import com.mouad.Syntax.model.enums.Role;
import com.mouad.Syntax.repository.PersonneRepository;
import com.mouad.Syntax.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final PersonneRepository personneRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final JWTService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    public AuthenticationResponse registerAdmin(RegisterRequest request){

        Admin admin = new Admin();
                admin.setPrenom(request.getPrenom());
                admin.setNom(request.getNom());
                admin.setEmail(request.getEmail());
                admin.setPassword(passwordEncoder.encode(request.getPassword()));
                admin.setRole(Role.ADMIN);
        personneRepository.save(admin);

        var jwtToken = jwtService.generateToken(admin);
        return  AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }


    public AuthenticationResponse registerUtilisateur(RegisterRequest request){
        Utilisateur user = new Utilisateur();
        user.setPrenom(request.getPrenom());
        user.setNom(request.getNom());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.UTILISATEUR);

        utilisateurRepository.save(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request){

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = personneRepository.findByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}