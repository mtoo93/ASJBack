package com.suavelomito.bootcamp.core.service;
import com.suavelomito.bootcamp.core.entity.Cliente;
import com.suavelomito.bootcamp.core.negocios.dto.ClienteDTO;

import java.util.Optional;

public interface ClienteService {
   Optional<Cliente> findBynombreClienteAndOwnerCliente(String nombreCliente, String ownerCliente);

   Cliente addCliente(ClienteDTO clienteDTO);
}
