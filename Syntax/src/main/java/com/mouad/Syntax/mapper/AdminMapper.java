package com.mouad.Syntax.mapper;

import com.mouad.Syntax.dto.AdminDto;
import com.mouad.Syntax.model.Admin;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface AdminMapper {

    Admin toEntity(AdminDto dto);
    List<Admin> toEntityList(List<AdminDto> dtoList);
    AdminDto toDto(Admin entity);
    List<AdminDto> toDtoList(List<Admin> entityList);
}
