
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
    static Scanner sc = new Scanner(System.in);
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

        // addEmpleado(doc);
        showEmpleados(doc);
        //actualizarEmpleado(doc);
        eliminarEmpleado(doc);
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
    
    public static void addEmpleado(Document doc){
        System.out.println("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Apellidos: ");
        String apellidos = sc.nextLine();
        System.out.println("Departamento: ");
        String departamento = sc.nextLine();
        System.out.println("Código departamento: ");
        int codDept = sc.nextInt();
        System.out.println("Salario: ");
        double salario = sc.nextDouble();
        sc.nextLine();


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
            Element n = (Element) list.item(i);
            String id = n.getAttributes().getNamedItem("ID").getTextContent();
            String nombre = n.getElementsByTagName("nombre").item(0).getTextContent();
            String apellidos = n.getElementsByTagName("apellidos").item(0).getTextContent();
            String codDept = n.getElementsByTagName("departamento").item(0).getAttributes().getNamedItem("codDept").getTextContent();
            String departamento = n.getElementsByTagName("departamento").item(0).getTextContent();
            String salario = n.getElementsByTagName("salario").item(0).getTextContent();
            System.out.println("ID: " + id);
            System.out.println("Nombre: " + nombre + " " + apellidos);
            System.out.println("Departamento: " + codDept + ": " + departamento);
            System.out.println("Salario: " + salario);
        }
    }

    public static void actualizarEmpleado(Document doc){
        System.out.println("Seleccione el empleado por ID:");
        String id = Integer.toString(sc.nextInt());
        sc.nextLine();
        NodeList list = doc.getElementsByTagName("empleado");
        for(int i=0; i<list.getLength(); i++){
            Element n = (Element) list.item(i);
            String empId = n.getAttributes().getNamedItem("ID").getTextContent();
            if(empId.equals(id)){
                System.out.println("Actualizar ID (" + empId +"):");
                String inputId = Integer.toString(sc.nextInt());
                sc.nextLine();
                String empNombre = n.getElementsByTagName("nombre").item(0).getTextContent();
                System.out.println("Actualizar nombre (" + empNombre +"):");
                String inputNombre = sc.nextLine();
                String empApellido = n.getElementsByTagName("apellidos").item(0).getTextContent();
                System.out.println("Actualizar apellido (" + empApellido +"):");
                String inputApellido = sc.nextLine();
                String empCodDept = n.getElementsByTagName("departamento").item(0).getAttributes().getNamedItem("codDept").getTextContent();
                System.out.println("Actualizar código departamento (" + empCodDept +"):");
                String inputCodDept = Integer.toString(sc.nextInt());
                sc.nextLine();
                String empDepartamento = n.getElementsByTagName("departamento").item(0).getTextContent();
                System.out.println("Actualizar departamento (" + empDepartamento +"):");
                String inputDepartamento = sc.nextLine();
                String empSalario = n.getElementsByTagName("salario").item(0).getTextContent();
                System.out.println("Actualizar salario (" + empSalario +"):");
                String inputSalario = Double.toString(sc.nextDouble());
                sc.nextLine();

                Element emp = doc.createElement("empleado");
                doc.getDocumentElement().appendChild(emp);
                emp.setAttribute("ID", inputId);
                emp.appendChild(doc.createElement("nombre")).appendChild(doc.createTextNode(inputNombre));
                emp.appendChild(doc.createElement("apellidos")).appendChild(doc.createTextNode(inputApellido));
                Element dept = doc.createElement("departamento");
                dept.appendChild(doc.createTextNode(inputDepartamento));
                dept.setAttribute("codDept", inputCodDept);
                emp.appendChild(dept);
                emp.appendChild(doc.createElement("salario")).appendChild(doc.createTextNode(inputSalario));

                doc.getDocumentElement().replaceChild(emp, n);

                try {
                    outputTransformer(doc);
                } catch (TransformerException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public static void eliminarEmpleado(Document doc){
        NodeList list = doc.getElementsByTagName("empleado");
        System.out.println("Introduce el ID del empleado a eliminar: ");
        String id = Integer.toString(sc.nextInt());
        sc.nextLine();
        for(int i=0; i<list.getLength(); i++){
            if(list.item(i).getAttributes().getNamedItem("ID").getTextContent().equals(id)){
                doc.getDocumentElement().removeChild(list.item(i));
            }
        }

        try {
            outputTransformer(doc);
        } catch (TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
