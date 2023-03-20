package com.suavelomito.bootcamp.core.negocios.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReservaDTO {
    public LocalDate fecha;
    public LocalTime hora;
    public ClienteDTO clienteDTO;
    public ServicioDTO servicioDTO;
}
