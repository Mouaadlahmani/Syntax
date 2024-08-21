package com.mouad.CodeCraft.mapper;

import com.mouad.CodeCraft.dto.QuestionDto;
import com.mouad.CodeCraft.model.Question;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    Question toEntity(QuestionDto dto);
    List<Question> toEntityList(List<QuestionDto> dtoList);
    QuestionDto toDto(Question entity);
    List<QuestionDto> toDtoList(List<Question> entityList);
}
