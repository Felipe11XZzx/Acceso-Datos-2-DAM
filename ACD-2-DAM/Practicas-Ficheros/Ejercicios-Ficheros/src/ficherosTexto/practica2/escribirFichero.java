package ficherosTexto.practica2;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*Práctica 2 - Escribir fichero (FileWriter)
Ya hemos visto un ejemplo de cómo leer un fichero.  En esta práctica hay que crear un fichero de texto con un editor cualquiera 
y después modificar su contenido con la clase FileWriter.  Añadir un carácter cualquiera al final del fichero (p.e. una coma).
En el mismo código, añadir una sección en la que escriba el contenido de un String[] en el fichero.
*/

public class escribirFichero{
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            File pathFabula = new File("C:\\Users\\ortiz\\OneDrive\\Escritorio\\ACD-2-DAM\\Practicas-Ficheros\\Ejercicios-Ficheros\\src\\ficherosTexto\\practica2\\fabula2.txt");
            FileWriter miEscritor = new FileWriter(pathFabula, true);
            String contenido [] = {"¡Y VIVIERON", "FELICES", "PARA", "SIEMPRE!"};
            miEscritor.write("," + "\n");
            for(String dato : contenido){
                miEscritor.write(dato + " " + "\n");
            }
            System.out.println("!LA ESCRITURA SE REALIZO CORRECTAMENTE¡ \n");
            miEscritor.close();
        } catch (IOException e) {
            System.err.println("Errores en la ejecución: " +  e.getMessage());
        }
    }
}