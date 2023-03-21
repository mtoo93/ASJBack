package com.suavelomito.bootcamp.core.controller;

import com.suavelomito.bootcamp.core.entity.Admin;
import com.suavelomito.bootcamp.core.negocios.dto.AdminDTO;
import com.suavelomito.bootcamp.core.negocios.mapper.AdminMapper;

import com.suavelomito.bootcamp.core.service.implementacion.AdminServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/admin")

public class AdminController {

    private final AdminServiceImpl aServ;
    private final AdminMapper aMap;
    public AdminController(AdminServiceImpl aServ, AdminMapper aMap){
        this.aServ = aServ;
        this.aMap = aMap;
    }

    @GetMapping("/all")
    public List<Admin> find(){
        return aServ.find();
    }


    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> login(@RequestBody AdminDTO adminDTO){
        try {
            aServ.userValid(aMap.dtoToEntity(adminDTO));
            return ResponseEntity.status(HttpStatus.OK).body(adminDTO);
        }
        catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Datos mal ingresados");
        }

    }
}

