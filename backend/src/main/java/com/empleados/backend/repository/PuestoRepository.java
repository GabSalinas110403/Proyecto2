package com.empleados.backend.repository;

import com.empleados.backend.entity.Puesto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PuestoRepository extends JpaRepository<Puesto, Long> {

    List<Puesto> findByEstatus(String estatus);
}
