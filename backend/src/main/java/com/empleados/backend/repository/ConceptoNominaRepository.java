package com.empleados.backend.repository;

import com.empleados.backend.entity.ConceptoNomina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConceptoNominaRepository extends JpaRepository<ConceptoNomina, Long> {

    List<ConceptoNomina> findByEstatus(String estatus);

    List<ConceptoNomina> findByPuestoIdAndEstatus(Long puestoId, String estatus);
}
