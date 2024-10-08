package com.mouad.syntax.repository;

import com.mouad.syntax.model.Lecon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeconRepository extends JpaRepository<Lecon, Long> {
    List<Lecon> findByCoursesIdOrderByIdAsc(Long coursesId);
}
