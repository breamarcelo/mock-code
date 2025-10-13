
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

public class XMLCrudApp {
    public static void main(String[] args) throws TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            createXML(builder);
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void createXML(DocumentBuilder builder) throws TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError {
        Document doc = builder.getDOMImplementation().createDocument(null, "Personas", null);
        doc.setXmlVersion("1.0");

        TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc), new StreamResult("personas.xml"));
    }
}
