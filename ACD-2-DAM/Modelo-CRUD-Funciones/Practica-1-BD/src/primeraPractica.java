import java.sql.*;

public class primeraPractica {

    private static Connection miConexion;
    private static String url;

    public static void crearBD(String nombreGBD) throws ClassNotFoundException {
        url = "jdbc:sqlite:C:\\Users\\ortiz\\OneDrive\\Escritorio\\ACD-2-DAM\\Modelo-CRUD-Funciones\\Practica-1-BD\\src\\" + nombreGBD;
        try {
            Class.forName("org.sqlite.JDBC");
            miConexion = DriverManager.getConnection(url);
            Statement estado = miConexion.createStatement();

            if (miConexion != null) {
                DatabaseMetaData datos = miConexion.getMetaData();
                System.out.println("\n" + "El nombre del controlador es: " + datos.getDriverName()
                        + " Se ha creado una nueva base de datos." + "\n"
                        + "estado de la base de datos: " + estado + "\n");
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void crearTablaDepartamento() {
        String tablaDepartamento = "CREATE TABLE IF NOT EXISTS departamento(\n"
                + "id_seccion TYNYINT NOT NULL PRIMARY KEY,\n"
                + "nombre_sec VARCHAR,\n"
                + "ubicacion VARCHAR\n"
                + ")";

        try {
            miConexion = DriverManager.getConnection(url);
            Statement estado = miConexion.createStatement();
            estado.execute(tablaDepartamento);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void crearTablaEmpleado() {
        String tablaEmpleados = "CREATE TABLE IF NOT EXISTS empleados(\n"
                + "id_departamento TYNYINT NOT NULL PRIMARY KEY,\n"
                + "id_proyecto TYNYINT,\n"
                + "nombre VARCHAR,\n"
                + "apellidos VARCHAR,\n"
                + "dni VARCHAR,\n"
                + "salario FLOAT\n"
                + ")";

        try {
            miConexion = DriverManager.getConnection(url);
            Statement estado = miConexion.createStatement();
            estado.execute(tablaEmpleados);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void crearTablaClientes() {
        String tablaClientes = "CREATE TABLE IF NOT EXISTS clientes(\n"
                + "id_cliente TYNYINT(3) NOT NULL PRIMARY KEY,\n"
                + "persona_contacto VARCHAR(35) NOT NULL,\n"
                + "tlfn_contacto VARCHAR(20) NOT NULL,\n"
                + "cif VARCHAR(25) NOT NULL"
                + ")";
        try {
            miConexion = DriverManager.getConnection(url);
            Statement estado = miConexion.createStatement();
            estado.execute(tablaClientes);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void crearTablaProyecto() {
        String tablaProyecto = "CREATE TABLE IF NOT EXISTS proyecto(\n"
                                + "ident_proyecto TYNYINT(3) NOT NULL PRIMARY KEY,\n"
                                + "nombre_proyecto VARCHAR(70) NOT NULL,\n"
                                + "ubicacion_proyecto VARCHAR(35) NOT NULL,\n"
                                + "id_cliente TYNYINT(3) NOT NULL\n"
                                + ")";
        try {
            miConexion = DriverManager.getConnection(url);
            Statement estado = miConexion.createStatement();
            estado.execute(tablaProyecto);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void mostrarDepartamento() throws ClassNotFoundException {
        try {
            Class.forName("org.sqlite.JDBC");
            miConexion = DriverManager.getConnection(url);
            Statement estado = miConexion.createStatement();

            String query = "SELECT * FROM departamento";
            ResultSet resultadosDep = estado.executeQuery(query);
            int numeroRegistro = 1;

            while (resultadosDep.next()) {
                System.out.println("\n" + "|---------------------------------------------------------------------|"
                        + "\n" + " !CREACIÓN DE REGISTRO EN LA TABLA DEPARTAMENTOS, REGISTRO Nº = " + numeroRegistro + "¡" 
                        + "\n" + " Identificador de sección departamento: " + resultadosDep.getInt("id_seccion")
                        + "\n" + " Nombre de la sección: " + resultadosDep.getString("nombre_sec")
                        + "\n" + " Ubicación del departamento: " + resultadosDep.getString("ubicacion")
                        + "\n" + "|---------------------------------------------------------------------|");
                        numeroRegistro++;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void mostrarCliente() throws ClassNotFoundException {
        try {
            Class.forName("org.sqlite.JDBC");
            miConexion = DriverManager.getConnection(url);
            Statement estado = miConexion.createStatement();

            String query = "SELECT * FROM clientes";
            ResultSet resultadosClie = estado.executeQuery(query);
            int  numeroRegistro = 1;

            while (resultadosClie.next()) {
                System.out.println("\n" + "|---------------------------------------------------------------------|"
                        + "\n" + " !CREACIÓN DE REGISTRO EN LA TABLA CLIENTES, REGISTRO Nº = " + numeroRegistro + "¡" 
                        + "\n" + " Nombre del cliente: " + resultadosClie.getInt("id_cliente")
                        + "\n" + " Persona de contacto: " + resultadosClie.getString("persona_contacto")
                        + "\n" + " Teléfono de contacto: " + resultadosClie.getString("tlfn_contacto")
                        + "\n" + " CIF: " + resultadosClie.getString("cif")
                        + "\n" + "|---------------------------------------------------------------------|");
                        numeroRegistro++;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void mostrarEmpleado() throws ClassNotFoundException {

        try {
            Class.forName("org.sqlite.JDBC");
            miConexion = DriverManager.getConnection(url);
            Statement estado = miConexion.createStatement();

            String query = "SELECT * FROM empleados";
            ResultSet resultadosEmp = estado.executeQuery(query);
            int numeroRegistro = 1;

            while (resultadosEmp.next()) {
                System.out.println("\n" + "|---------------------------------------------------------------------|"
                        + "\n" + " !CREACIÓN DE REGISTRO EN LA TABLA EMPLEADOS, REGISTRO Nº = " + numeroRegistro + " ¡" 
                        + "\n" + " Identificador departamento trabajador: " + resultadosEmp.getString("id_departamento")
                        + "\n" + " Identficador proyecto trabajador: " + resultadosEmp.getString("id_proyecto")
                        + "\n" + " Nombre del trabajador: " + resultadosEmp.getString("nombre")
                        + "\n" + " Apellidos del trabajador: " + resultadosEmp.getString("apellidos")
                        + "\n" + " Dni del trabajador: " + resultadosEmp.getString("dni")
                        + "\n" + " Salario percibido por parte del trabajador: " + resultadosEmp.getString("salario") + " Euros."
                        + "\n" + "|---------------------------------------------------------------------|");
                        numeroRegistro++;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void mostrarProyecto() throws ClassNotFoundException {
        try {
            Class.forName("org.sqlite.JDBC");
            miConexion = DriverManager.getConnection(url);
            Statement estado = miConexion.createStatement();

            String query = "SELECT * FROM proyecto";
            ResultSet resultadosPro = estado.executeQuery(query);
            int numeroRegistro = 1;

            while(resultadosPro.next()){
                System.out.println("\n" + "|---------------------------------------------------------------------|"
                + "\n" + " !CREACIÓN DE REGISTRO EN LA TABLA PROYECTOS, REGISTRO Nº = " + numeroRegistro + "¡" 
                + "\n" + " Identificador del proyecto: " + resultadosPro.getString("ident_proyecto")
                + "\n" + " Nombre del proyecto: " + resultadosPro.getString("nombre_proyecto")
                + "\n" + " Ubicación del proyecto: " + resultadosPro.getString("ubicacion_proyecto")
                + "\n" + " Identificador del cliente de proyecto: " + resultadosPro.getString("id_cliente")
                + "\n" + "|---------------------------------------------------------------------|");
                numeroRegistro++;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void crearDepartamento(int id_seccion, String nombreSeccion, String Pubicacion) {
        String registroDepartamento = "INSERT INTO departamento(id_seccion,nombre_sec,ubicacion) VALUES(?, ?, ?)";
        try {
            PreparedStatement pstm = miConexion.prepareStatement(registroDepartamento);
            pstm.setInt(1, id_seccion);
            pstm.setString(2, nombreSeccion);
            pstm.setString(3, Pubicacion);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void crearEmpleado(int Pid_departamento, int id_proyecto, String Pnombre, String Papellido,
            String Pdni, float Psalario) {
        String registroEmpleado = "INSERT INTO empleados(id_departamento,id_proyecto,nombre,apellidos,dni,salario) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstm = miConexion.prepareStatement(registroEmpleado);
            pstm.setInt(1, Pid_departamento);
            pstm.setInt(2, id_proyecto);
            pstm.setString(3, Pnombre);
            pstm.setString(4, Papellido);
            pstm.setString(5, Pdni);
            pstm.setDouble(6, Psalario);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void crearCliente(int Pid_cliente, String Ppersona_contacto, String Ptelefono, String Pcif) {
        String registroCliente = "INSERT INTO clientes(id_cliente,persona_contacto,tlfn_contacto,cif) VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement pstm = miConexion.prepareStatement(registroCliente);
            pstm.setInt(1, Pid_cliente);
            pstm.setString(2, Ppersona_contacto);
            pstm.setString(3, Ptelefono);
            pstm.setString(4, Pcif);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void crearProyecto(int Pidentificador, String Pnombre_proyecto, String Pubicacion, int Pid_cliente) {
        String registroProyecto = "INSERT INTO proyecto(ident_proyecto,nombre_proyecto,ubicacion_proyecto,id_cliente) VALUES(?, ?, ?, ?)";
            try {
                PreparedStatement pstm = miConexion.prepareStatement(registroProyecto);
                pstm.setInt(1, Pidentificador);
                pstm.setString(2, Pnombre_proyecto);
                pstm.setString(3, Pubicacion);
                pstm.setInt(4, Pid_cliente);
                pstm.executeUpdate();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // CONEXIÓN Y MANTENIMIENTO DE LA BASE DE DATOS DE LA PRÁCTICA.
        crearBD("practica1.db");

        // 1.CREACIÓN DE LAS TABLAS DE LA PRÁCTICA MEDIANTE FUNCIONES (DEPARTAMENTO, EMPLEADOS, CLINTES, PROYECTOS).
        crearTablaDepartamento();
        crearTablaEmpleado();
        crearTablaClientes();
        crearTablaProyecto();

        // 2.INSERCIÓN DE REGISTROS EN LAS TABLAS, insertarRegistro() executeUpdate();.
        // *LOS REGISTROS LOS COMENTE POR QUE YA ESTAN EN LA TABLA DEPARTAMENTO*.
        // 2.1 DATOS TABLA DEPARTAMENTO.
        //crearDepartamento(1, "PRODUCCIÓN", "ALCAÑIZ");
        //crearDepartamento(2, "MANTENIMIENTO", "MONDRAGÓN");
        //crearDepartamento(3, "INVESTIGACIÓN", "ZARAGOZA");

        // 2.2 DATOS TABLA EMPLEADOS.
        //crearEmpleado(1, 10, "MARIO", "LOPEZ", "Z2254584T", 18000);
        //crearEmpleado(2, 20, "AMADO", "CARRILO", "AV478512", 99000);
        //crearEmpleado(3, 30, "GERVONTA", "DAVIS", "X478512Y", 55000);

        // 2.3 DATOS TABLA CLIENTES.
        //crearCliente(10, "COLDMAN S.A", "+34 616 78 95 11", "A54236874");
        //crearCliente(20, "ALCAMPO S.A", "+34 610 87 59 01", "X12336874");
        //crearCliente(30, "TELEPIZZA S.A", "+34 611 88 99 13", "M54236555");

        // 2.4 DATOS TABLA PROYECTOS.
        //crearProyecto(10, "INSTALACIONES PROFESIONALES FRIGORÍFICAS", "ZARAGOZA", 10);
        //crearProyecto(20, "COMERCIALIZACIÓN DE PRODUCTOS KETO", "BARCELONA", 20);
        //crearProyecto(30, "INGENIERIA DE ALIMENTOS VEGETARIANOS", "MADRID", 30);

        // 3.IMPRESIÓN DE REGISTROS DE LAS TABLAS MEDIANTE FUNCIONES, Imprimir registros. executeQuery();.
        mostrarDepartamento();
        mostrarEmpleado();
        mostrarCliente();
        mostrarProyecto();

        // eliminarRegistro() executeUpdate()
        // actualizarRegistro() executeUpdate()
    }
}