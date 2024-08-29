package com.mouad.Syntax.mapper;

import com.mouad.Syntax.dto.QuizDto;
import com.mouad.Syntax.model.Quiz;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface QuizMapper {
    Quiz toEntity(QuizDto dto);
    List<Quiz> toEntityList(List<QuizDto> dtoList);
    QuizDto toDto(Quiz entity);
    List<QuizDto> toDtoList(List<Quiz> entityList);
}
