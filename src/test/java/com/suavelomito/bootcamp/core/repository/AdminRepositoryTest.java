package com.suavelomito.bootcamp.core.repository;

import com.suavelomito.bootcamp.core.datos.DatosDummy;
import com.suavelomito.bootcamp.core.entity.Admin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AdminRepositoryTest {



    @Autowired
    private AdminRepository aRepo;

    @BeforeEach
    void setUp() {
        aRepo.save(DatosDummy.getAdmin());
    }

    @AfterEach
    void tearDown() {
        aRepo.deleteAll();
    }

    @Test
    void findByUsername() {
        Optional<Admin> optionalAdmin = this.aRepo.findByUsername("Lala");

        assertThat(optionalAdmin.isPresent()).isTrue();
        assertThat(optionalAdmin.get().getUsername()).isEqualTo("Lala");

        }

    @Test
    void findByUsernameAndPass() {
        Optional<Admin> optionalAdmin = this.aRepo.findByUsernameAndPass("Lala", "lol");

        assertThat(optionalAdmin.isPresent()).isTrue();
        assertThat(optionalAdmin.get().getUsername()).isEqualTo("Lala");
        assertThat(optionalAdmin.get().getPass()).isEqualTo("lol");
    }
}