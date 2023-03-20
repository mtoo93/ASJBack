package com.suavelomito.bootcamp.core.repository;

import com.suavelomito.bootcamp.core.entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio,Integer> {
    Optional<Servicio> findBynombreServicio(String nombreServicio);

}
