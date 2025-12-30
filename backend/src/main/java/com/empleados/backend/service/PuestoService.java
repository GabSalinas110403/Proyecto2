package com.empleados.backend.service;

import com.empleados.backend.entity.Puesto;
import com.empleados.backend.repository.PuestoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PuestoService {

    private final PuestoRepository puestoRepository;

    public PuestoService(PuestoRepository puestoRepository) {
        this.puestoRepository = puestoRepository;
    }

    public List<Puesto> listarActivos() {
        return puestoRepository.findByEstatus("ACTIVO");
    }

    public Puesto guardar(Puesto puesto) {
        puesto.setEstatus("ACTIVO");
        return puestoRepository.save(puesto);
    }

    public Puesto obtenerPorId(Long id) {
        return puestoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Puesto no encontrado"));
    }
}
