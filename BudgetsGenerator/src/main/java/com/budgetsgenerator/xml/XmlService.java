package com.budgetsgenerator.xml;

import java.util.List;

import com.budgetsgenerator.viewmodels.ResumentTableItem;
import com.budgetsgenerator.xml.models.PdfGenerator;
import com.budgetsgenerator.xml.models.PresupuestoXml;

public class XmlService {
    private static XmlService instance;
    private static XmlMapper mapper;
    private static XmlGenerator xmlGenerator;
    private static PdfGenerator pdfGenerator = new PdfGenerator();
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
        // String xmlString = 
        xmlGenerator.getInstance().createXml(xml);
        // try {
        //     pdfGenerator.generatePdf(xmlString, new File("/presupuesto.xsl"), new File("presupuesto.pdf"));
        // } catch (Exception e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
    }
}
