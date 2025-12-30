package com.empleados.backend.dto;

public class NominaDTO {

    private String empleado;
    private String puesto;
    private Double totalPercepciones;
    private Double totalDeducciones;
    private Double totalPagar;

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Double getTotalPercepciones() {
        return totalPercepciones;
    }

    public void setTotalPercepciones(Double totalPercepciones) {
        this.totalPercepciones = totalPercepciones;
    }

    public Double getTotalDeducciones() {
        return totalDeducciones;
    }

    public void setTotalDeducciones(Double totalDeducciones) {
        this.totalDeducciones = totalDeducciones;
    }

    public Double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(Double totalPagar) {
        this.totalPagar = totalPagar;
    }
}
