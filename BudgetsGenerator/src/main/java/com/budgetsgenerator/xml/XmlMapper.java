package com.budgetsgenerator.xml;

import java.util.ArrayList;
import java.util.List;

import com.budgetsgenerator.viewmodels.ResumentTableItem;
import com.budgetsgenerator.xml.models.LineasPresupuestoXml;


public class XmlMapper {
    private XmlMapper instance;
    
    private XmlMapper(){
    }
    
    public XmlMapper getInstance() {
        if(instance == null) {
            instance = new XmlMapper();
        }
        return instance;
    }
    
    public void lineaToToXml(List<ResumentTableItem> tableItems){
        List<LineasPresupuestoXml> listaLineas = new ArrayList<>();
        LineasPresupuestoXml xml = null;
        String descripcion = "";
        double total = 0.0;
        for(ResumentTableItem item : tableItems) {
            xml = new LineasPresupuestoXml();
    
            for(String line : item.getDescripcion().getItems()) {
                descripcion += line + "\n";
            }

            xml.setCantidad(Integer.toString(item.getCantidad()));
            xml.setDescripcion(descripcion);
            xml.setImporte(Double.toString(item.getImporte()));

            listaLineas.add(xml);
        }

    }
}
