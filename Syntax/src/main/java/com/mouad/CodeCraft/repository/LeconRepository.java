package com.mouad.CodeCraft.repository;

import com.mouad.CodeCraft.model.Lecon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeconRepository extends JpaRepository<Lecon, Long> {
}
