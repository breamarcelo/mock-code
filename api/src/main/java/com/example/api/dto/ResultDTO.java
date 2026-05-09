package com.example.api.dto;

import java.util.List;

public class ResultDTO {
    private PresupuestosDTO presupuesto;
    private List<LineasPresupuestoDTO> lineas;
    private double total;
    public ResultDTO() {
    }
    public ResultDTO(PresupuestosDTO presupuesto, List<LineasPresupuestoDTO> lineas) {
        this.presupuesto = presupuesto;
        this.lineas = lineas;
    }
    public PresupuestosDTO getPresupuesto() {
        return presupuesto;
    }
    public void setPresupuesto(PresupuestosDTO presupuesto) {
        this.presupuesto = presupuesto;
    }
    public List<LineasPresupuestoDTO> getLineas() {
        return lineas;
    }
    public void setLineas(List<LineasPresupuestoDTO> lineas) {
        this.lineas = lineas;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    
}
