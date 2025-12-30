package com.empleados.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "puestos")
public class Puesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double sueldoQuincenal;
    private String estatus; 

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getSueldoQuincenal() {
        return sueldoQuincenal;
    }

    public void setSueldoQuincenal(Double sueldoQuincenal) {
        this.sueldoQuincenal = sueldoQuincenal;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
