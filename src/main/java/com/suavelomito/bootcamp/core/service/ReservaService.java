package com.suavelomito.bootcamp.core.service;

import com.suavelomito.bootcamp.core.entity.Reserva;
import com.suavelomito.bootcamp.core.negocios.dto.ReservaDTO;

import java.util.Optional;

public interface ReservaService {
    Optional<Reserva> find(Integer id);


    Reserva agregarReserva(ReservaDTO reservaDTO);



    Reserva find(Reserva reserva);

    String deleteReserva(Integer id);

    Reserva updateReserva (Integer id, ReservaDTO reservaDTO);

}
