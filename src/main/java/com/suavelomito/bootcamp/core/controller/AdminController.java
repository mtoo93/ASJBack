package com.suavelomito.bootcamp.core.controller;

import com.suavelomito.bootcamp.core.entity.Admin;
import com.suavelomito.bootcamp.core.negocios.dto.AdminDTO;
import com.suavelomito.bootcamp.core.negocios.mapper.AdminMapper;

import com.suavelomito.bootcamp.core.negocios.validate.AuthenticationErrorException;
import com.suavelomito.bootcamp.core.service.implementacion.AdminServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/admin")

public class AdminController {

    private final AdminServiceImpl aServ;
    private final AdminMapper aMap;

    public AdminController(AdminServiceImpl aServ, AdminMapper aMap) {
        this.aServ = aServ;
        this.aMap = aMap;
    }



    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> login(@RequestBody AdminDTO adminDTO) throws AuthenticationErrorException {
        Optional<Admin> admin = aServ.userValid(adminDTO);
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("username", adminDTO.username);
        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }
}

