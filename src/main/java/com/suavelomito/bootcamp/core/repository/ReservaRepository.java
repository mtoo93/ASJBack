package com.suavelomito.bootcamp.core.repository;
import com.suavelomito.bootcamp.core.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva,Integer> {

}
