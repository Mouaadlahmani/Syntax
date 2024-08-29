package com.mouad.Syntax.mapper;

import com.mouad.Syntax.dto.UtilisateurDto;
import com.mouad.Syntax.model.Utilisateur;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {
    Utilisateur toEntity(UtilisateurDto dto);
    List<Utilisateur> toEntityList(List<UtilisateurDto> dtoList);
    UtilisateurDto toDto(Utilisateur entity);
    List<UtilisateurDto> toDtoList(List<Utilisateur> entityList);
}
