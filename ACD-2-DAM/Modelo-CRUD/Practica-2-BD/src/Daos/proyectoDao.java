package Daos;

import java.lang.Integer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import ConectionBD.conexionBD;
import Interfaces.IDao;
import Models.proyectoOB;

public class proyectoDao implements IDao<proyectoOB, Integer> {

    // Declaración de variable para preparar las consultas
    private Connection miConexion;
    // Declaración de variable para insertar valores a consultas
    private PreparedStatement preConsultas;
    // Devuelve true si se ejecutó correctamente y false si algo falló
    private boolean estaRealizada = false;
    // Objeto que servirá para almacenar información al buscar un registro
    private proyectoOB miProyecto;
    // Lista de registros
    private List<proyectoOB> listaProyectos;

    // Arreglo con las consultas que se usarán para la tabla jugadores
    private final String[] misOperaciones = {
            "INSERT INTO proyecto (ident_proyecto, nombre_proyecto, ubicacion_proyecto, id_cliente) VALUES(?, ?, ?, ?)",
            "SELECT * FROM proyecto WHERE ident_proyecto = ?;",
            "UPDATE proyecto SET nombre_proyecto = ?, ubicacion_proyecto = ?, id_cliente = ? WHERE (ident_proyecto = ?)",
            "DELETE FROM proyecto WHERE (ident_proyecto = ?);",
            "SELECT * FROM proyecto;"
    };

    // Constructor de la clase en donde se inicializarán las variables previamente
    // declaradas
    public proyectoDao() throws ClassNotFoundException {
        miConexion = conexionBD.getInstance().getConnection();
        miProyecto = new proyectoOB();
        listaProyectos = new ArrayList<>();
    }

    @Override
    public boolean crearRegistro(proyectoOB obj) {
        try {
            preConsultas = miConexion.prepareStatement(misOperaciones[0]);
            preConsultas.setInt(1, obj.getIdProyecto());
            preConsultas.setString(2, obj.getNombreProyecto());
            preConsultas.setString(3, obj.getUbicacionProyecto());
            preConsultas.setInt(4, obj.getIdCliente());

            // Mostrar la consulta completa en pantalla
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -"
                    + "\n" + "SE HA CREADO CORRECTAMENTE EL REGISTRO EN LA TABLA PROYECTO."
                    + "\n" + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

            if (preConsultas.executeUpdate() > 0) {
                estaRealizada = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(proyectoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estaRealizada;
    }

    @Override
    public proyectoOB leerRegistro(Integer id_modelo) {
        try {
            preConsultas = miConexion.prepareStatement(misOperaciones[1]);
            preConsultas.setInt(1, id_modelo);
            ResultSet misDatos = preConsultas.executeQuery();

            if (misDatos.next()) {
                miProyecto.setIdProyecto(misDatos.getInt("ident_proyecto"));
                miProyecto.setNombreProyecto(misDatos.getString("nombre_proyecto"));
                miProyecto.setUbicacionProyecto(misDatos.getString("ubicacion_proyecto"));
                miProyecto.setIdCliente(misDatos.getInt("id_cliente"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(proyectoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return miProyecto;
    }

    @Override
    public boolean actualizarRegistro(proyectoOB modelo, Integer idModelo) {
        try {
            preConsultas = miConexion.prepareStatement(misOperaciones[2]);
            preConsultas.setString(1, modelo.getNombreProyecto());
            preConsultas.setString(2, modelo.getUbicacionProyecto());
            preConsultas.setInt(3, modelo.getIdCliente());
            preConsultas.setInt(4, modelo.getIdProyecto());

            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -"
                    + "\n" + "SE HA ACTUALIZADO CORRECTAMENTE EL REGISTRO EN LA TABLA PROYECTO."
                    + "\n" + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

            eliminarRegistro(modelo.getIdProyecto());

            if (preConsultas.executeUpdate() > 0) {
                estaRealizada = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(proyectoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estaRealizada;
    }

    @Override
    public boolean eliminarRegistro(Integer idModelo) {
        try {
            preConsultas = miConexion.prepareStatement(misOperaciones[3]);
            preConsultas.setInt(1, idModelo);

            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -"
                    + "\n" + "SE HA ELIMINADO CORRECTAMENTE EL REGISTRO EN LA TABLA PROYECTO."
                    + "\n" + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

            if (preConsultas.executeUpdate() > 0) {
                estaRealizada = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(proyectoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estaRealizada;
    }

    @Override
    public List<proyectoOB> leerDatos() {
        try {
            preConsultas = miConexion.prepareStatement(misOperaciones[4]);
            ResultSet misDatos = preConsultas.executeQuery();

            while (misDatos.next()) {
                listaProyectos
                        .add(new proyectoOB(misDatos.getInt("ident_proyecto"), misDatos.getString("nombre_proyecto"),
                                misDatos.getString("ubicacion_proyecto"), misDatos.getInt("id_cliente")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(proyectoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProyectos;
    }
}