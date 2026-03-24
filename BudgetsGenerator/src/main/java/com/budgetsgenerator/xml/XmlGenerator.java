package com.budgetsgenerator.xml;

import java.io.File;

import com.budgetsgenerator.xml.models.PresupuestoXml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

public class XmlGenerator {
    private static XmlGenerator instance;
    private static JAXBContext context; 
    private static PresupuestoXml presupuesto;

    private XmlGenerator(){
    }

    public static XmlGenerator getInstance() {
        if(instance == null) {
            instance = new XmlGenerator();
        }
        return instance;
    }
    
    public static void createXml(PresupuestoXml presupuesto) {
        try {
            context = JAXBContext.newInstance(PresupuestoXml.class);
            Marshaller m = context.createMarshaller();
            m.marshal(presupuesto, new File("presupuesto.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
