package com.empleados.backend.service;

import com.empleados.backend.entity.ConceptoNomina;
import com.empleados.backend.entity.Puesto;
import com.empleados.backend.repository.ConceptoNominaRepository;
import com.empleados.backend.repository.PuestoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConceptoNominaService {

    private final ConceptoNominaRepository conceptoRepository;
    private final PuestoRepository puestoRepository;

    public ConceptoNominaService(
            ConceptoNominaRepository conceptoRepository,
            PuestoRepository puestoRepository
    ) {
        this.conceptoRepository = conceptoRepository;
        this.puestoRepository = puestoRepository;
    }

    public List<ConceptoNomina> listarActivos() {
        return conceptoRepository.findByEstatus("ACTIVO");
    }

    public ConceptoNomina guardar(ConceptoNomina concepto) {

        if (concepto.getPuesto() == null) {
            throw new RuntimeException("El concepto debe tener un puesto");
        }

        Puesto puesto = puestoRepository.findById(concepto.getPuesto().getId())
                .orElseThrow(() -> new RuntimeException("Puesto no existe"));

        if (!"ACTIVO".equals(puesto.getEstatus())) {
            throw new RuntimeException("El puesto no está activo");
        }

        concepto.setPuesto(puesto);
        concepto.setEstatus("ACTIVO");

        return conceptoRepository.save(concepto);
    }

    public void eliminar(Long id) {
        ConceptoNomina concepto = conceptoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Concepto no encontrado"));

        concepto.setEstatus("INACTIVO");
        conceptoRepository.save(concepto);
    }
}
