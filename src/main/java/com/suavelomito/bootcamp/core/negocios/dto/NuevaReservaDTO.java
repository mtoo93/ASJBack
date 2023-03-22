package com.suavelomito.bootcamp.core.negocios.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NuevaReservaDTO {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull
    private LocalDate fecha;
    @DateTimeFormat(pattern = "HH:mm:ss")
    @NotNull
    private LocalTime hora;
    @NotBlank
    private String nombreCliente;
    @NotBlank
    private String ownerCliente;
    @NotNull
    private int telefono;
    @NotBlank
    private String raza;
    @NotBlank
    private String size;
    private String observaciones;
    @NotBlank
    private String nombre_servicio;

    public ReservaDTO toReservaDTO() {
        ReservaDTO reservaDTO = new ReservaDTO();
        reservaDTO.setFecha(fecha);
        reservaDTO.setHora(hora);

        ClienteDTO clienteDTO = ClienteDTO.builder()
                .nombreCliente(nombreCliente)
                .ownerCliente(ownerCliente)
                .telefono(telefono)
                .raza(raza)
                .size(size)
                .observaciones(observaciones)
                .build();
        reservaDTO.setClienteDTO(clienteDTO);

        ServicioDTO servicioDTO = ServicioDTO.builder()
                .nombreServicio(nombre_servicio)
                .build();
        reservaDTO.setServicioDTO(servicioDTO);

        return reservaDTO;
    }
}