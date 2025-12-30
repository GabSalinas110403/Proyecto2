package com.empleados.backend.repository;

import com.empleados.backend.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    List<Empleado> findByEstatus(String estatus);
}
