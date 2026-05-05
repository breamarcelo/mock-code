package com.example.models;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CatalogoLibros implements Catalogo<Libro>{
    private final String CATALOGO_XML = "./catalogo_libros.xml";
    
    @XmlElementWrapper(name="Libros")
    @XmlElement(name="Libro")
    private List<Libro> libros;

   
    public CatalogoLibros(){
    }

    @Override
    public String getCatalogoXml() {
        return CATALOGO_XML;
    }

    @Override
    public List<Libro> getList() {
        return libros;
    }

    @Override
    public void saveList(List<Libro> lista) {
        this.libros = lista;
    }
    
    
    
}
