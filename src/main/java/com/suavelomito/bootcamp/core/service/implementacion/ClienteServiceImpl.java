package com.suavelomito.bootcamp.core.service.implementacion;

import com.suavelomito.bootcamp.core.entity.Cliente;
import com.suavelomito.bootcamp.core.negocios.dto.ClienteDTO;
import com.suavelomito.bootcamp.core.repository.ClienteRepository;
import com.suavelomito.bootcamp.core.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository cRepo;

    public ClienteServiceImpl(ClienteRepository cRepo){
        this.cRepo = cRepo;
    }
    @Override
    public Optional<Cliente> findBynombreClienteAndOwnerCliente(String nombreCliente, String ownerCliente) {
        return cRepo.findBynombreClienteAndOwnerCliente(nombreCliente,ownerCliente);
    }

    @Override
    public Cliente addCliente(ClienteDTO clienteDTO) {
        Optional<Cliente> clienteOptional = cRepo.findBynombreClienteAndOwnerCliente(clienteDTO.nombreCliente, clienteDTO.ownerCliente);
        if (clienteOptional.isPresent()) {
            return clienteOptional.get();
        } else {
            Cliente clienteNuevo = new Cliente();
            clienteNuevo.setNombreCliente(clienteDTO.nombreCliente);
            clienteNuevo.setOwnerCliente(clienteDTO.ownerCliente);
            clienteNuevo.setTelefono(clienteDTO.telefono);
            clienteNuevo.setRaza(clienteDTO.raza);
            clienteNuevo.setSize(clienteDTO.size);
            clienteNuevo.setObservaciones(clienteDTO.observaciones);
            return cRepo.save(clienteNuevo);
        }
    }
    }

