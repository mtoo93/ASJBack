package com.suavelomito.bootcamp.core.service.implementacion;

import com.suavelomito.bootcamp.core.entity.Admin;
import com.suavelomito.bootcamp.core.negocios.dto.AdminDTO;
import com.suavelomito.bootcamp.core.negocios.validate.AuthenticationErrorException;
import com.suavelomito.bootcamp.core.repository.AdminRepository;
import com.suavelomito.bootcamp.core.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository aRepo;

    public AdminServiceImpl(AdminRepository aRepo) {
        this.aRepo = aRepo;
    }


    @Override
    public Optional<Admin> findByUsername(String username) {
        return aRepo.findByUsername(username);
    }

    @Override
    public Optional<Admin> userValid(AdminDTO adminDTO) throws AuthenticationErrorException {
        Optional<Admin> userPassValid = aRepo.findByUsernameAndPass(adminDTO.username, adminDTO.pass);
        if (!userPassValid.isPresent()) {
            throw new AuthenticationErrorException("Datos mal ingresados");
        }
        return userPassValid;
    }

}

