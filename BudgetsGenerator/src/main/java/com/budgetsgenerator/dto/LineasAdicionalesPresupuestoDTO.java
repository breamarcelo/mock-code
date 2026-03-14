package com.budgetsgenerator.dto;

public class LineasAdicionalesPresupuestoDTO {
    private int id;
    private int cantidad;
    private int lineasAdicional;
    private int presupuesto;
    public LineasAdicionalesPresupuestoDTO() {
    }
    public LineasAdicionalesPresupuestoDTO(int id, int cantidad, int lineasAdicional, int presupuesto) {
        this.id = id;
        this.cantidad = cantidad;
        this.lineasAdicional = lineasAdicional;
        this.presupuesto = presupuesto;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public int getLineasAdicional() {
        return lineasAdicional;
    }
    public void setLineasAdicional(int lineasAdicional) {
        this.lineasAdicional = lineasAdicional;
    }
    public int getPresupuesto() {
        return presupuesto;
    }
    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }
}
