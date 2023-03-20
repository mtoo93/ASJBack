package com.suavelomito.bootcamp.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idcliente")
    private int idcliente;

    @Column(name="nombre_cliente", nullable = false)
    private String nombreCliente;

    @Column(name="owner_cliente",nullable = false)
    private String ownerCliente;

    @Column(name="telefono",nullable = false)
    private int telefono;
    @Column(name="raza", nullable = false)
    private String raza;

    @Column(name="size", nullable = false)
    private String size;

    @Column (name="observaciones")
    private String observaciones;

}
