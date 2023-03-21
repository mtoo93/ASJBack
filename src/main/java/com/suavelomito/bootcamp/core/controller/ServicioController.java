package com.suavelomito.bootcamp.core.controller;
import com.suavelomito.bootcamp.core.entity.Servicio;
import com.suavelomito.bootcamp.core.service.implementacion.ServicioServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/servicio")
public class ServicioController {
    private final ServicioServiceImpl sServ;
    public ServicioController(ServicioServiceImpl sServ) {

        this.sServ = sServ;

    }
    @GetMapping("/all")
    public List<Servicio> find() {
        return sServ.find();
    }

    @GetMapping("/all/{id}")
    public Servicio getServicio(@PathVariable("id") Integer id) {

        return sServ.getServicio(id);
    }
}
