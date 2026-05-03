package com.example.services;

import java.io.File;
import java.io.FileReader;

import com.example.models.Catalogo;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class XmlService {
    private static XmlService instance;
    private JAXBContext context;
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;

    private XmlService(){
    }

    public static XmlService getInstance() {
        if(instance == null) {
            instance = new XmlService();
        }
        return instance;
    }

    public Catalogo leerCatalogo(Catalogo catalogo) {
        try {
            this.context = JAXBContext.newInstance(catalogo.getClass());
            this.unmarshaller = context.createUnmarshaller();
            catalogo = (Catalogo) unmarshaller.unmarshal(new FileReader(catalogo.getCatalogoXml()));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return catalogo;
    }

    public void guardarCatalogo(Catalogo catalogo) {
        try {
            this.context = JAXBContext.newInstance(catalogo.getClass());
            this.marshaller = context.createMarshaller();
            this.marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(catalogo, new File(catalogo.getCatalogoXml()));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
