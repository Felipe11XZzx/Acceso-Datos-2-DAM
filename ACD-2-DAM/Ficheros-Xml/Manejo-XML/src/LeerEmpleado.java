import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class LeerEmpleado {
    public static void main(String[] args) throws Exception {

        // Práctica 2.
        // Leer el contenido de “Empleados.xml” y visualizar el resultado por pantalla.
        // Para ello, hay que utilizar las librerías de DOM (DocumentBuilderFactory,
        // DocumentBuilder…).

        DocumentBuilderFactory miFactoria = DocumentBuilderFactory.newDefaultInstance();

        try {
            DocumentBuilder tipoDocumento = miFactoria.newDocumentBuilder();
            Document miDocumento = tipoDocumento.parse(new File("Empleados.xml"));
            miDocumento.getDocumentElement().normalize();
            miDocumento.getElementsByTagName("apellido");
            NodeList nodo = miDocumento.getElementsByTagName("apellido");
            System.out.println("\n" + "Número de empleados: " + nodo.getLength());
            for (int i = 0; i < nodo.getLength(); i++) {
                // Node empleado = nodo.item(i);
                if (nodo.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    // Element elemento = (Element) nodo.item(i);
                    // empleado.getElementsByTagName("id").item(0).getTextContent());
                    System.out.println("\n" + "ID: " + miDocumento.getElementsByTagName("id").item(i).getTextContent());
                    System.out.println("Departamento: "
                            + miDocumento.getElementsByTagName("departamento").item(i).getTextContent());
                    System.out.println(
                            "Salario: " + miDocumento.getElementsByTagName("salario").item(i).getTextContent());
                    System.out.println("Apellidos de los empleados: "
                            + miDocumento.getElementsByTagName("apellido").item(i).getTextContent());
                }
            }
            System.out.println();

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }
}