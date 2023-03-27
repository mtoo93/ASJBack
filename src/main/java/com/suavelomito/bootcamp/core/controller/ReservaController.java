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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<ReservaDTO> agregarReserva(@RequestBody @Valid NuevaReservaDTO nuevaReservaDTO) {
        try{ ReservaDTO reservaDTO = nuevaReservaDTO.toReservaDTO();
            rServ.agregarReserva(reservaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaDTO);
    }
        catch (RuntimeException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
    @PutMapping("/{id}")
    public ResponseEntity<?> updateReserva(@PathVariable Integer id, @RequestBody @Valid NuevaReservaDTO nuevaReservaDTO) {
        System.out.println("Datos recibidos: " + nuevaReservaDTO.toString());
        try {
            ReservaDTO reservaDTO = nuevaReservaDTO.toReservaDTO();
            Reserva reservaActualizada = rServ.updateReserva(id, reservaDTO);
            Map<String, String> responseMap = new HashMap<>();
            responseMap.put("Reserva actualizada correctamente. Id: ", String.valueOf(reservaActualizada.getIdreserva()));
            return ResponseEntity.status(HttpStatus.OK).body(responseMap);
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
            Map<String, String> responseMap = new HashMap<>();
            responseMap.put("Reserva eliminada", String.valueOf(id));
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseMap);
        } catch (ResourceNotFoundException ex) {
            ErrorResponse error = new ErrorResponse("Recurso no encontrado", ex.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            ErrorResponse error = new ErrorResponse("Error interno del servidor", ex.getMessage());
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
