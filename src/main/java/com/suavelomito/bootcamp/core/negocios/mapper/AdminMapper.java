package com.suavelomito.bootcamp.core.negocios.mapper;

import com.suavelomito.bootcamp.core.entity.Admin;
import com.suavelomito.bootcamp.core.negocios.dto.AdminDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface AdminMapper {


        @Mapping(source = "username", target = "username")
        @Mapping(source = "pass", target = "pass")
        AdminDTO entityToDTO(Admin admin);

        @Mapping(source = "username", target="username")
        @Mapping(source = "pass", target = "pass")
        Admin dtoToEntity(AdminDTO adminDto);
    }

