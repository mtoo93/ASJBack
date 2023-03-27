package com.suavelomito.bootcamp.core.service;

import com.suavelomito.bootcamp.core.entity.Servicio;

import java.util.List;
import java.util.Optional;

public interface ServicioService {
    Optional<Servicio> findByName(String nombreServicio);

    List<Servicio> buscarPorNombreEspecifico(String palabra);

    List<Servicio> find();

    Servicio getServicio(Integer id);
}
