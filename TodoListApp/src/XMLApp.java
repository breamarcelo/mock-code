
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XMLApp {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = null;
        
        File f = new File("empleados.xml");

        try {
            if(!f.exists()){
                createXMLDocument(builder);
            } 
            doc = builder.parse(f);
        } catch (SAXException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
    }

    public static void outputTransformer(Document doc) throws TransformerException{
        TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc), new StreamResult("empleados.xml"));
    }

    public static void createXMLDocument(DocumentBuilder builder) throws TransformerException{
        Document doc = builder.getDOMImplementation().createDocument(null, "Empleados", null);
        doc.setXmlVersion("1.0");
        outputTransformer(doc);
    }

}
