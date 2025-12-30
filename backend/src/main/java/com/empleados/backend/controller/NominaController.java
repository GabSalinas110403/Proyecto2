package com.empleados.backend.controller;

import com.empleados.backend.dto.NominaDTO;
import com.empleados.backend.service.NominaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nomina")
@CrossOrigin(origins = "*")
public class NominaController {

    private final NominaService nominaService;

    public NominaController(NominaService nominaService) {
        this.nominaService = nominaService;
    }

    @GetMapping("/{empleadoId}")
    public NominaDTO calcular(@PathVariable Long empleadoId) {
        return nominaService.calcularNomina(empleadoId);
    }
}
