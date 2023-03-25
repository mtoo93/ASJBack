package com.suavelomito.bootcamp.core.repository;

import com.suavelomito.bootcamp.core.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {
    Optional<Admin> findByUsername(String username);
    Optional<Admin> findByUsernameAndPass(String username, String pass);

}
