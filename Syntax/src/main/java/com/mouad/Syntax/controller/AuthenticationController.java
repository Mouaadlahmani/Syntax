package com.mouad.Syntax.controller;

import com.mouad.Syntax.dto.AuthenticationRequest;
import com.mouad.Syntax.dto.AuthenticationResponse;
import com.mouad.Syntax.dto.RegisterRequest;
import com.mouad.Syntax.model.Admin;
import com.mouad.Syntax.model.Utilisateur;
import com.mouad.Syntax.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired
    private final AuthenticationService authenticationService;

    @PostMapping("/register/admin")
    public ResponseEntity<AuthenticationResponse> registerAdmin(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(authenticationService.registerAdmin(request));
    }

    @PostMapping("/register/utilisateur")
    public ResponseEntity<AuthenticationResponse> registerUtilisateur(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(authenticationService.registerUtilisateur(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}