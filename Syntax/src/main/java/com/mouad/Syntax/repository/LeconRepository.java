package com.mouad.Syntax.repository;

import com.mouad.Syntax.model.Lecon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeconRepository extends JpaRepository<Lecon, Long> {
    @Query("SELECT l FROM Lecon l ORDER BY l.id ASC")
    List<Lecon> findAllSortedById();
    List<Lecon> findByCoursesId(Long id);
}
