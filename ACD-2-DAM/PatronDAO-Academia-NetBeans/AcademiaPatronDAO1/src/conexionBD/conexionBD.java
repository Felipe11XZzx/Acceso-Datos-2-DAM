package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexionBD {

    private static conexionBD instanciaConexion;
    private Connection miConexion;

    private final String urlBD = "jdbc:hsqldb:file:/home/lfelipeh/Documentos/AD2-DAM/NetBeansProjects/AcademiaPatronDAO1/mydb";
    private final String nameUser = "Felipe";
    private final String passwordUser = "estrullaizo";

    // Constructor privado para Singleton
    private conexionBD() {
        try {
            // Establecer la conexión
            miConexion = DriverManager.getConnection(urlBD, nameUser, passwordUser);
            System.out.println("\nConexión establecida exitosamente.");
        } catch (SQLException e) {
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, "Error en la conexión a la base de datos: ", e);
            throw new RuntimeException("Error al conectar a la base de datos.", e);
        }
    }

    // Método para obtener la instancia (Singleton seguro)
    public static synchronized conexionBD getInstance() {
        if (instanciaConexion == null) {
            instanciaConexion = new conexionBD();
        }
        return instanciaConexion;
    }

    // Método para obtener la conexión
    public Connection getConnection() {
        return miConexion;
    }

    // Método para cerrar la conexión
    public void closeConnection() {
        try {
            if (miConexion != null && !miConexion.isClosed()) {
                miConexion.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, "Error al cerrar la conexión: ", e);
        }
    }
}
