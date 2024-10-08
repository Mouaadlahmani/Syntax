package com.mouad.syntax.controller;

import com.mouad.syntax.dto.AuthenticationRequest;
import com.mouad.syntax.dto.AuthenticationResponse;
import com.mouad.syntax.dto.RegisterRequest;
import com.mouad.syntax.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AuthenticationController {

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