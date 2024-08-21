package com.mouad.CodeCraft.mapper;

import com.mouad.CodeCraft.dto.AdminDto;
import com.mouad.CodeCraft.model.Admin;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface AdminMapper {

    Admin toEntity(AdminDto dto);
    List<Admin> toEntityList(List<AdminDto> dtoList);
    AdminDto toDto(Admin entity);
    List<AdminDto> toDtoList(List<Admin> entityList);
}
