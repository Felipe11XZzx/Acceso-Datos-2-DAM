package ficherosTexto.practica1;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*Práctica 1 - Leer fichero (FileReader)
Leer el contenido de un fichero en grupos de 20 en 20.  Probar a realizar la declaración directamente con la clase FileReader (sin crear un objeto File).*/

public class leerfichero {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            File pathFabula = new File("C:\\Users\\ortiz\\OneDrive\\Escritorio\\ACD-2-DAM\\Practicas-Ficheros\\Ejercicios-Ficheros\\src\\ficherosTexto\\practica1\\fabula1.txt");
            FileReader lector = new FileReader(pathFabula);
            int leidos;
            char guiones [] = new char[20];
            while ((leidos = lector.read(guiones)) != -1) {
                System.out.println(new String(guiones, 0, leidos));
            }
            lector.close();
        } catch (IOException e) {
            System.err.println("Errores en la ejecución: " +  e.getMessage());
        }
    }
}
