package com.budgetsgenerator.viewmodels;


import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ResumentTableItem {
    private SimpleIntegerProperty cantidad = new SimpleIntegerProperty(0);
    private SimpleStringProperty descripcion = new SimpleStringProperty("");
    private SimpleDoubleProperty importe = new SimpleDoubleProperty(0.0);

    public SimpleIntegerProperty cantidadProperty() { return cantidad; }
    public void setCantidadProperty(int value) { this.cantidad.set(value); }
    public int getDescripcionProperty() { return cantidad.get(); }
    
    public SimpleStringProperty descripcionProperty() { return descripcion; }
    public void setDescripcion(String value) { this.descripcion.set(value); }
    public String getDescripcion() { return descripcion.get(); }

    public SimpleDoubleProperty importeProperty(){ return importe; }
    public void setImporteProperty(double value){ this.importe.set(value); }
    public Double getImporteProperty() { return importe.get(); }
}
