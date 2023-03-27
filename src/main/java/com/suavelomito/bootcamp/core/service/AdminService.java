package com.suavelomito.bootcamp.core.service;

import com.suavelomito.bootcamp.core.entity.Admin;

import java.util.Optional;


public interface AdminService {
    Optional<Admin> findByUsername(String username);


    boolean userValid(Admin admin);
}
