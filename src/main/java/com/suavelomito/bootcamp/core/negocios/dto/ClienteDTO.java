package com.suavelomito.bootcamp.core.negocios.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ClienteDTO {
    @NotBlank
    public String nombreCliente;
    @NotBlank
    public String ownerCliente;
    @NotNull
    public int telefono;
    @NotBlank
    public String raza;
    @NotBlank
    public String size;
    public String observaciones;
}
