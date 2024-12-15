package ConexionesBD.ConexionBD.src;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;
import java.sql.Statement; 
import java.sql.ResultSet; 

public class primeraConexion {

    public static void main(String[] args) throws ClassNotFoundException{

        // EL PROPOSITO DE ESTA PRÁCTICA ERA PROBAR LA CREACIÓN DE TABLAS CON SQLITE DESDE LA TERMINALD DE VSCODE.
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:miTabla.db");
            Statement instruccion = conexion.createStatement();

            String consulta = "SELECT * FROM departamentos";
            ResultSet resultados = instruccion.executeQuery(consulta);
            System.out.println("Listado de los departamentos: ");

            while (resultados.next()) {
                System.out.println("Número de departamento: " + resultados.getString("dpto_no")
                    + "\n" + "Nombre de departamento: " + resultados.getString("dnombre")
                    + "\n" + "Localización de la empresa: " + resultados.getString("loc"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
