package com.mouad.Syntax.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Cros-Site-Request-Forgery
        http
                .csrf( csrf -> csrf.disable()) // desactivation du CSRF pour tous les requetes http(GET-POST-PUT....)
                // Configuration des autorisations des requêtes HTTP
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/auth/authenticate", "/api/auth/register/utilisateur", "/api/auth/register/admin").permitAll()
                        .requestMatchers("/api/admin/**", "/api/certificat/all","/api/certificat/cours-certificates/**","/api/contenu/add/**","/api/contenu/all","/api/contenu/edit/**",
                                "/api/contenu/delete/**","/api/cours/add","/api/cours/edit/**","/api/cours/delete/**","/api/lecon/add/**","/api/lecon/edit/**","/api/lecon/delete/**",
                                "/api/question/create/**","/api/question/all","/api/question/","/api/question/edit/**","/api/question/delete/**","/api/quiz/add","/api/quiz/delete/**").hasAuthority("ADMIN")
                        .requestMatchers("/api/certificat/generate/**","/api/certificat/my-certificates/**","/api/quiz/submit/**").hasAuthority("UTILISATEUR")
                        .requestMatchers("/api/cours/all", "/api/question/course/","/api/quiz/num/**","/api/certificat/**","/api/contenu/**","/api/contenu/lecon/**",
                                "/api/cours/all","/api/cours/**","/api/cours/question/**","/api/lecon/all","/api/lecon/**","/api/lecon/cours/**","/api/question/**","/api/question/course/**",
                                "/api/quiz/all","/api/quiz/num/**","/api/certificat/check/**","/api/utilisateur/count","/api/quiz/count","/api/certificat/count","/api/cours/count").hasAnyAuthority("ADMIN", "UTILISATEUR")
                        .anyRequest().authenticated()


                )
                // Gestion des sessions
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                ) // l'app ne doit pas utiliser de sessions HTTP pour stocker l'état de l'auth
                //Configuration du fournisseur d'authentification
                .authenticationProvider(authenticationProvider)
                //Ajout d'un filtre personnalisé
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        //Construit et retourne l'objet SecurityFilterChain basé sur la configuration définie.
        return http.build();

    }
}