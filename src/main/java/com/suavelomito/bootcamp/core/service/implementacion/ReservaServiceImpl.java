package com.suavelomito.bootcamp.core.service.implementacion;
import com.suavelomito.bootcamp.core.entity.Cliente;
import com.suavelomito.bootcamp.core.entity.Reserva;
import com.suavelomito.bootcamp.core.entity.Servicio;
import com.suavelomito.bootcamp.core.negocios.dto.ReservaDTO;
import com.suavelomito.bootcamp.core.negocios.validate.ArgumentNotValidException;
import com.suavelomito.bootcamp.core.negocios.validate.ResourceNotFoundException;
import com.suavelomito.bootcamp.core.repository.ReservaRepository;
import com.suavelomito.bootcamp.core.repository.ServicioRepository;
import com.suavelomito.bootcamp.core.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class ReservaServiceImpl implements ReservaService {
    @Autowired
    private ReservaRepository rRepo;

    @Autowired
    private ClienteServiceImpl cServ;

    @Autowired
    private ServicioRepository sRepo;

    public List<Reserva> find(){
        return rRepo.findAll();
    }

    public Reserva getReserva(Integer id){
        Optional<Reserva> optionalReserva = rRepo.findById(id);
        if (optionalReserva.isPresent()) {
            return optionalReserva.get();
        }
        else {
            throw new RuntimeException("Reserva inexistente");
        }

    }
    @Override
    public Optional<Reserva> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public Reserva agregarReserva(ReservaDTO reservaDTO) throws ArgumentNotValidException {

        Cliente cliente = cServ.addCliente(reservaDTO.clienteDTO);
        Servicio servicio = sRepo.findBynombreServicio(reservaDTO.servicioDTO.nombreServicio)
                .orElseThrow(() -> new NoSuchElementException("Servicio no encontrado"));

        Reserva reserva = new Reserva();
        reserva.setFecha(reservaDTO.fecha);
        reserva.setHora(reservaDTO.hora);
        reserva.setCliente(cliente);
        reserva.setServicio(servicio);


        return rRepo.save(reserva);


    }

    @Override
    public Reserva find(Reserva reserva) {
        return rRepo.save(reserva);
    }

    @Override
    public String deleteReserva(Integer id) throws ResourceNotFoundException {
        Optional<Reserva> reservaOptional = rRepo.findById(id);
        if (reservaOptional.isPresent()) {
            rRepo.deleteById(id);
            return "Reserva Eliminada";
        } else {
            throw new ResourceNotFoundException("Reserva no encontrada con ID " + id);
        }
    }
    @Override
    public Reserva updateReserva(Integer id, ReservaDTO reservaDTO) throws ResourceNotFoundException {
        Reserva reserva = rRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrada con ID " + id));
        reserva.setFecha(reservaDTO.fecha);
        reserva.setHora(reservaDTO.hora);
        Cliente cliente = cServ.addCliente(reservaDTO.clienteDTO);
        reserva.setCliente(cliente);
        Servicio servicio = sRepo.findBynombreServicio(reservaDTO.servicioDTO.nombreServicio)
                .orElseThrow(() -> new NoSuchElementException("Servicio no encontrado"));
        reserva.setServicio(servicio);
        return rRepo.save(reserva);
    }

}
