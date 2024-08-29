package com.mouad.Syntax.service;

import com.mouad.Syntax.dto.QuestionDto;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    QuestionDto addQuestion(QuestionDto questionDto);
    List<QuestionDto> getAll();
    Optional<QuestionDto> questionById(Long id);
    QuestionDto editQuestion(Long id, QuestionDto questionDto);
    void delete(Long id);
}
