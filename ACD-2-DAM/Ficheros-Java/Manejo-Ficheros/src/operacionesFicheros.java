import java.io.*;

public class operacionesFicheros {
    public static void main(String[] args) {

        // Práctica 1 - Leer fichero (FileReader)
        // Leer el contenido de un fichero en grupos de 20 en 20. Probar a realizar la
        // declaración directamente con la clase FileReader (sin crear un objeto File)

        String ruta = "C:\\Users\\ortiz\\OneDrive\\Escritorio\\ACD-2-DAM\\Ficheros-Java\\Manejo-Ficheros\\src\\miTexto1.txt";
        try (FileReader miTexto = new FileReader(ruta);) {
            int grupos = miTexto.read();
            while (grupos != -1) {
                for (int i = 0; i <= 20; i++) {
                    char letras = (char) grupos;
                    grupos = miTexto.read();
                    System.out.print(letras);
                }
                System.out.println();
            }
            miTexto.close();
        } catch (IOException exp) {
            System.err.println("Problemas en la ejecución del programa." + exp.getMessage());
        }

        // Práctica 2 - Escribir fichero (FileWriter)
        // Ya hemos visto un ejemplo de cómo leer un fichero. En esta práctica hay que
        // crear un fichero de texto con un editor cualquiera y después modificar su
        // contenido con la clase FileWriter.
        // Añadir un carácter cualquiera al final del fichero (p.e. una coma). En el
        // mismo código, añadir una sección en la que escriba el contenido de un
        // String[] en el fichero.

        File miRuta = new File("C:\\Users\\ortiz\\OneDrive\\Escritorio\\ACD-2-DAM\\Ficheros-Java\\Manejo-Ficheros\\src\\miTexto2.txt");
        try (FileWriter escritura = new FileWriter(miRuta, true)) {
            String capitales [] = {"Madrid", "Milan", "Buenos Aires", "Medellin"};
            escritura.write(("," + "\n"));
            for(String info : capitales){
                escritura.write(info + " ");
            }
            escritura.close();
        } catch (Exception e) {
            System.err.println("Problemas en la ejecución del programa." + e.getMessage());
        }

        // Práctica 3 - Leer/escribir fichero por líneas (BufferedReader/BufferedWriter)
        // Leer un fichero línea por línea y mostrarlo por pantalla. Después,
        // modificar el contenido del fichero del fichero (p.e. agregar el número de
        // línea al principio) y volver a visualizar el contenido por pantalla.

    }
}
