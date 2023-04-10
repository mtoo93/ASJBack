package com.suavelomito.bootcamp.core.service;

import com.suavelomito.bootcamp.core.entity.Admin;
import com.suavelomito.bootcamp.core.negocios.dto.AdminDTO;
import com.suavelomito.bootcamp.core.negocios.validate.AuthenticationErrorException;

import java.util.Optional;


public interface AdminService {
    Optional<Admin> findByUsername(String username);



    Optional<Admin> userValid(AdminDTO adminDTO) throws AuthenticationErrorException;
}
