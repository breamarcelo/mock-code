package com.budgetsgenerator.viewmodels;

public class ResumentTableItem {
    private String cantidad;
    private String descripcion;
    private String precio;
    public ResumentTableItem() {
    }
    public ResumentTableItem(String cantidad, String descripcion, String precio) {
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.precio = precio;
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
    public String getPrecio() {
        return precio;
    }
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    
}
