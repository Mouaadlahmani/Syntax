package com.mouad.Syntax.config;

import com.mouad.Syntax.repository.PersonneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor // génère auto un constructeur pour tous les champs finaux
public class ApplicationConfig {

    private final PersonneRepository personneRepository;

    // Objet qui est instancié gerer par Ioc
    //Ioc : creer des objets assurer que les dependances entre eux sont creer correct
    @Bean
    public UserDetailsService userDetailsService(){
        return email -> personneRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("utilisateur non trouvé"));
    }

    //Vlidation les infos d'identification d'un utilisateur
    //utilisation UserDetailsService pour la recup des infos a partir DB
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }


    //Encapsule configuration d'authentification pour l'application

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)throws Exception{
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // PassEncoder : interface de SpringSecurity fournit des mthode pour encoder les modpass

}