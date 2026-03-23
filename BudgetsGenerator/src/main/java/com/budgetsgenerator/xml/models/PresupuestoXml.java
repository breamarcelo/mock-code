package com.budgetsgenerator.xml.models;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Presupuesto")
public class PresupuestoXml {
   private String tarifa;
   private String fibra;
   private String streaming;
   private String centralita;
   private String packFutbol;
   private String descuento;
   private List<LineasPresupuestoXml> lineasPresupuesto;
   private String total;

   public PresupuestoXml(String tarifa, String fibra, String streaming, String centralita, String packFutbol,
        String descuento, List<LineasPresupuestoXml> lineasPresupuesto, String total) {
    this.tarifa = tarifa;
    this.fibra = fibra;
    this.streaming = streaming;
    this.centralita = centralita;
    this.packFutbol = packFutbol;
    this.descuento = descuento;
    this.lineasPresupuesto = lineasPresupuesto;
    this.total = total;
   }

   @XmlElement(name="Tarifa")
   public String getTarifa() {
    return tarifa;
   }

   public void setTarifa(String tarifa) {
    this.tarifa = tarifa;
   }

   @XmlElement(name="Fibra")
   public String getFibra() {
    return fibra;
   }

   public void setFibra(String fibra) {
    this.fibra = fibra;
   }

   @XmlElement(name="Streaming")
   public String getStreaming() {
    return streaming;
   }

   public void setStreaming(String streaming) {
    this.streaming = streaming;
   }

   @XmlElement(name="Centralita")
   public String getCentralita() {
    return centralita;
   }

   public void setCentralita(String centralita) {
    this.centralita = centralita;
   }

   @XmlElement(name="PackFutbol")
   public String getPackFutbol() {
    return packFutbol;
   }

   public void setPackFutbol(String packFutbol) {
    this.packFutbol = packFutbol;
   }

   @XmlElement(name="Descuento")
   public String getDescuento() {
    return descuento;
   }

   public void setDescuento(String descuento) {
    this.descuento = descuento;
   }

   @XmlElementWrapper(name="LineasAdicionales")
   @XmlElement(name="Linea")
   public List<LineasPresupuestoXml> getLineasPresupuesto() {
    return lineasPresupuesto;
   }

   public void setLineasPresupuesto(List<LineasPresupuestoXml> lineasPresupuesto) {
    this.lineasPresupuesto = lineasPresupuesto;
   }

   @XmlElement(name="Total")
   public String getTotal() {
    return total;
    }

   public void setTotal(String total) {
    this.total = total;
   }
}
