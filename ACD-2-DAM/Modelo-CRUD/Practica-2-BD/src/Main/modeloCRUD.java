package Main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Factory.DaoFactory;
import Interfaces.IDao;
import Models.clienteOB;
import Models.proyectoOB;

public class modeloCRUD {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) throws ClassNotFoundException {

        //Objeto para almacenar información
        proyectoOB proyecto = new proyectoOB();
        clienteOB cliente = new clienteOB();

        //Obtenemos instancia del dao PLAYER
        IDao ObjetodaoProyecto = DaoFactory.getDao(DaoFactory.DaoType.proyectoOB);
        IDao ObjetodaoCliente = DaoFactory.getDao(DaoFactory.DaoType.clienteOB);


        //Lista para almacenar registros
        List<proyectoOB> misProyectos = new ArrayList<>();
        List<clienteOB> misClientes = new ArrayList<>();

        //Para almacenar la acción que queremos realizar
        int opcion;

        //Guarda el id del jugador que queramos
        int idProyecto;

        //Variable para controlar el flujo del menú
        boolean continuar = true;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("INTRODUCE POR FAVOR EL NOMBRE DE LA TABLA CON LA QUIERES TRABAJAR: " + "[OPCIÓN 1] CLIENTES, [OPCIÓN 2] PROYECTO." + "\n");
            String seleccionTabla = sc.nextLine();
            System.out.println();

            if(seleccionTabla.equalsIgnoreCase("CLIENTES")){
                System.out.println("|GESTIÓN DE CLIENTES EMPRESA|");
                System.out.println("¿QUE ACCIÓN QUIERES REALIZAR?");
                System.out.println("!A CONTINUACIÓN INTRODUCE EL NÚMERO DE LA IZQUIERDA PARA REALIZAR LA ACCIÓN: ¡");
                System.out.println("[1] CREAR REGISTRO\n"
                        + "[2] ACTUALIZAR REGISTRO\n"
                        + "[3] ELIMINAR REGISTRO\n"
                        + "[4] BUSCAR REGISTRO\n"
                        + "[5] MOSTRAR TODOS LOS CONTENIDOS DE LA TABLA\n"
                        + "[0] SALIR DEL PROGRAMA\n");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("|REGISTRAR CLIENTE|" + "\n");
                        System.out.println("INGRESA EL IDENTIFICADOR DEL CLIENTE: (NÚMERO ENTERO)");
                        int id = sc.nextInt();
                        cliente.setId_Cliente(id);
                        sc.nextLine();
                        System.out.println();
    
                        System.out.println("INGRESA LA PERSONA DE CONTACTO: (CADENA DE TEXTO)");
                        String contacto = sc.nextLine();
                        cliente.setPersona_Contacto(contacto);
                        System.out.println();
    
                        System.out.println("INGRESA EL MÓVIL DE CONTACTO: (CADENA DE TEXTO)");
                        String movil = sc.nextLine();
                        cliente.setTlfn_Contacto(movil);;
                        System.out.println();
    
                        System.out.println("INSERTA EL CIF DEL CLIENTE: (CADENA DE TEXTO)");
                        String cif = sc.nextLine();
                        cliente.setCif(cif);;
                        System.out.println();
    
                        System.out.println(ObjetodaoCliente.crearRegistro(cliente));
                        break;
    
                    case 2:
                        System.out.println("|ACTUALIZAR CLIENTE|" + "\n");
                        sc.nextLine();
                        System.out.println("INSERTA PERSONA DE CONTACTO NUEVA: (CADENA DE TEXTO)");
                        String contacto1 = sc.nextLine();
                        cliente.setPersona_Contacto(contacto1);
                        System.out.println();
    
                        System.out.println("INSERTA NUEVO TELÉFONO DE CONTACTO: (CADENA DE TEXTO)");
                        sc.nextLine();
                        String movil1 = sc.nextLine();
                        cliente.setTlfn_Contacto(movil1);;
                        System.out.println();
    
                        System.out.println("INSERTA NUEVO CIF: (CADENA DE TEXTO)");
                        String cif1 = sc.nextLine();
                        cliente.setCif(cif1);
                        System.out.println();
    
                        System.out.println("INTRODUCE EL IDENTIFICADOR DEL CLIENTE QUE QUIERES ACTUALIZAR: (NÚMERO ENTERO)");
                        cliente.setId_Cliente(sc.nextInt());
                        System.out.println();
                        System.out.println(ObjetodaoCliente.crearRegistro(cliente));
                        break;
    
                    case 3:
                        System.out.println("|ELIMINAR CLIENTE|");
                        System.out.println("ID DEL CLIENTE A ELIMINAR DE LA TABLA: (NÚMERO ENTERO)");
                        int idCliente = sc.nextInt();
                        sc.nextLine();
                        System.out.println();
                        System.out.println(ObjetodaoCliente.eliminarRegistro(idCliente));
                        break;
    
                    case 4:
                        System.out.println("|BUSCAR CLIENTE|" + "\n");
                        System.out.println("INTRODUCE EL ID DEL CLIENTE A BUSCAR: (NÚMERO ENTERO)");
                        idCliente = sc.nextInt();
                        System.out.println();
                        System.out.println("ID INTRODUCIDO POR EL USUARIO: " + idCliente + "\n");
                        ObjetodaoCliente.leerRegistro(idCliente);
                        System.out.println(ObjetodaoCliente.leerRegistro(idCliente));
                        break;
    
                    case 5:
                        System.out.println("|LISTA DE REGISTROS DE CLIENTES|");
                        misClientes.clear();
                        misClientes = ObjetodaoCliente.leerDatos();
                        for (clienteOB record : misClientes) {
                            System.out.println(record.toString());
                        }
                        break;
                    case 0:
                        System.out.println("|SALIENDO...|");
                        break;
                    default:
                        System.out.println("OPCIÓN INVALIDA EN EL PROGRAMA");
                }
                
