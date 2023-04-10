package com.suavelomito.bootcamp.core.datos;

import com.suavelomito.bootcamp.core.entity.Admin;
import com.suavelomito.bootcamp.core.entity.Cliente;
import com.suavelomito.bootcamp.core.entity.Reserva;
import com.suavelomito.bootcamp.core.entity.Servicio;

import java.time.LocalDate;
import java.time.LocalTime;

public class DatosDummy {
    public static Admin getAdmin(){
        return new Admin(1,"Lala", "lol", "lala@mail.com");
    }

    public static Reserva getReserva(){
        Cliente cliente = new Cliente(1, "lala", "lolo", 555, "picho", "mini", "lala");
        Servicio servicio = new Servicio(1, "corte", 2000);
        return new Reserva(1, LocalDate.of(2023,12,10), LocalTime.of(10,30), cliente, servicio);
    }

    public static Servicio getServicio(){
        return new Servicio (1, "corte", 2000);
    }

    public static Cliente getCliente(){
        return new Cliente(1, "lala", "lolo", 555, "picho", "mini", "lala");
    }
}
