package com.suavelomito.bootcamp.core.negocios.mapper;

import com.suavelomito.bootcamp.core.entity.Cliente;
import com.suavelomito.bootcamp.core.entity.Reserva;
import com.suavelomito.bootcamp.core.negocios.dto.ClienteDTO;
import com.suavelomito.bootcamp.core.negocios.dto.ReservaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    @Mapping(target = "nombreCliente")
    @Mapping(target = "ownerCliente")
    @Mapping(target = "telefono")
    @Mapping(target = "raza")
    @Mapping(target = "size")
    @Mapping(target = "observaciones")
    ClienteDTO entityToDTO(Cliente cliente);

    @Mapping(target = "nombreCliente")
    @Mapping(target = "ownerCliente")
    @Mapping(target = "telefono")
    @Mapping(target = "raza")
    @Mapping(target = "size")
    @Mapping(target = "observaciones")
    Cliente dtoToEntity(ClienteDTO clienteDto);
}