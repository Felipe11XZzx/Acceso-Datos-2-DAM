package Gestores;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import Model.Pelicula;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;


public class GestorDOM {

    public static void guardarEnXML(String archivo, List<Pelicula> peliculas) {
        try {
            // Crear el documento XML
            // (0,5 puntos) Implementar la creación de un DocumentBuilder (Factoría, Builder, Implementacion, Documento) y un nuevo documento.
            DocumentBuilderFactory miFactoria = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder tipoDocumento = miFactoria.newDocumentBuilder();
            DOMImplementation metodosDOM = tipoDocumento.getDOMImplementation();
            Document peliculasXML = metodosDOM.createDocument(archivo, "peliculas", null);
            peliculasXML.setXmlVersion("1.0");


            // Crear el elemento raíz <Peliculas>
            // (0,5 puntos) Implementar la creación del documento raiz con su qualified name y la version
            Element cabeceraPeliculas = peliculasXML.createElement("Peliculas");
            peliculasXML.getDocumentElement().appendChild(cabeceraPeliculas);


            // Crear los elementos para cada película
            for (Pelicula pelicula : peliculas) {
                // (1 punto) Implementar creación de un elemento <Pelicula>.
                // Añadir subelementos <Titulo>, <Año>, <Director> y <Categoria> con sus valores.
                if(pelicula.getAnio() > 0) {

                Element etiquetaTitulo = peliculasXML.createElement("Titulo");
                Text textoTitulo = peliculasXML.createTextNode(pelicula.getTitulo());
                cabeceraPeliculas.appendChild(etiquetaTitulo);
                etiquetaTitulo.appendChild(textoTitulo);

                Element etiquetaAnio = peliculasXML.createElement("Año");
                Text textoAnio = peliculasXML.createTextNode(Integer.toString(pelicula.getAnio()));
                cabeceraPeliculas.appendChild(etiquetaAnio);
                etiquetaAnio.appendChild(textoAnio);

                Element etiquetaDirector = peliculasXML.createElement("Director");
                Text textoDirector = peliculasXML.createTextNode(pelicula.getDirector());
                cabeceraPeliculas.appendChild(etiquetaDirector);
                etiquetaDirector.appendChild(textoDirector);

                Element etiquetaCategoria = peliculasXML.createElement("Categoria");
                Text textoCategoria = peliculasXML.createTextNode(pelicula.getCategoria());
                cabeceraPeliculas.appendChild(etiquetaCategoria);
                etiquetaCategoria.appendChild(textoCategoria);
                }
            }


            // Guardar el archivo XML
            // (0,5 puntos) Implementar el uso de Transformer para guardar el archivo en el sistema.
            Transformer miTransformador = TransformerFactory.newInstance().newTransformer();
            DOMSource fuenteDOM = new DOMSource(peliculasXML);
            File pathXML = new File(archivo);
            StreamResult misResultados = new StreamResult(pathXML);
            miTransformador.transform(fuenteDOM, misResultados);
            peliculasXML.getDocumentElement().normalize();


            System.out.println("Archivo XML guardado correctamente: " + archivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
