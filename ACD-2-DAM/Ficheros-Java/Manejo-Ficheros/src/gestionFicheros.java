import java.io.*;
import java.util.Scanner;

public class gestionFicheros {
    public static void main(String[] args) {

        // Práctica 1
        // Utiliza el método list() para recuperar una lista de los archivos del
        // directorio actual.
        // Muestra por pantalla si cada elemento recuperado del directorio es un archivo
        // o un directorio.

        File lista = new File("C:\\");
        String[] miLista = lista.list();
        for (String tipo : miLista) {
            File tipoArchivo = new File(lista, tipo);
            if (tipoArchivo.isFile()) {
                System.out.println("Es una archivo: " + tipoArchivo.getName() + ".");
            } else {
                System.out.println("Es un directorio: " + tipoArchivo.getName() + ".");
            }
        }

        // Práctica 2
        // Realiza un programa Java que utilice el método listFiles() de la clase File,
        // para mostrar la lista de ficheros en un directorio cualquiera.

        Scanner entrada = new Scanner(System.in);
        System.out.println("\n" + "A CONTINUACIÓN INTRODUCE LA RUTA QUE DESEAS BUSCAR: " + "\n");
        String ruta = entrada.nextLine();
        File trabajo = new File(ruta);
        if (trabajo.exists()) {
            File[] carpetaTrabajo = trabajo.listFiles();
            for (File archivos : carpetaTrabajo) {
                System.out.println("\n" + "Contenido de la ruta introducida: " + archivos.getName() + "\n"
                        + "Camino relativo del fichero: " + archivos.getPath() +
                        "\n" + "Camino relativo absoluto del fichero: " + archivos.getAbsolutePath() + "\n"
                        + "Se puede escribir en el fichero? : " + archivos.canWrite() + "\n"
                        + "Se puede leer en el fichero? : " + archivos.canRead());
            }
        } else {
            System.err.println("\n" + "Existe la ruta introducida por teclado? : " + trabajo.exists());
        }
        entrada.close();

        // Práctica 3
        // Crea un nuevo directorio, dentro crea dos ficheros. Una vez creados,
        // renombra uno de los archivos y elimina el otro. Se debe utilizar manejo de
        // excepciones (IOException).

        File directorio = null;
        boolean creado = false;
        try {
            directorio = new File("/home/estudiante/Practica_1");
            creado = directorio.mkdir();
            System.out.println("\n" + "Has podido crear el directorio? : " + creado);
            if (creado == true) {
                // Creación de los archivos dentro del directorio creado anteriormente.
                File archivoUno = new File("/home/estudiante/Practica_1/Primer Archivo.txt");
                creado = archivoUno.createNewFile();
                File archivoDos = new File("/home/estudiante/Practica_1/Segundo Archivo.txt");
                creado = archivoDos.createNewFile();
                if (archivoUno.exists() && archivoDos.exists()) {
                    System.out.println("El primer archivo se ha creado correctamente: " + archivoUno.getName() + "\n"
                            + "El segundo archivo se ha creado correctamente: " + archivoDos.getName());
                } else {
                    System.err.println("No se han creado los archivos.");
                }
                // Renombrando el primer archivo.
                creado = archivoUno.renameTo(archivoDos);
                creado = archivoUno.delete();
                if (!archivoUno.exists()) {
                    System.out.println(
                            "Se ha eliminado el contenido del segundo archivo: " + archivoUno.getAbsolutePath() + "\n");
                }
            }
        } catch (IOException ioe) {
            System.err.println("Problemas en la ejecución del programa.");
            System.err.println(ioe.getMessage());
        }
    }
}