
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLApp {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        Scanner sc = new Scanner(System.in);
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

        /* 
         * 
         System.out.println("ID: ");
         int id = sc.nextInt();
         sc.nextLine();
         System.out.println("Nombre: ");
         String nombre = sc.nextLine();
         System.out.println("Apellidos: ");
         String apellidos = sc.nextLine();
         System.out.println("Departamento: ");
         String departamento = sc.nextLine();
         System.out.println("Código epartamento: ");
         int codDept = sc.nextInt();
         System.out.println("Salario: ");
         double salario = sc.nextDouble();
         sc.nextLine();
         
         addEmpleado(doc, id, nombre, apellidos, departamento, codDept, salario);
         */

         showEmpleados(doc);
        
    }

    public static void outputTransformer(Document doc) throws TransformerException{
        TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc), new StreamResult("empleados.xml"));
    }

    public static void createXMLDocument(DocumentBuilder builder) throws TransformerException{
        Document doc = builder.getDOMImplementation().createDocument(null, "Empleados", null);
        doc.setXmlVersion("1.0");
        outputTransformer(doc);
    }

    public static void addEmpleado(Document doc, int id, String nombre, String apellidos, String departamento, int codDept, double salario){
        Element emp = doc.createElement("empleado");
        doc.getDocumentElement().appendChild(emp);
        emp.setAttribute("ID", Integer.toString(id));
        emp.appendChild(doc.createElement("nombre")).appendChild(doc.createTextNode(nombre));
        emp.appendChild(doc.createElement("apellidos")).appendChild(doc.createTextNode(apellidos));
        Element dept = doc.createElement("departamento");
        dept.appendChild(doc.createTextNode(departamento));
        dept.setAttribute("codDept", Integer.toString(codDept));
        emp.appendChild(dept);
        emp.appendChild(doc.createElement("salario")).appendChild(doc.createTextNode(Double.toString(salario)));

        try {
            outputTransformer(doc);
        } catch (TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void showEmpleados(Document doc){
        NodeList list = doc.getElementsByTagName("empleado");
        for(int i=0; i < list.getLength(); i++){
            String id = list.item(i).getAttributes().getNamedItem("ID").getTextContent();
            System.out.println("ID: " + id);
            
        }
    }
}
