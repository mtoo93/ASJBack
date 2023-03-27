package com.suavelomito.bootcamp.core.service.implementacion;

import com.suavelomito.bootcamp.core.datos.DatosDummy;
import com.suavelomito.bootcamp.core.entity.Admin;
import com.suavelomito.bootcamp.core.repository.AdminRepository;
import com.suavelomito.bootcamp.core.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@SpringBootTest
class AdminServiceImplTest {
    @MockBean
    private AdminRepository aRepo;
    @Autowired
   private AdminService aServ;

    @Test
    void findByUsername() {
        String username = "Lala";
        when(aRepo.findByUsername(username)).thenReturn(Optional.of(DatosDummy.getAdmin()));
        Optional<Admin> admin = aServ.findByUsername(username);
        assertThat(admin.get().getUsername()).isEqualTo("Lala");
    }

    @Test
    void userValid() {
        String username = "Lala";
        String pass = "lol";
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPass(pass);
        given(aRepo.findByUsernameAndPass(username,pass)).willReturn(Optional.of(DatosDummy.getAdmin()));
        Boolean userValid = aServ.userValid(admin);
        assertThat(userValid).isTrue();
    }
}