                if (opcion == 0) {
                    continuar = false;
                }else{
                    System.out.println("\n" + "¿REALIZAR OTRA ACCIÓN? [1] SÍ / [2] NO" + "\n");
                    opcion = sc.nextInt();
                    System.out.println();
                    if(opcion != 1){
                        continuar = false;
                        System.out.println("|SALIENDO...|");
                    }
                }
            }

            else if(seleccionTabla.equalsIgnoreCase("PROYECTO")){
                System.out.println("|GESTIÓN DE PROYECTOS EMPRESA|");
            System.out.println("¿QUE ACCIÓN QUIERES REALIZAR?");
            System.out.println("!A CONTINUACIÓN INTRODUCE EL NÚMERO DE LA IZQUIERDA PARA REALIZAR LA ACCIÓN: ¡");
            System.out.println("[1] CREAR REGISTRO\n"
                    + "[2] ACTUALIZAR REGISTRO\n"
                    + "[3] ELIMINAR REGISTRO\n"
                    + "[4] BUSCAR REGISTRO\n"
                    + "[5] MOSTRAR TODOS LOS CONTENIDOS DE LA TABLA\n"
                    + "[0] SALIR DEL PROGRAMA\n");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("|REGISTRAR PROYECTO|" + "\n");
                    System.out.println("INGRESA EL IDENTIFICADOR DEL PROYECTO: (NÚMERO ENTERO)");
                    int id = sc.nextInt();
                    proyecto.setIdProyecto(id);
                    sc.nextLine();
                    System.out.println();

                    System.out.println("INGRESA EL NOMBRE DEL PROYECTO: (CADENA DE TEXTO)");
                    String nombre = sc.nextLine();
                    proyecto.setNombreProyecto(nombre);;
                    System.out.println();

                    System.out.println("INGRESA LA UBICACIÓN DEL PROYECTO: (CADENA DE TEXTO)");
                    String ubicacion = sc.nextLine();
                    proyecto.setUbicacionProyecto(ubicacion);;
                    System.out.println();

                    System.out.println("INSERTA EL ID DEL CLIENTE: (NÚMERO ENTERO)");
                    int idCliente = sc.nextInt();
                    proyecto.setIdCliente(idCliente);

                    System.out.println();

                    System.out.println(ObjetodaoProyecto.crearRegistro(proyecto));
                    break;

                case 2:
                    System.out.println("|ACTUALIZAR PROYECTO|" + "\n");
                    sc.nextLine();
                    System.out.println("INSERTA NOMBRE NUEVO DEL PROYECTO: (CADENA DE TEXTO)");
                    String nombreProyecto = sc.nextLine();
                    proyecto.setNombreProyecto(nombreProyecto);
                    System.out.println();

                    System.out.println("INSERTA NUEVA UBICACIÓN DEL PROYECTO: (CADENA DE TEXTO)");
                    sc.nextLine();
                    String nuevaUbicacion = sc.nextLine();
                    proyecto.setUbicacionProyecto(nuevaUbicacion);
                    System.out.println();

                    System.out.println("INSERTA ID NUEVO DEL CLIENTE: (NÚMERO ENTERO)");
                    proyecto.setIdCliente(sc.nextInt());
                    System.out.println();

                    System.out.println("INTRODUCE EL IDENTIFICADOR DEL PROYECTO QUE QUIERES ACTUALIZAR: (NÚMERO ENTERO)");
                    proyecto.setIdProyecto(sc.nextInt());
                    System.out.println();
                    System.out.println(ObjetodaoProyecto.crearRegistro(proyecto));
                    break;

                case 3:
                    System.out.println("|ELIMINAR PROYECTO|");
                    System.out.println("ID DEL PROYECTO A ELIMINAR DE LA TABLA: (NÚMERO ENTERO)");
                    idProyecto = sc.nextInt();
                    sc.nextLine();
                    System.out.println();
                    System.out.println(ObjetodaoProyecto.eliminarRegistro(idProyecto));
                    break;

                case 4:
                    System.out.println("|BUSCAR PROYECTO|" + "\n");
                    System.out.println("INTRODUCE EL ID DEL PROYECTO A BUSCAR: (NÚMERO ENTERO)");
                    idProyecto = sc.nextInt();
                    System.out.println();
                    System.out.println("ID INTRODUCIDO POR EL USUARIO: " + idProyecto + "\n");
                    ObjetodaoProyecto.leerRegistro(idProyecto);
                    System.out.println(ObjetodaoProyecto.leerRegistro(idProyecto));
                    break;

                case 5:
                    System.out.println("|LISTA DE REGISTROS DE PROYECTOS|");
                    misProyectos.clear();
                    misProyectos = ObjetodaoProyecto.leerDatos();
                    for (proyectoOB record : misProyectos) {
                        System.out.println(record.toString());
                    }
                    break;
                case 0:
                    System.out.println("|SALIENDO...|");
                    break;
                default:
                    System.out.println("OPCIÓN INVALIDA EN EL PROGRAMA");
            }
            
            if (opcion == 0) {
                continuar = false;
            }else{
                System.out.println("\n" + "¿REALIZAR OTRA ACCIÓN? [1] SÍ / [2] NO" + "\n");
                opcion = sc.nextInt();
                System.out.println();
                if(opcion != 1){
                    continuar = false;
                    System.out.println("|SALIENDO...|");
                }
            }
        }
        } while (continuar);
        sc.close();
    }
}