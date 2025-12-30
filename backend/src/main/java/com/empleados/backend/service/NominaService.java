package com.empleados.backend.service;

import com.empleados.backend.dto.NominaDTO;
import com.empleados.backend.entity.ConceptoNomina;
import com.empleados.backend.entity.Empleado;
import com.empleados.backend.repository.ConceptoNominaRepository;
import com.empleados.backend.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NominaService {

    private final EmpleadoRepository empleadoRepository;
    private final ConceptoNominaRepository conceptoRepository;

    public NominaService(
            EmpleadoRepository empleadoRepository,
            ConceptoNominaRepository conceptoRepository
    ) {
        this.empleadoRepository = empleadoRepository;
        this.conceptoRepository = conceptoRepository;
    }

    public NominaDTO calcularNomina(Long empleadoId) {

        Empleado empleado = empleadoRepository.findById(empleadoId)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        if (!"ACTIVO".equals(empleado.getEstatus())) {
            throw new RuntimeException("Empleado inactivo");
        }

        List<ConceptoNomina> conceptos =
                conceptoRepository.findByPuestoIdAndEstatus(
                        empleado.getPuesto().getId(), "ACTIVO"
                );

        double percepciones = 0;
        double deducciones = 0;

        for (ConceptoNomina c : conceptos) {
            if ("PERCEPCION".equals(c.getTipo())) {
                percepciones += c.getMonto();
            } else if ("DEDUCCION".equals(c.getTipo())) {
                deducciones += c.getMonto();
            }
        }

        NominaDTO dto = new NominaDTO();
        dto.setEmpleado(empleado.getNombre());
        dto.setPuesto(empleado.getPuesto().getNombre());
        dto.setTotalPercepciones(percepciones);
        dto.setTotalDeducciones(deducciones);
        dto.setTotalPagar(percepciones - deducciones);

        return dto;
    }
}
