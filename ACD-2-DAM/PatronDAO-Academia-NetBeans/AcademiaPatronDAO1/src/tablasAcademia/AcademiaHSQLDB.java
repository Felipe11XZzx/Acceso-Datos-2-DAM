package tablasAcademia;

import conexionBD.conexionBD;  // Asegúrate de importar la clase correcta
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AcademiaHSQLDB {

    private Connection MiConexion;

    // Constructor que obtiene la conexión desde la clase conexionBD
    public AcademiaHSQLDB() throws ClassNotFoundException, SQLException {
        // Obtenemos la conexión desde la clase conexionBD
        MiConexion = conexionBD.getInstance().getConnection();
    }

    // Método para crear las tablas en la base de datos
    public void crearTablas() throws SQLException {

        Statement stmt = MiConexion.createStatement();
        String ALUMNO = "CREATE TABLE IF NOT EXISTS ALUMNO ("
                + "id_alumno INTEGER PRIMARY KEY, "
                + "dni_alumno VARCHAR(10) NOT NULL, "
                + "nombre_alumno VARCHAR(30) NOT NULL, "
                + "apellido_alumno VARCHAR(30) NOT NULL, "
                + "direccion_alumno VARCHAR(60) NOT NULL, "
                + "fecha_nacimiento VARCHAR(30) NOT NULL, "
                + "codPostal_alumno INTEGER NOT NULL, "
                + "telefono_alumno VARCHAR(15) NOT NULL)";
        stmt.executeUpdate(ALUMNO);

        String ASIGNATURA = "CREATE TABLE IF NOT EXISTS ASIGNATURA ("
                + "codigo_asignatura INTEGER PRIMARY KEY, "
                + "nombre_asignatura VARCHAR(25) NOT NULL, "
                + "horas_semanales INTEGER NOT NULL, "
                + "nota_alumno INTEGER NOT NULL, "
                + "reporte_incidencia VARCHAR(500) NOT NULL)";
        stmt.executeUpdate(ASIGNATURA);

        String MATRICULA = "CREATE TABLE IF NOT EXISTS MATRICULA ("
                + "id_matricula INTEGER PRIMARY KEY, "
                + "nombre_alumno VARCHAR(25) NOT NULL, "
                + "nombre_asignatura INTEGER NOT NULL, "
                + "horas_asignatura INTEGER NOT NULL)";
        stmt.executeUpdate(MATRICULA);

        String PROFESOR = "CREATE TABLE IF NOT EXISTS PROFESOR ("
                + "id_profesor INTEGER PRIMARY KEY, "
                + "dni_profesor VARCHAR(10) NOT NULL, "
                + "nombre_profesor VARCHAR(30) NOT NULL, "
                + "apellido_profesor VARCHAR(30) NOT NULL, "
                + "direccion_profesor VARCHAR(60) NOT NULL, "
                + "fecha_nacimiento VARCHAR(30) NOT NULL, "
                + "codPostal_profesor INTEGER NOT NULL, "
                + "telefono_profesor VARCHAR(15) NOT NULL)";
        stmt.executeUpdate(PROFESOR);

        System.out.println("Las tablas han sido creadas correctamente.");

        // Intentamos ejecutar las instrucciones SQL usando un Statement
    }
}
