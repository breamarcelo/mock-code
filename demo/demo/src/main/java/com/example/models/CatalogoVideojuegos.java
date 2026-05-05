package com.example.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CatalogoVideojuegos implements Catalogo<Videojuego>{
    private static final String CATALOGO_XML = "./catalogo_videojuegos.xml";

    @XmlElementWrapper(name="Videojuegos")
    @XmlElement(name="Videojuego")
    private List<Videojuego> videojuegos = new ArrayList<>();

    @Override
    public String getCatalogoXml() {
        return CATALOGO_XML;
    }

    @Override
    public List<Videojuego> getList() {
        return videojuegos;
    }

    @Override
    public void saveList(List<Videojuego> lista) {
        if(lista != null) {
            this.videojuegos.clear();
        }
        this.videojuegos = lista;
    }
    
}
