package com.budgetsgenerator.xml;

import java.util.List;

import com.budgetsgenerator.viewmodels.ResumentTableItem;
import com.budgetsgenerator.xml.models.PdfGenerator;
import com.budgetsgenerator.xml.models.PresupuestoXml;

public class XmlService {
    private static XmlService instance;
    private static XmlMapper mapper;
    private static XmlGenerator xmlGenerator;
    private static PdfGenerator pdfGenerator;
    private static PresupuestoXml xml;

    private XmlService(){
    }

    public static XmlService getInstance() {
        if(instance == null) {
            instance = new XmlService();
        }
        return instance;
    }

    public void createPdf(List<ResumentTableItem> tableItems, String total){
        xml = mapper.getInstance().lineaToToXml(tableItems, total);
        xmlGenerator.getInstance().createXml(xml);
        
    }
}
