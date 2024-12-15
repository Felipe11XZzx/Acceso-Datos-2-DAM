package ficherosBinarios.practica5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*Práctica 5 - Lectura/escritura de primitivas (DataInputStream/DataOutputStream)
Realizar la misma operación que en el ejercicio anterior, pero con la clase indicada en el enunciado.*/

public class leerEscribirPrimitivas {
    public static void main(String[] args) {
        try {
            File pathBinario = new File(
                    "C:\\Users\\ortiz\\OneDrive\\Escritorio\\PRACTICAS-FICHEROS\\PRACTICA-1.2(FICHEROS)\\src\\ficherosBinarios\\practica5\\ficheroBin.dat");
            System.out.println();
            try (DataOutputStream salidaBinario = new DataOutputStream(new FileOutputStream(pathBinario))) {
                salidaBinario.write("Mi Gente Tamo En Japon ".getBytes());
                salidaBinario.write("Gente con: ".getBytes());
                salidaBinario.close();
            }
            try (DataOutputStream salidaBinarioConcatenada = new DataOutputStream(new FileOutputStream(pathBinario, true))) {
                salidaBinarioConcatenada.write("*COJONES ;)* .".getBytes());
                salidaBinarioConcatenada.close();
            }
            try (DataInputStream entradaFichBinario = new DataInputStream(new FileInputStream(pathBinario))) {
                int lineasTexto;
                while((lineasTexto = entradaFichBinario.read()) != -1){
                    System.out.print((char)lineasTexto);
                }
                System.out.println();        
            }
            System.out.println();        
        } catch (IOException e) {
            System.err.println("Errores en la ejecución: " +  e.getMessage());
        }
    }
}
