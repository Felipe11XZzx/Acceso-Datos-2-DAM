package ConectionBD;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexionBD {

    // Instancia de la clase
    private static conexionBD instanciaConexion;

    // Variable para realizar la conexión
    private Connection miConexion;

    // Dirección y nombre de la bd conectarnos
    private final String url = "jdbc:sqlite:C:\\Users\\ortiz\\OneDrive\\Escritorio\\ACD-2-DAM\\Modelo-CRUD\\Practica-2-BD\\src\\practica3.db";

    // Nombre de usuario autorizado para conectarse
    private final String usuario = "felipe";

    // Contraseña para conectarnos
    private final String validacion = "estrullaizo";

    private conexionBD() throws ClassNotFoundException {
        try {
            Class.forName("org.sqlite.JDBC");
            miConexion = DriverManager.getConnection(url, usuario, validacion);
            Statement estado = miConexion.createStatement();
            System.out.println("\n" + "Statement de mi objeto proyecto: " + estado);
        } catch (SQLException ex) {
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            System.out.println("!SE HA REALIZADO CORRECTAMENTE LA CONEXIÓN CON LA BASE DE DATOS¡" + "\n");
        }
    }

    // Implementación del patrón singleton para acceder a una instancia única de la
    // clase
    public static conexionBD getInstance() throws ClassNotFoundException {
        if (instanciaConexion == null) {
            instanciaConexion = new conexionBD();
        }
        return instanciaConexion;
    }

    public Connection getConnection() {
        return miConexion;
    }

    public static void main(String[] args) {

    }
}