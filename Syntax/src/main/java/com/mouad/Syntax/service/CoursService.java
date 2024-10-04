package com.mouad.Syntax.service;

import com.mouad.Syntax.dto.CoursDto;
import java.util.List;
import java.util.Optional;

public interface CoursService {
    CoursDto ajouterCours(CoursDto coursDto);
    List<CoursDto> allCourses();
    Optional<CoursDto> coursById(Long id);
    Optional<CoursDto> coursByQuestionId(Long id);
    CoursDto editCours(Long id, CoursDto coursDto);
    void deleteCours(Long id);
}
