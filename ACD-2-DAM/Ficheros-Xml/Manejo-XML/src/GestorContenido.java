import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GestorContenido extends DefaultHandler {

    public GestorContenido() {
        super();
    }

    public void startDocument() {
        System.out.println("Comienzo del documento.");
    }

    public void endDocument() {
        System.out.println("Fin del documento.");
    }

    public void startElement(String uri, String nombre, String nombreArchivo, Attributes ats) {
        System.out.printf("\t Principio del elemento: %s %n", nombre);
    }

    public void endElement(String uri, String nombre, String nombreArchivo, Attributes ats) {
        System.out.printf("\t Fin del elemento: %s %n", nombre);
    }

    public void characters(char[] ch, int inicio, int longitud) throws SAXException {
        String car = new String(ch, inicio, longitud);
        car = car.replaceAll("[\t\n]", "");
        System.out.printf("\tCaracteres: %s %n", car);
    }
}