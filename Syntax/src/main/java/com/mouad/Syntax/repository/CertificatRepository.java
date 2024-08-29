package com.mouad.Syntax.repository;

import com.mouad.Syntax.model.Certificat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificatRepository extends JpaRepository<Certificat, Long> {
}
