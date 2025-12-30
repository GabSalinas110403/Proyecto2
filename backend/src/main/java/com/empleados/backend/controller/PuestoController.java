package com.empleados.backend.controller;

import com.empleados.backend.entity.Puesto;
import com.empleados.backend.service.PuestoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/puestos")
@CrossOrigin(origins = "*")
public class PuestoController {

    private final PuestoService puestoService;

    public PuestoController(PuestoService puestoService) {
        this.puestoService = puestoService;
    }

    @GetMapping
    public List<Puesto> listar() {
        return puestoService.listarActivos();
    }

    @PostMapping
    public Puesto crear(@RequestBody Puesto puesto) {
        return puestoService.guardar(puesto);
    }

    @GetMapping("/{id}")
    public Puesto obtener(@PathVariable Long id) {
        return puestoService.obtenerPorId(id);
    }
}
