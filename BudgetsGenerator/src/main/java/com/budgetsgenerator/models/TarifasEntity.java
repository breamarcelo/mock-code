package com.budgetsgenerator.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="TTarifas")
public class TarifasEntity {
    @Id
    @Column(name="PK_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="Nombre")
    private String nombre;

    @Column(name="Tipo")
    private String tipo;

    @Column(name="Lineas_moviles")
    private int lineasMoviles;

    @Column(name="Llamadas_movil")
    private String llamadasMovil;

    @Column(name="Gb_movil")
    private String gbMovil;

    @Column(name="Opcion_fibra1")
    private String opcionFibra1;

    @Column(name="Opcion_fibra2")
    private String opcionFibra2;

    @Column(name="Sobrecargo_fibra")
    private double sobrecargoFibra;

    @Column(name="Precio")
    private double precio;

    @OneToOne
    @JoinColumn(name="FK_Servicios_ID")
    private ServiciosAdicionalesEntity serviciosAdicionales;

    @Column(name="Tv")
    private boolean tv;

    @Column(name="Servicio_streaming")
    private boolean streaming;

    public TarifasEntity() {
    }

    public TarifasEntity(int id, String nombre, String tipo, int lineasMoviles, String llamadasMovil, String gbMovil,
            String opcionFibra1, String opcionFibra2, double sobrecargoFibra, double precio,
            ServiciosAdicionalesEntity serviciosAdicionales, boolean tv, boolean streaming) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.lineasMoviles = lineasMoviles;
        this.llamadasMovil = llamadasMovil;
        this.gbMovil = gbMovil;
        this.opcionFibra1 = opcionFibra1;
        this.opcionFibra2 = opcionFibra2;
        this.sobrecargoFibra = sobrecargoFibra;
        this.precio = precio;
        this.serviciosAdicionales = serviciosAdicionales;
        this.tv = tv;
        this.streaming = streaming;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getLineasMoviles() {
        return lineasMoviles;
    }

    public void setLineasMoviles(int lineasMoviles) {
        this.lineasMoviles = lineasMoviles;
    }

    public String getLlamadasMovil() {
        return llamadasMovil;
    }

    public void setLlamadasMovil(String llamadasMovil) {
        this.llamadasMovil = llamadasMovil;
    }

    public String getGbMovil() {
        return gbMovil;
    }

    public void setGbMovil(String gbMovil) {
        this.gbMovil = gbMovil;
    }

    public String getOpcionFibra1() {
        return opcionFibra1;
    }

    public void setOpcionFibra1(String opcionFibra1) {
        this.opcionFibra1 = opcionFibra1;
    }

    public String getOpcionFibra2() {
        return opcionFibra2;
    }

    public void setOpcionFibra2(String opcionFibra2) {
        this.opcionFibra2 = opcionFibra2;
    }

    public double getSobrecargoFibra() {
        return sobrecargoFibra;
    }

    public void setSobrecargoFibra(double sobrecargoFibra) {
        this.sobrecargoFibra = sobrecargoFibra;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ServiciosAdicionalesEntity getServiciosAdicionales() {
        return serviciosAdicionales;
    }

    public void setServiciosAdicionales(ServiciosAdicionalesEntity serviciosAdicionales) {
        this.serviciosAdicionales = serviciosAdicionales;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean isStreaming() {
        return streaming;
    }

    public void setStreaming(boolean streaming) {
        this.streaming = streaming;
    }

}
