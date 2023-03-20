package com.suavelomito.bootcamp.core.service;

import com.suavelomito.bootcamp.core.entity.Servicio;

import java.util.Optional;

public interface ServicioService {
    Optional<Servicio> findByName(String nombreServicio);
}
