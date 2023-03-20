package com.suavelomito.bootcamp.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="servicio")

public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idservicio")
    private int idservicio;

    @Column(name="nombre_servicio", nullable = false)
    private String nombreServicio;

    @Column(name="precio", nullable = false)
    private int precio;


}
