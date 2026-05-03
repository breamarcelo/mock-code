package com.example.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder={"titulo", "consola", "editorial", "genero", "anioPublicacion", "imgURL"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Videojuego {
    @XmlElement(name="Titulo")
    private String titulo;
    @XmlElement(name="Consola")
    private String consola;
    @XmlElement(name="Editorial")
    private String editorial;
    @XmlElement(name="Genero")
    private String genero;
    @XmlElement(name="AnioPublicacion")
    private int anioPublicacion;
    @XmlElement(name="ImgURL")
    private String imgURL;

    public Videojuego() {}

    public Videojuego(String titulo, String consola, String editorial, String genero, int anioPublicacion,
            String imgURL) {
        this.titulo = titulo;
        this.consola = consola;
        this.editorial = editorial;
        this.genero = genero;
        this.anioPublicacion = anioPublicacion;
        this.imgURL = imgURL;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConsola() {
        return consola;
    }

    public void setConsola(String consola) {
        this.consola = consola;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    
}
