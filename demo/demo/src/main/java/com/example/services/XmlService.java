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
    private final String CATALOGO_XML = "./Catalogo.xml";

    private XmlService(){
        try {
            this.context = JAXBContext.newInstance(Catalogo.class);
            this.marshaller = context.createMarshaller();
            this.marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            this.unmarshaller = context.createUnmarshaller();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static XmlService getInstance() {
        if(instance == null) {
            instance = new XmlService();
        }
        return instance;
    }

    public Catalogo leerCatalogo() {
        Catalogo catalogo = null;
        try {
            catalogo = (Catalogo) unmarshaller.unmarshal(new FileReader(CATALOGO_XML));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return catalogo;
    }

    public void guardarCatalogo(Catalogo catalogo) {
        try {
            marshaller.marshal(catalogo, new File(CATALOGO_XML));
        } catch (Exception e) {
        }
    }
}
