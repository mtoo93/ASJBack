package com.suavelomito.bootcamp.core.negocios.mapper;

import com.suavelomito.bootcamp.core.entity.Admin;
import com.suavelomito.bootcamp.core.entity.Reserva;
import com.suavelomito.bootcamp.core.negocios.dto.AdminDTO;
import com.suavelomito.bootcamp.core.negocios.dto.ReservaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Mapper(componentModel = "spring")
    public interface ReservaMapper {

        ReservaDTO entityToDTO(Reserva reserva);
        Reserva dtoToEntity(ReservaDTO reservaDto);
    }
