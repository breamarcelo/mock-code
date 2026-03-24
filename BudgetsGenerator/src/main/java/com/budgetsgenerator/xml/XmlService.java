package com.budgetsgenerator.xml;

import java.util.List;

import com.budgetsgenerator.viewmodels.ResumentTableItem;
import com.budgetsgenerator.xml.models.PresupuestoXml;

public class XmlService {
    private static XmlService instance;
    private static XmlMapper mapper;
    private static XmlGenerator generator;
    private static PresupuestoXml xml;

    private XmlService(){
        this.mapper = mapper.getInstance();
        this.generator = generator.getInstance();
    }

    public static XmlService getInstance() {
        if(instance == null) {
            instance = new XmlService();
        }
        return instance;
    }

    public void createPdf(List<ResumentTableItem> tableItems, String total){
        xml = mapper.lineaToToXml(tableItems, total);
        generator.createXml(xml);
    }
}
