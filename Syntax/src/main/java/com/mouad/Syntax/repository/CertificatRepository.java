package com.mouad.Syntax.repository;

import com.mouad.Syntax.model.Certificat;
import com.mouad.Syntax.model.Cours;
import com.mouad.Syntax.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificatRepository extends JpaRepository<Certificat, Long> {
    List<Certificat> findAllByUtilisateurId(Long id);
    List<Certificat> findAllByCoursesId(Long id);
}
