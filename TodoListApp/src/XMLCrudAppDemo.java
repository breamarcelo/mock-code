
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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLCrudAppDemo {
    public static void main(String[] args) throws TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError, SAXException, IOException {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            createXML(builder);
            // createElement(builder);
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void createXML(DocumentBuilder builder) throws TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError {
        Document doc = builder.getDOMImplementation().createDocument(null, "Personas", null);
        doc.setXmlVersion("1.0");
        Element persona = doc.createElement("persona");
        doc.getDocumentElement().appendChild(persona);
        persona.setAttribute("ID", "1");
        persona.appendChild(doc.createElement("nombre")).appendChild(doc.createTextNode("Marcelo"));
        persona.appendChild(doc.createElement("edad")).appendChild(doc.createTextNode("38"));
        Element persona2 = doc.createElement("persona");
        doc.getDocumentElement().appendChild(persona2);
        persona2.setAttribute("ID", "2");
        persona2.appendChild(doc.createElement("nombre")).appendChild(doc.createTextNode("Nathalia"));
        persona2.appendChild(doc.createElement("edad")).appendChild(doc.createTextNode("37"));
        Element persona3 = doc.createElement("persona");
        doc.getDocumentElement().appendChild(persona3);
        persona3.setAttribute("ID", "3");
        persona3.appendChild(doc.createElement("nombre")).appendChild(doc.createTextNode("Loreto"));
        persona3.appendChild(doc.createElement("edad")).appendChild(doc.createTextNode("6"));
        Element persona4 = doc.createElement("persona");
        //doc.getDocumentElement().appendChild(persona4);
        persona4.setAttribute("ID", "4");
        persona4.appendChild(doc.createElement("nombre")).appendChild(doc.createTextNode("Iago"));
        persona4.appendChild(doc.createElement("edad")).appendChild(doc.createTextNode("0"));

        doc.getDocumentElement().replaceChild(persona4, persona3);

        NodeList list = doc.getElementsByTagName("persona");
        for(int i = 0; i < list.getLength(); i++) {
            if(list.item(i).getAttributes().getNamedItem("ID").getTextContent().equals("2")){
                Node n = list.item(i).getFirstChild();
                System.out.println(n.getTextContent());
                doc.getDocumentElement().removeChild(n.getParentNode());                
            }
        }
        

        TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc), new StreamResult("personas.xml"));
    }

    public static void createElement(DocumentBuilder builder) throws SAXException, IOException {
        Document doc = builder.newDocument();
    }
}
