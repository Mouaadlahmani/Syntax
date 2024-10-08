package com.mouad.syntax.mapper;

import com.mouad.syntax.dto.QuizDto;
import com.mouad.syntax.model.Quiz;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface QuizMapper {
    Quiz toEntity(QuizDto dto);
    List<Quiz> toEntityList(List<QuizDto> dtoList);
    QuizDto toDto(Quiz entity);
    List<QuizDto> toDtoList(List<Quiz> entityList);
}
