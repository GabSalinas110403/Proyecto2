package com.empleados.backend.service;

import com.empleados.backend.entity.Empleado;
import com.empleados.backend.entity.Puesto;
import com.empleados.backend.repository.EmpleadoRepository;
import com.empleados.backend.repository.PuestoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;
    private final PuestoRepository puestoRepository;

    public EmpleadoService(
            EmpleadoRepository empleadoRepository,
            PuestoRepository puestoRepository
    ) {
        this.empleadoRepository = empleadoRepository;
        this.puestoRepository = puestoRepository;
    }

    public List<Empleado> listarActivos() {
        return empleadoRepository.findByEstatus("ACTIVO");
    }

    public Empleado guardar(Empleado empleado) {

        // VALIDACIÓN EXAMEN
        if (empleado.getPuesto() == null) {
            throw new RuntimeException("El empleado debe tener un puesto");
        }

        Puesto puesto = puestoRepository.findById(empleado.getPuesto().getId())
                .orElseThrow(() -> new RuntimeException("Puesto no existe"));

        if (!"ACTIVO".equals(puesto.getEstatus())) {
            throw new RuntimeException("El puesto no está activo");
        }

        empleado.setPuesto(puesto);
        empleado.setEstatus("ACTIVO");

        return empleadoRepository.save(empleado);
    }

    public void eliminar(Long id) {
        Empleado emp = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        emp.setEstatus("INACTIVO");
        empleadoRepository.save(emp);
    }
}
