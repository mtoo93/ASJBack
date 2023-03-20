package com.suavelomito.bootcamp.core.service.implementacion;

import com.suavelomito.bootcamp.core.entity.Servicio;
import com.suavelomito.bootcamp.core.repository.ServicioRepository;
import com.suavelomito.bootcamp.core.service.ServicioService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioServiceImpl implements ServicioService {
    private final ServicioRepository sRepo;

    public ServicioServiceImpl(ServicioRepository sRepo){
        this.sRepo = sRepo;
    }

    @Override
    public Optional<Servicio> findByName(String nombreServicio) {
        return sRepo.findBynombreServicio(nombreServicio);
    }
}
