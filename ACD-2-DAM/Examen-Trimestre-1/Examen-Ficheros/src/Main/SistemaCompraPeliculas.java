package Main;
import java.util.Scanner;

import Gestores.GestorDOM;
import Gestores.GestorSAX;
import Model.Pelicula;

import java.util.ArrayList;

public class SistemaCompraPeliculas {

    public static void main(String[] args) {

        // IMPLEMENTAR: Capturar datos de las películas usando Scanner.
        // - Solicitar al usuario la cantidad de películas a registrar.
        // - Pedir los datos de cada película (Título, Año, Director, Categoría).
        // - Añadir cada película a la lista "peliculas".
        ArrayList<Pelicula> peliculas = new ArrayList<>();

        Scanner entrada = new Scanner(System.in);
        System.out.println("\n" + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "
                + "\n" + "¡GESTIÓN DE CINESA!: A CONTINUACIÓN INTRODUCE LOS SIGUIENTES DATOS: " + "\n"
                + "\n" + "1. TITULO DE LA PELICULA: (CADENA DE TEXTO CON ESPACIOS)."
                + "\n" + "2. AÑO DE ESTRENO O LANZAMIENTO: (NÚMERO ENTERO)."
                + "\n" + "3. NOMBRE DEL DIRECTOR DE LA PELICULA: (CADENA DE TEXTO CON ESPACIOS)"
                + "\n" + "4. CATEGORIA A LA QUE PERTENCE LA PELICULA: (CADENA DE TEXTO CON ESPACIOS)"
                + "\n" + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");

        System.out.println("\n" + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "
                + "\n" + "POR FAVOR INTRODUZCA LA CANTIDAD DE PELICULAS QUE QUIERAS REGISTRAR: (INGRESE NÚMERO ENTERO):"
                + "\n" + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - " + "\n");
        int numeroEmpleados = entrada.nextInt();
        entrada.nextLine();

        System.out.println("\n" + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "
        + "\n" + "CANTIDAD DE PELICULAS SELECCIONADAS PARA REGISTRAS: " + numeroEmpleados
        + "\n" + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - " + "\n");

        for (int i = 0; i < numeroEmpleados; i++) {
            // if(nombreTitulo != null) {
            System.out.println("INTRODUZCA EL NOMBRE DE LA PELICULA: (CADENA DE TEXTO)");
            String nombreTitulo = entrada.nextLine();
            System.out.println();

            System.out.println("INTRODUZCA EL AÑO DE ESTRENO: (NÚMERO ENTERO)");
            int estreno = entrada.nextInt();
            entrada.nextLine();
            System.out.println();

            System.out.println("INTRODUZCA EL NOMBRE DEL DIRECTOR: (CADENA DE TEXTO)");
            String nombreDirector = entrada.nextLine();
            System.out.println();

            System.out.println("INTRODUZCA EL NOMBRE DE LA CATEGORIA: (CADENA DE TEXTO)");
            String nombreCategoria = entrada.nextLine();
            System.out.println();
            peliculas.add(new Pelicula(nombreTitulo, estreno, nombreDirector, nombreCategoria));
            // }
        }
        entrada.close();

        // Llamar a los módulos DOM y SAX
        GestorDOM.guardarEnXML("peliculas.xml", peliculas); // Módulo DOM
        GestorSAX.leerDesdeXML("peliculas.xml"); // Módulo SAX
    }

}
