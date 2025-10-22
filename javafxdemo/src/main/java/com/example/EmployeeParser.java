package com.example;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class EmployeeParser {
    
    private File file = new File("Employees.xml");
    private DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

    public EmployeeParser() throws ParserConfigurationException, TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError {
        
        if(!this.getFile().exists()){
            Document doc = this.getBuilder().getDOMImplementation().createDocument(null, "Employees", null);
            doc.setXmlVersion("1.0");
            outputTransformer(doc);
        }
    }

    public void outputTransformer(Document doc) throws TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError{
        TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc), new StreamResult(this.getFile()));
    }

    public void readXmlFile() throws SAXException, IOException{
        Document doc = this.getBuilder().parse(this.getFile());
        NodeList list = doc.getElementsByTagName("employee");
        for (int i = 0; i < list.getLength(); i++) {
            Element emp = (Element) list.item(i);
            String id = emp.getElementsByTagName("id").item(0).getTextContent();
            String name = emp.getElementsByTagName("name").item(0).getTextContent();
            String lName = emp.getElementsByTagName("lastName").item(0).getTextContent();
            String deptIt = emp.getElementsByTagName("deptId").item(0).getTextContent();
            String deptName = emp.getElementsByTagName("deptName").item(0).getTextContent();
            String salary = emp.getElementsByTagName("salary").item(0).getTextContent();
        }
    }

    public File getFile() {
        return file;
    }

    public DocumentBuilder getBuilder() {
        return builder;
    }
    
}
