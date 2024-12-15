import java.io.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class FicheroXmlSax {
   public static void main(String[] args) throws IOException, SAXException {
      XMLReader procesadorXML = XMLReaderFactory.createXMLReader();

      GestorContenido gestor = new GestorContenido();
      procesadorXML.setContentHandler(gestor);

      InputSource archivoXML = new InputSource("C:\\Users\\ortiz\\OneDrive\\Escritorio\\ACD-2-DAM\\FIcheros-Xml\\Manejo-XML\\src\\Empleados.xml");
      procesadorXML.parse(archivoXML);
   }
}