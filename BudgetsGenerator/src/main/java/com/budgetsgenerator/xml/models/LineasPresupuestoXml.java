package com.budgetsgenerator.xml.models;

public class LineasPresupuestoXml {
    private String cantidad;
    private String descripcion;
    private String importe;
    
    public LineasPresupuestoXml() {
    }
    public String getCantidad() {
        return cantidad;
    }
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getImporte() {
        return importe;
    }
    public void setImporte(String importe) {
        this.importe = importe;
    }

    
}
