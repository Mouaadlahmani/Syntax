package com.mouad.syntax.service;

import com.mouad.syntax.dto.QuestionDto;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    QuestionDto addQuestion(Long id, QuestionDto questionDto);
    List<QuestionDto> getAll();
    Optional<QuestionDto> questionById(Long id);
     List<QuestionDto> findByCours(Long id);
    QuestionDto editQuestion(Long id, QuestionDto questionDto);
    void delete(Long id);
}
