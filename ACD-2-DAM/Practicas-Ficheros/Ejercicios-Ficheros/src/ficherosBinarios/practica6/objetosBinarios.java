package ficherosBinarios.practica6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectInputStream;

/*Práctica 6 - Objetos en ficheros binarios (ObjectInputStream/ObjectOutputStream)
Partimos de la siguiente clase para el objeto persona:
Crear un programa que escriba un set de objetos de tipo Persona y lo grabe a un fichero binario.  
Después realizar una lectura de ese fichero y cargarlo a objetos de tipo persona.
IMPORTANTE: Añadir throw ClassNotFoundException al método main()*/

public class objetosBinarios implements Serializable {
    public static void main(String[] args) throws ClassNotFoundException {

        try {
            ObjectOutputStream escribirObjeto = new ObjectOutputStream(new FileOutputStream(new File("C:\\Users\\ortiz\\OneDrive\\Escritorio\\ACD-2-DAM\\Practicas-Ficheros\\Ejercicios-Ficheros\\src\\ficherosBinarios\\practica6", "ficheroEmpleados.dat")));
            
            Persona p1 = new Persona("Diana", 44);
            Persona p2 = new Persona("Felipe", 21);
            Persona p3 = new Persona("Carmen", 26);
            Persona p4 = new Persona();
            p4.setNombre_persona("Rolando");
            p4.setEdad_persona(27);

            escribirObjeto.writeObject(p1);
            escribirObjeto.writeObject(p2);
            escribirObjeto.writeObject(p3);
            escribirObjeto.writeObject(p4);

            escribirObjeto.close();

            ObjectInputStream lectorObjeto = new ObjectInputStream(new FileInputStream(new File("C:\\Users\\ortiz\\OneDrive\\Escritorio\\ACD-2-DAM\\Practicas-Ficheros\\Ejercicios-Ficheros\\src\\ficherosBinarios\\practica6\\ficheroEmpleados.dat")));

            Persona lecturaP1 = (Persona) lectorObjeto.readObject();
            Persona lecturaP2 = (Persona) lectorObjeto.readObject();
            Persona lecturaP3 = (Persona) lectorObjeto.readObject();
            Persona lecturaP4 = (Persona) lectorObjeto.readObject();

            System.out.println("\n" + lecturaP1.toString());
            System.out.println(lecturaP2.toString());
            System.out.println(lecturaP3.toString());
            System.out.println(lecturaP4.toString() + "\n");

            lectorObjeto.close();
        } catch (IOException e) {
            System.err.println("Errores en la ejecución: " +  e.getMessage());
        }
    }
}
