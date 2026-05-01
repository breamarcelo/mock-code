package com.example.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder={"titulo", "autor", "isbn", "anioPublicacion", "imgURL"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Libro {
    @XmlElement(name="Titulo")
    private String titulo;
    @XmlElement(name="Autor")
    private String autor;
    @XmlElement(name="ISBN")
    private String isbn;
    @XmlElement(name="AnioPublicacion")
    private int anioPublicacion;
    @XmlElement(name="ImgURL")
    private String imgURL;

    public Libro() {
    }

    public Libro(String titulo, String autor, String isbn, int anioPublicacion, String imgUrl) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.imgURL = imgUrl;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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
