package com.suavelomito.bootcamp.core.controller;

import com.suavelomito.bootcamp.core.entity.Reserva;
import com.suavelomito.bootcamp.core.negocios.dto.NuevaReservaDTO;
import com.suavelomito.bootcamp.core.negocios.dto.ReservaDTO;
import com.suavelomito.bootcamp.core.negocios.validate.ArgumentNotValidException;
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

    @PostMapping
    public ResponseEntity<ReservaDTO> agregarReserva(@RequestBody @Valid NuevaReservaDTO nuevaReservaDTO) throws ArgumentNotValidException {
        ReservaDTO reservaDTO = nuevaReservaDTO.toReservaDTO();
            rServ.agregarReserva(reservaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaDTO);

}
    @PutMapping("/{id}")
    public ResponseEntity<?> updateReserva(@PathVariable Integer id, @RequestBody @Valid NuevaReservaDTO nuevaReservaDTO) throws ResourceNotFoundException {
        System.out.println("Datos recibidos: " + nuevaReservaDTO.toString());
            ReservaDTO reservaDTO = nuevaReservaDTO.toReservaDTO();
            Reserva reservaActualizada = rServ.updateReserva(id, reservaDTO);
            Map<String, String> responseMap = new HashMap<>();
            responseMap.put("Reserva actualizada correctamente. Id: ", String.valueOf(reservaActualizada.getIdreserva()));
            return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarReserva(@PathVariable Integer id) throws ResourceNotFoundException {
            rServ.deleteReserva(id);
            Map<String, String> responseMap = new HashMap<>();
            responseMap.put("Reserva eliminada", String.valueOf(id));
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseMap);
    }




}
