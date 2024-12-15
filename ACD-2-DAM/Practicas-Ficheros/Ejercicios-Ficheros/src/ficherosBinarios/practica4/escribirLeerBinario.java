package ficherosBinarios.practica4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* Práctica 4 - Escribir un fichero binario y leerlo (FileInputStream/FileOutputStream)
Escribir datos a un fichero binario (.dat) y después leer el contenido de ese fichero binario para sacarlo por pantalla.  
Agregar una sección del código que añade datos al final del fichero.
 */

public class escribirLeerBinario {
    public static void main(String[] args) throws ClassNotFoundException {

        try {
            File archivoBinario = new File("C:\\Users\\ortiz\\OneDrive\\Escritorio\\ACD-2-DAM\\Practicas-Ficheros\\Ejercicios-Ficheros\\src\\ficherosBinarios\\practica4\\binario.dat");

            try(FileOutputStream salidaBinario = new FileOutputStream(archivoBinario)){
                salidaBinario.write("Hola Mundo Soy Felipe, ".getBytes());
                salidaBinario.write("Curso 2 DAM en Itaca".getBytes());
            }

            try(FileOutputStream salidaBinario = new FileOutputStream(archivoBinario, true)){
                salidaBinario.write("\n *Estamos cerca de las fiestas de navidad*".getBytes());
            }

            try(FileInputStream entradaBinario = new FileInputStream(archivoBinario)){
                int lineasLeidas;
                while((lineasLeidas = entradaBinario.read()) != -1){
                    System.out.print((char) lineasLeidas);
                } 
            }
        } catch (IOException e) {
            System.err.println("Errores en la ejecución: " +  e.getMessage());
        }
        System.out.println();
    }   
}