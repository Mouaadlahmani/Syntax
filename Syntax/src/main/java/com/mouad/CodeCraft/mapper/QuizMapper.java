package com.mouad.CodeCraft.mapper;

import com.mouad.CodeCraft.dto.QuizDto;
import com.mouad.CodeCraft.model.Quiz;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface QuizMapper {
    Quiz toEntity(QuizDto dto);
    List<Quiz> toEntityList(List<QuizDto> dtoList);
    QuizDto toDto(Quiz entity);
    List<QuizDto> toDtoList(List<Quiz> entityList);
}
