package ficherosTexto.practica3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;

/*Práctica 3 - Leer/escribir fichero por líneas (BufferedReader/BufferedWriter)
Leer un fichero línea por línea y mostrarlo por pantalla.  Después, modificar el contenido del fichero del fichero (p.e. agregar el número de línea al principio) 
y volver a visualizar el contenido por pantalla.*/

public class leerEscribirLineas {

    public static void leerFichero(File Pathfile) throws ClassNotFoundException {
        try {
            BufferedReader bufferLectura = new BufferedReader(new FileReader(Pathfile));
            System.out.println();
            String lineaTexto;

            while ((lineaTexto = bufferLectura.readLine()) != null) {
                System.out.println(lineaTexto);
            }
            bufferLectura.close();
            System.out.println();
        } catch (IOException e) {
            System.err.println("Errores en la ejecución: " + e.getMessage());
        }
    }

    public static void escribirFichero(File Pathfile) throws ClassNotFoundException {

        try {
            BufferedReader bufferLectura = new BufferedReader(new FileReader(Pathfile));
            System.out.println();
            String lineaTexto;
            ArrayList<String> listaFabula = new ArrayList<>();

            while ((lineaTexto = bufferLectura.readLine()) != null) {
                listaFabula.add(lineaTexto);
            }
            bufferLectura.close();

            BufferedWriter miEscritor = new BufferedWriter(new FileWriter(Pathfile, false));

            for (int i = 0; i < listaFabula.size(); i++) {
                miEscritor.write((i + 1) + "- " + listaFabula.get(i));  // Añadir la numeración
                miEscritor.newLine(); 
            }
            miEscritor.close();
        } catch (IOException e) {
            System.err.println("Errores en la ejecución: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {

        // LECTURA DEL FICHERO.
        File miPath = new File("C:\\Users\\ortiz\\OneDrive\\Escritorio\\ACD-2-DAM\\Practicas-Ficheros\\Ejercicios-Ficheros\\src\\ficherosTexto\\practica3\\fabula3.txt");
        System.out.println("\n¡LECTURA DEL FICHERO SIN LISTARLO!");
        leerFichero(miPath);

        // ESCRITURA EN EL FICHERO (NUMERANDO LÍNEAS)
        escribirFichero(miPath);

        // LECTURA DEL FICHERO MODIFICADO
        System.out.println("\n¡DESPUES DE ACTUALIZAR Y LISTAR EL FICHERO!");
        leerFichero(miPath);
    }
}
