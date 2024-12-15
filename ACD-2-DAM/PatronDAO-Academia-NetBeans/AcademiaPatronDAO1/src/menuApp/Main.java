/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menuApp;

import GuiAcademia.RegistroAlumnos;
import conexionBD.conexionBD;
import tablasAcademia.AcademiaHSQLDB;

/**
 *
 * @author lfelipeh
 */
public class Main {
    
      public static void main(String[] args) throws ClassNotFoundException {
        try {
            // Obtener la instancia de la conexión
            conexionBD conexion = conexionBD.getInstance();
            // Crear la base de datos y las tablas
            AcademiaHSQLDB academia = new AcademiaHSQLDB();
            academia.crearTablas();  // Llamar el método para crear las tablas
            // Cerrar la conexión
            conexion.closeConnection();
        } catch (Exception e) {
        }
        
        RegistroAlumnos pantallaAlumnos = new RegistroAlumnos();
        pantallaAlumnos.setVisible(true);
    }
}
