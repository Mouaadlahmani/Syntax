package com.mouad.CodeCraft.mapper;

import com.mouad.CodeCraft.dto.UtilisateurDto;
import com.mouad.CodeCraft.model.Utilisateur;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {
    Utilisateur toEntity(UtilisateurDto dto);
    List<Utilisateur> toEntityList(List<UtilisateurDto> dtoList);
    UtilisateurDto toDto(Utilisateur entity);
    List<UtilisateurDto> toDtoList(List<Utilisateur> entityList);
}
