package SML_EXM_ACD_VACIO.EXAMEN1.src;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class XMLSaxActivity {
    public static void main(String[] args) {
        // Escribir el archivo XML
        escribirXML("empleados_sax.xml");

        // Leer el archivo XML
        leerXML("empleados_sax.xml");
    }

    public static void escribirXML(String archivo) {
        try (FileWriter writer = new FileWriter(archivo)) {
            // Escribir manualmente el contenido XML
            writer.write("<Empleados>\n");

            // Crear lista de empleados
            ArrayList<Empleado> empleados = new ArrayList<>();
            empleados.add(new Empleado(101, "Juan Pérez", 2500.50));
            empleados.add(new Empleado(102, "Ana Gómez", 3000.75));
            empleados.add(new Empleado(103, "Carlos Ruiz", 1800.00));

            // Escribir cada empleado en formato XML
            for (Empleado emp : empleados) {
                writer.write("\t<Empleado>\n");
                writer.write("\t\t<id>" + emp.getId() + "</id>\n");
                writer.write("\t\t<nombre>" + emp.getNombre() + "</nombre>\n");
                writer.write("\t\t<salario>" + emp.getSalario() + "</salario>\n");
                writer.write("\t</Empleado>\n");
            }

            writer.write("</Empleados>\n");
            System.out.println("Archivo XML generado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leerXML(String archivo) {
        try {
            // (0,5 puntos)
            // *** FALTA IMPLEMENTAR: Crear la factoría y el parser SAX ***
            SAXParserFactory miFactoria = SAXParserFactory.newDefaultInstance();
            SAXParser miParser = miFactoria.newSAXParser();
            ArrayList<Empleado> empleados = new ArrayList<>();

            // Crear el manejador SAX
            DefaultHandler handler = new DefaultHandler() {
                Empleado tempEmpleado = null;
                boolean idEmpleado = false;
                boolean nombreEmpleado = false;
                boolean salarioEmpleado = false;

                // (0,75 puntos)
                // *** FALTA IMPLEMENTAR: Implementar 2 métodos en los que se muestre un texto
                // cuando comienza y cuando acaba el documento***
                @Override
                public void startDocument() {
                    System.out.println("\n" + "¡INICIO DE LA LECTURA DEL XML CON LA INTERFAZ SAX!");
                }

                @Override
                public void endDocument() {
                    System.out.println("\n" + "¡FIN DE LA LECTURA DEL XML CON LA INTERFAZ SAX!" + "\n");

                }

                public void startElement(String uri, String localName, String qName, Attributes attributes)
                        throws SAXException {
                    // (0,25 puntos)
                    // *** FALTA IMPLEMENTAR: Identificar el elemento ("Empleado", "id", "nombre" y
                    // "salario") ***
                    // *** y mostrar por pantalla un texto distinto dependiendo del tipo de elemento
                    // ***
                    if (qName.equalsIgnoreCase("empleado")) {
                        tempEmpleado = new Empleado();
                    } else if (qName.equalsIgnoreCase("id")) {
                        idEmpleado = true;
                    } else if (qName.equalsIgnoreCase("nombre")) {
                        nombreEmpleado = true;
                    } else if (qName.equalsIgnoreCase("salario")) {
                        salarioEmpleado = true;
                    }
                }

                public void characters(char[] ch, int start, int length) throws SAXException {
                    // (0,25 puntos)
                    // *** FALTA IMPLEMENTAR: Asignar el valor leído a los campos id, nombre y
                    // salario del empleado temporal ***
                    // *** y formatear el texto de salida para que se visualice correctamente ***
                    if (idEmpleado) {
                        tempEmpleado.setId(Integer.parseInt(new String(ch, start, length)));
                        System.out.println("\n"
                                + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -"
                                + "\n" + "ID DEL EMPLEADO: " + tempEmpleado.getId());
                        idEmpleado = false;
                    } else if (nombreEmpleado) {
                        tempEmpleado.setNombre(new String(ch, start, length));
                        System.out.println("NOMBRE DEL EMPLEADO: " + tempEmpleado.getNombre());
                        nombreEmpleado = false;
                    } else if (salarioEmpleado) {
                        tempEmpleado.setSalario(Double.parseDouble(new String(ch, start, length)));
                        System.out.println("SALARIO DEL EMPLEADO: " + tempEmpleado.getSalario() + " Euros"
                                + "\n"
                                + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
                        salarioEmpleado = false;
                    }
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    // (0,25 puntos)
                    // *** FALTA IMPLEMENTAR: Indicar fin de elemento ***
                    if (qName.equalsIgnoreCase("empleado")) {
                        empleados.add(tempEmpleado);
                    }
                }
            };

            // (0,5 puntos)
            // *** FALTA IMPLEMENTAR: Parsear el archivo usando el parser SAX ***
            miParser.parse(archivo, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Empleado {
        // (0,5 puntos)
        // *** FALTA IMPLEMENTAR: Crea una clase auxiliar para representar un Empleado
        // que contenga las propiedades id(int), nombre(String)
        // *** y salario(double). Tened en cuenta que se requiere un constructor,
        // getters y setters que van a utilizaz escribirXML() y leerXML()
        private int id_emp;
        private String nombre_emp;
        private double salario_emp;

        public Empleado() {
        }

        public Empleado(int Pid, String Pnombre, double Psalario) {
            this.id_emp = Pid;
            this.nombre_emp = Pnombre;
            this.salario_emp = Psalario;
        }

        public int getId() {
            return this.id_emp;
        }

        public String getNombre() {
            return this.nombre_emp;
        }

        public double getSalario() {
            return this.salario_emp;
        }

        public void setId(int Pid) {
            this.id_emp = Pid;
        }

        public void setNombre(String Pnombre) {
            this.nombre_emp = Pnombre;
        }

        public void setSalario(double Psalario) {
            this.salario_emp = Psalario;
        }
    }
}
