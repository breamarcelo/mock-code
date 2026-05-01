package com.example.services;

import jakarta.xml.bind.JAXBContext;
import models.Libro;

public class XmlService {

    public void method() {
        try {
            JAXBContext context = JAXBContext.newInstance(Libro.class);
        } catch (Exception e) {
    
        }
    }
}
