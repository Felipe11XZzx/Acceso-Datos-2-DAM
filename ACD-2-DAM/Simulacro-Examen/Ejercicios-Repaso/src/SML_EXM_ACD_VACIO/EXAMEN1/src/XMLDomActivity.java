package SML_EXM_ACD_VACIO.EXAMEN1.src;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


public class XMLDomActivity {
    public static void main(String[] args) {
        // Escribir el archivo XML
        escribirXML("empleados.xml");


        // Leer el archivo XML
        leerXML("empleados.xml");
    }


    public static void escribirXML(String archivo) {
        try {
            // (0,5 PUNTOS)
            // *** FALTA IMPLEMENTAR: Crear la factoría, el builder y el documento XML ***          
            // Crear elemento raíz "Empleados"
            DocumentBuilderFactory miFactoria = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder miBuilder = miFactoria.newDocumentBuilder();
            DOMImplementation misMetodos = miBuilder.getDOMImplementation();
            Document archivoXML = misMetodos.createDocument(archivo, "empleados", null);
            archivoXML.setXmlVersion("1.0");
        
            // Lista de empleados
            ArrayList<Empleado> empleados = new ArrayList<>();
            empleados.add(new Empleado(101, "Juan Pérez", 2500.50));
            empleados.add(new Empleado(102, "Ana Gómez", 3000.75));
            empleados.add(new Empleado(103, "Carlos Ruiz", 1800.00));


            for (Empleado emp : empleados) {
                // (0,5 PUNTOS)
                // *** FALTA IMPLEMENTAR: Añadir los elementos "Empleado", "id", "nombre" y "salario" al documento ***
                if(emp.id > 0) {
                    Element miCabecera = archivoXML.createElement("empleado");
                    archivoXML.getDocumentElement().appendChild(miCabecera);

                    Element etiquetaId = archivoXML.createElement("id");
                    Text textoId = archivoXML.createTextNode(Integer.toString(emp.getId()));
                    miCabecera.appendChild(etiquetaId);
                    etiquetaId.appendChild(textoId);

                    Element etiquetaNombre = archivoXML.createElement("nombre");
                    Text textoNombre = archivoXML.createTextNode(emp.getNombre());
                    miCabecera.appendChild(etiquetaNombre);
                    etiquetaNombre.appendChild(textoNombre);

                    Element etiquetaSalario = archivoXML.createElement("salario");
                    Text textoSalario = archivoXML.createTextNode(Double.toString(emp.getSalario()));
                    miCabecera.appendChild(etiquetaSalario);
                    etiquetaSalario.appendChild(textoSalario);
                }
            }
            // (0,5 PUNTOS)
            // *** FALTA IMPLEMENTAR: Transformar el documento XML y guardarlo en un archivo ***
            Transformer miTransformer = TransformerFactory.newDefaultInstance().newTransformer();
            DOMSource miFuente = new DOMSource(archivoXML);
            File documentoXML = new File("C:\\Users\\ortiz\\OneDrive\\Escritorio\\ACD-2-DAM\\Simulacro-Examen\\Ejercicios-Repaso\\src\\SML_EXM_ACD_VACIO\\EXAMEN1\\src\\empleados.xml");
            StreamResult misResultados = new StreamResult(documentoXML);
            miTransformer.transform(miFuente, misResultados);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void leerXML(String archivo) {
        try {
            // (0,5 PUNTOS)
            // *** FALTA IMPLEMENTAR: Crear la factoría, el builder y el documento XML a partir del archivo ***
            DocumentBuilderFactory miFabrica = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder formatoDoc = miFabrica.newDocumentBuilder();
            File pathEmpleadosXML = new File("C:\\\\Users\\\\ortiz\\\\OneDrive\\\\Escritorio\\\\ACD-2-DAM\\\\Simulacro-Examen\\\\Ejercicios-Repaso\\\\src\\\\SML_EXM_ACD_VACIO\\\\EXAMEN1\\\\src\\\\empleados.xml");
            Document ficheroXML = formatoDoc.parse(pathEmpleadosXML);

            // Obtener todos los empleados del archivo XML
            NodeList listaEmpleados = ficheroXML.getElementsByTagName("empleado");
            System.out.println("\n" + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -"
                            +  "\n" + "¡CANTIDAD DE EMPLEADOS EN LA EMPRESA: !" + listaEmpleados.getLength()
                            +  "\n" + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -"
                            +  "\n");
    
            for (int i = 0; i < listaEmpleados.getLength(); i++) {
                // (0,5 PUNTOS)
                // *** FALTA IMPLEMENTAR: Recuperar el empleado, leer y mostrar los elementos "id", "nombre" y "salario" ***S
                Node etiquetasXML = listaEmpleados.item(i);
                if(etiquetasXML.getNodeType() == Node.ELEMENT_NODE) {
                    Element contenidoEtiquetas = (Element) etiquetasXML;
                    System.out.println("\n" + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -"
                                    +  "\n" + "NÚMERO DE EMPLEADO: " + (i+ 1)
                                    +  "\n" + "ID DEL EMPLEADO: " + contenidoEtiquetas.getElementsByTagName("id").item(0).getTextContent()
                                    +  "\n" + "NOMBRE DEL EMPLEADO: " + contenidoEtiquetas.getElementsByTagName("nombre").item(0).getTextContent()
                                    +  "\n" + "SALARIO DEL EMPLEADO: " + contenidoEtiquetas.getElementsByTagName("salario").item(0).getTextContent() + " Euros."
                                    +  "\n" + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -"
                                    +  "\n");
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Clase auxiliar para representar un Empleado
    static class Empleado {
        int id;
        String nombre;
        double salario;


        public Empleado(int id, String nombre, double salario) {
            this.id = id;
            this.nombre = nombre;
            this.salario = salario;
        }


        public int getId() { return id; }
        public String getNombre() { return nombre; }
        public double getSalario() { return salario; }
    }
}
