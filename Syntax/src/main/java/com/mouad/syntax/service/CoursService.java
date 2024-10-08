package com.mouad.syntax.service;

import com.mouad.syntax.dto.CoursDto;
import java.util.List;
import java.util.Optional;

public interface CoursService {
    CoursDto ajouterCours(CoursDto coursDto);
    List<CoursDto> allCourses();
    Optional<CoursDto> coursById(Long id);
    Optional<CoursDto> coursByQuestionId(Long id);
    CoursDto editCours(Long id, CoursDto coursDto);
    void deleteCours(Long id);
    long count();
}
