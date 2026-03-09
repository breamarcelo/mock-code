package com.budgetsgenerator.dto;

public class DescuentosDTO {
    private int id;
    private double porciento;
    
    public DescuentosDTO() {
    }
    
    public DescuentosDTO(int id, double porciento) {
        this.id = id;
        this.porciento = porciento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPorciento() {
        return porciento;
    }

    public void setPorciento(double porciento) {
        this.porciento = porciento;
    }
}
