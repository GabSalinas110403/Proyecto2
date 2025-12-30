package com.empleados.backend.controller;

import com.empleados.backend.entity.Empleado;
import com.empleados.backend.service.EmpleadoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
@CrossOrigin(origins = "*")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public List<Empleado> listar() {
        return empleadoService.listarActivos();
    }

    @PostMapping
    public Empleado crear(@RequestBody Empleado empleado) {
        return empleadoService.guardar(empleado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        empleadoService.eliminar(id);
    }
}
