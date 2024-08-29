package com.mouad.Syntax.repository;

import com.mouad.Syntax.model.Lecon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeconRepository extends JpaRepository<Lecon, Long> {
}
