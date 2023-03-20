package com.suavelomito.bootcamp.core.service;

import com.suavelomito.bootcamp.core.entity.Admin;

import java.util.Optional;


public interface AdminService {
    Optional<Admin> find(Integer id);

    Optional<Admin> findByUsername(String username);

    Admin add(Admin value);

    Admin find(Admin value);

    String delete(Integer id);
    boolean userValid(Admin admin);
}
