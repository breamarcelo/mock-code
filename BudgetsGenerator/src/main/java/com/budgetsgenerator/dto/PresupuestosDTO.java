package com.budgetsgenerator.dto;

import java.util.List;

public class PresupuestosDTO {
    private int id;
    private String nombre;
    private int tarifa;
    private int fibra;
    private int streaming;
    private int centralita;
    private int packFutbol;
    private int descuento;
    private List<LineasAdicionalesPresupuestoDTO> lineasAdicionales;
    public PresupuestosDTO() {
    }
    public PresupuestosDTO(int id, String nombre, int tarifa, int fibra, int streaming, int centralita, int packFutbol,
            int descuento, List<LineasAdicionalesPresupuestoDTO> lineasAdicionales) {
        this.id = id;
        this.nombre = nombre;
        this.tarifa = tarifa;
        this.fibra = fibra;
        this.streaming = streaming;
        this.centralita = centralita;
        this.packFutbol = packFutbol;
        this.descuento = descuento;
        this.lineasAdicionales = lineasAdicionales;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getTarifa() {
        return tarifa;
    }
    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }
    public int getFibra() {
        return fibra;
    }
    public void setFibra(int fibra) {
        this.fibra = fibra;
    }
    public int getStreaming() {
        return streaming;
    }
    public void setStreaming(int streaming) {
        this.streaming = streaming;
    }
    public int getCentralita() {
        return centralita;
    }
    public void setCentralita(int centralita) {
        this.centralita = centralita;
    }
    public int getPackFutbol() {
        return packFutbol;
    }
    public void setPackFutbol(int packFutbol) {
        this.packFutbol = packFutbol;
    }
    public int getDescuento() {
        return descuento;
    }
    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
    public List<LineasAdicionalesPresupuestoDTO> getLineasAdicionales() {
        return lineasAdicionales;
    }
    public void setLineasAdicionales(List<LineasAdicionalesPresupuestoDTO> lineasAdicionales) {
        this.lineasAdicionales = lineasAdicionales;
    }
}
