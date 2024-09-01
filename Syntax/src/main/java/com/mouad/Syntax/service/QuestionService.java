package com.mouad.Syntax.service;

import com.mouad.Syntax.dto.QuestionDto;
import com.mouad.Syntax.model.Cours;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    QuestionDto addQuestion(QuestionDto questionDto);
    List<QuestionDto> getAll();
    Optional<QuestionDto> questionById(Long id);
     List<QuestionDto> findByCours(Long id);
    QuestionDto editQuestion(Long id, QuestionDto questionDto);
    void delete(Long id);
}
