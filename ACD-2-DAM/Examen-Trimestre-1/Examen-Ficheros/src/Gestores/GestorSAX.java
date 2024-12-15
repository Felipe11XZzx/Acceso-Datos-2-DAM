package Gestores;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import Model.Pelicula;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;

public class GestorSAX {

    public static void leerDesdeXML(String archivo) {
        try {
            // Crear el parser SAX
            // (0,5 puntos) Implementar la creación de una factoría SAXParser y el parser
            // correspondiente.
            SAXParserFactory factoriaSax = SAXParserFactory.newDefaultInstance();
            SAXParser miParser = factoriaSax.newSAXParser();
            List<Pelicula> peliculas = new ArrayList<>();

            // Crear el manejador SAX
            DefaultHandler handler = new DefaultHandler() {
                Pelicula tempPelicula = null;
                boolean tituloPelicula = false;
                boolean anioPelicula = false;
                boolean directorPelicula = false;
                boolean categoriaPelicula = false;

                @Override
                public void startDocument() throws SAXException {
                    System.out.println("\n"
                            + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "
                            + "\n" + "¡INICIO DE LECTURA DEL FICHERO XML CON LA INTERFAZ SAX! : "
                            + "\n"
                            + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
                    super.startDocument();
                }

                @Override
                public void endDocument() throws SAXException {
                    System.out.println("\n"
                            + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "
                            + "\n" + "¡FIN DE LECTURA DEL FICHERO XML CON LA INTERFAZ SAX! : "
                            + "\n"
                            + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
                    super.endDocument();
                }

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes)
                        throws SAXException {
                    // (0,2 puntos) Implementar: Crear un objeto Pelicula temporal si el elemento es
                    // <Pelicula>.
                    if (tempPelicula == null) {
                        tempPelicula = new Pelicula();
                    } else if (qName.equalsIgnoreCase("Titulo")) {
                        tituloPelicula = true;
                    } else if (qName.equalsIgnoreCase("Año")) {
                        anioPelicula = true;
                    } else if (qName.equalsIgnoreCase("Director")) {
                        directorPelicula = true;
                    } else if (qName.equalsIgnoreCase("Categoria")) {
                        categoriaPelicula = true;
                    }
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    // (0,5 puntos) Implementar: Almacenar el valor temporal del elemento actual.
                    if (tituloPelicula) {
                        tempPelicula.setTitulo(new String(ch, start, length));
                        System.out.println("TITULO DE LA PELICULA: " + tempPelicula.getTitulo());
                        tituloPelicula = false;
                    } else if (anioPelicula) {
                        tempPelicula.setAnio(Integer.parseInt(new String(ch, start, length)));
                        System.out.println("AÑO DE ESTRENO O LANZAMIENTO: " + tempPelicula.getAnio());
                        anioPelicula = false;
                    } else if (directorPelicula) {
                        tempPelicula.setDirector(new String(ch, start, length));
                        System.out.println("DIRECTOR DE LA PELICULA: " + tempPelicula.getDirector());
                        directorPelicula = false;
                    } else if (categoriaPelicula) {
                        tempPelicula.setCategoria(new String(ch, start, length));
                        System.out.println("CATEGORIA DE LA PELICULA: " + tempPelicula.getCategoria());
                        categoriaPelicula = false;
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    // (0,2 puntos) Implementar: Asignar los valores de los subelementos a la
                    // película.
                    // Añadir la película a la lista si se cierra el elemento <Pelicula>.
                    if (qName.equalsIgnoreCase("Pelicula")) {
                        peliculas.add(tempPelicula);
                    }
                }
            };

            // (0,4 puntos) Implementar los métodos que llama el handler cuando es Inicio de
            // Documento y Fin de Documento

            // Parsear el archivo XML
            // (0,5 puntos) Implementar el uso del parser SAX para procesar el archivo y
            // pasar el handler.
            miParser.parse(archivo, handler);

            // Mostrar las películas leídas

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
