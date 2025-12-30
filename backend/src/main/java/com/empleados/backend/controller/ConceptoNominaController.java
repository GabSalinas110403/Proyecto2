package com.empleados.backend.controller;

import com.empleados.backend.entity.ConceptoNomina;
import com.empleados.backend.service.ConceptoNominaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conceptos")
@CrossOrigin(origins = "*")
public class ConceptoNominaController {

    private final ConceptoNominaService conceptoService;

    public ConceptoNominaController(ConceptoNominaService conceptoService) {
        this.conceptoService = conceptoService;
    }

    @GetMapping
    public List<ConceptoNomina> listar() {
        return conceptoService.listarActivos();
    }

    @PostMapping
    public ConceptoNomina crear(@RequestBody ConceptoNomina concepto) {
        return conceptoService.guardar(concepto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        conceptoService.eliminar(id);
    }
}
