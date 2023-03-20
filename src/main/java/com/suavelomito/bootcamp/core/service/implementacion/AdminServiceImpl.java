package com.suavelomito.bootcamp.core.service.implementacion;

import com.suavelomito.bootcamp.core.entity.Admin;
import com.suavelomito.bootcamp.core.repository.AdminRepository;
import com.suavelomito.bootcamp.core.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository aRepo;

    public AdminServiceImpl(AdminRepository aRepo){
        this.aRepo = aRepo;
    }
    public List<Admin> find(){
        return aRepo.findAll();
    }

    @Override
    public Optional<Admin> find(Integer id) {
        return aRepo.findById(id);
    }

    @Override
    public Optional<Admin> findByUsername(String username) {
        return aRepo.findByUsername(username);
    }

    @Override
    public boolean userValid(Admin admin){
        aRepo.findByUsernameAndPass(admin.getUsername(), admin.getPass());
        Optional<Admin> userPassValid = this.aRepo.findByUsernameAndPass(admin.getUsername(), admin.getPass());
        return userPassValid.isPresent();
    }

    @Override
    public Admin add(Admin admin) {
        return aRepo.save(admin);
    }

    @Override
    public Admin find(Admin admin) {
        return aRepo.save(admin);
    }

    @Override
    public String delete(Integer id) {
        aRepo.deleteById(id);
        return "Usuario Eliminado";
    }



}
