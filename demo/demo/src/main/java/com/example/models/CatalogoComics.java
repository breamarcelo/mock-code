package com.example.models;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CatalogoComics implements Catalogo<Comic> {
    private final String CATALOGO_XML = "./catalogo_comics.xml";
    
    @XmlElementWrapper(name="Comics")
    @XmlElement(name="Comic")
    private List<Comic> comics;

    @Override
    public String getCatalogoXml() {
        return CATALOGO_XML;
    }

    @Override
    public List<Comic> getList() {
        return comics;
    }

    @Override
    public void saveList(List<Comic> lista) {
        this.comics = lista;
    }

}
