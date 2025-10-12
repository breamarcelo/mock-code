
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLParser {
    public static void main(String[] args) throws TransformerException {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            doc.setXmlVersion("1.0");
            Element p = doc.createElement("persona");
            p.setAttribute("id", "1");
            p.setTextContent("Marcelo");
            doc.appendChild(p);

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(System.out);
            try {
                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                transformer.transform(source, result);
            } catch (TransformerConfigurationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (TransformerFactoryConfigurationError e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
