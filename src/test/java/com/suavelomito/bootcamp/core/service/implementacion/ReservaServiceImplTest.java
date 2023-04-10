package com.suavelomito.bootcamp.core.service.implementacion;

import com.suavelomito.bootcamp.core.datos.DatosDummy;
import com.suavelomito.bootcamp.core.entity.Cliente;
import com.suavelomito.bootcamp.core.entity.Reserva;
import com.suavelomito.bootcamp.core.entity.Servicio;
import com.suavelomito.bootcamp.core.negocios.dto.ClienteDTO;
import com.suavelomito.bootcamp.core.negocios.dto.ReservaDTO;
import com.suavelomito.bootcamp.core.negocios.dto.ServicioDTO;
import com.suavelomito.bootcamp.core.repository.ClienteRepository;
import com.suavelomito.bootcamp.core.repository.ReservaRepository;
import com.suavelomito.bootcamp.core.repository.ServicioRepository;
import com.suavelomito.bootcamp.core.service.ClienteService;
import com.suavelomito.bootcamp.core.service.ReservaService;
import com.suavelomito.bootcamp.core.service.ServicioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static com.suavelomito.bootcamp.core.datos.DatosDummy.getReserva;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@DataJpaTest
class ReservaServiceImplTest {
    @MockBean
    private ReservaRepository rRepo;
    @MockBean
    private ClienteRepository cRepo;

    @MockBean

    private ServicioRepository sRepo;

    @Autowired
    private ReservaService rServ;

    @Autowired
    private ServicioService sServ;

    @Autowired
    private ClienteService cServ;


    @Test
    void find() {
    }

    @Test
    void agregarReserva() {

        }




    @Test
    void testFind() {
    }

    @Test
    void deleteReserva() {
    }

    @Test
    void updateReserva() {
    }
}