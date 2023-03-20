package com.suavelomito.bootcamp.core.negocios.mapper;

import com.suavelomito.bootcamp.core.entity.Reserva;
import com.suavelomito.bootcamp.core.entity.Servicio;
import com.suavelomito.bootcamp.core.negocios.dto.ReservaDTO;
import com.suavelomito.bootcamp.core.negocios.dto.ServicioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ServicioMapper {

    ServicioDTO entityToDTO(Servicio servicio);

    Servicio dtoToEntity(ServicioDTO servicioDto);
}
