package com.suavelomito.bootcamp.core.controller;

import com.suavelomito.bootcamp.core.entity.Reserva;
import com.suavelomito.bootcamp.core.negocios.dto.NuevaReservaDTO;
import com.suavelomito.bootcamp.core.negocios.dto.ReservaDTO;
import com.suavelomito.bootcamp.core.negocios.validate.ErrorResponse;
import com.suavelomito.bootcamp.core.negocios.validate.ResourceNotFoundException;
import com.suavelomito.bootcamp.core.service.implementacion.ReservaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/reserva")
public class ReservaController {
    private final ReservaServiceImpl rServ;

    public ReservaController(ReservaServiceImpl rServ) {

        this.rServ = rServ;

    }
    @GetMapping("/all")
    public List<Reserva> find() {
        return rServ.find();
    }

    @GetMapping("/all/{id}")
    public Reserva getReserva(@PathVariable("id") Integer id) {

        return rServ.getReserva(id);
    }
    @PostMapping("/add")
    public ResponseEntity<String> agregarReserva(@RequestBody @Valid NuevaReservaDTO nuevaReservaDTO) {
        try{ ReservaDTO reservaDTO = nuevaReservaDTO.toReservaDTO();
            rServ.agregarReserva(reservaDTO);
        String message = "Se guardó tu reserva! Cliente: " + reservaDTO.getClienteDTO().getNombreCliente() +
                ", Fecha: " + reservaDTO.getFecha() +
                ", Hora: " + reservaDTO.getHora() +
                ", Servicio: " + reservaDTO.getServicioDTO().getNombreServicio();
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }
        catch (RuntimeException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
    @PutMapping("/{id}")
    public ResponseEntity<?> updateReserva(@PathVariable Integer id, @RequestBody @Valid NuevaReservaDTO nuevaReservaDTO) {
        try {
            ReservaDTO reservaDTO = nuevaReservaDTO.toReservaDTO();
            Reserva reservaActualizada = rServ.updateReserva(id, reservaDTO);
            String message = "Reserva actualizada correctamente. Id: " + reservaActualizada.getIdreserva();
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (ResourceNotFoundException ex) {
            ErrorResponse error = new ErrorResponse("Recurso no encontrado", ex.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            ErrorResponse error = new ErrorResponse("Error interno del servidor", ex.getMessage());
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarReserva(@PathVariable Integer id) {
        try {
            rServ.deleteReserva(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Reserva eliminada");
        } catch (ResourceNotFoundException ex) {
            ErrorResponse error = new ErrorResponse("Recurso no encontrado", ex.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            ErrorResponse error = new ErrorResponse("Error interno del servidor", ex.getMessage());
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
