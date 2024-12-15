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
import Models.clienteOB;

public class clienteDao implements IDao<clienteOB, Integer> {

    // Declaración de variable para preparar las consultas
    private Connection miConexion;
    // Declaración de variable para insertar valores a consultas
    private PreparedStatement preConsultas;
    // Devuelve true si se ejecutó correctamente y false si algo falló
    private boolean estaRealizada = false;
    // Objeto que servirá para almacenar información al buscar un registro
    private clienteOB miCliente;
    // Lista de registros
    private List<clienteOB> listaClientes;

    // Arreglo con las consultas que se usarán para la tabla jugadores
    private final String[] misOperaciones = {
            "INSERT INTO clientes (id_cliente, persona_contacto, tlfn_contacto, cif) VALUES(?, ?, ?, ?)",
            "SELECT * FROM clientes WHERE id_cliente = ?;",
            "UPDATE clientes SET persona_contacto = ?, tlfn_contacto = ?, cif = ? WHERE (id_cliente = ?)",
            "DELETE FROM clientes WHERE (id_cliente = ?);",
            "SELECT * FROM clientes;"
    };

    // Constructor de la clase en donde se inicializarán las variables previamente
    // declaradas
    public clienteDao() throws ClassNotFoundException {
        miConexion = conexionBD.getInstance().getConnection();
        miCliente = new clienteOB();
        listaClientes = new ArrayList<>();
    }

    @Override
    public boolean crearRegistro(clienteOB obj) {
        try {
            preConsultas = miConexion.prepareStatement(misOperaciones[0]);
            preConsultas.setInt(1, obj.getId_Cliente());
            preConsultas.setString(2, obj.getPersona_Contacto());
            preConsultas.setString(3, obj.getTlfn_Contacto());
            preConsultas.setString(4, obj.getCif());

            // Mostrar la consulta completa en pantalla
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -"
                    + "\n" + "SE HA CREADO CORRECTAMENTE EL REGISTRO EN LA TABLA CLIENTE."
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
    public clienteOB leerRegistro(Integer id_modelo) {
        try {
            preConsultas = miConexion.prepareStatement(misOperaciones[1]);
            preConsultas.setInt(1, id_modelo);
            ResultSet misDatos = preConsultas.executeQuery();

            if (misDatos.next()) {
                miCliente.setId_Cliente(misDatos.getInt("id_cliente"));
                miCliente.setPersona_Contacto(misDatos.getString("persona_contacto"));
                miCliente.setTlfn_Contacto(misDatos.getString("tlfn_contacto"));
                miCliente.setCif(misDatos.getString("cif"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(proyectoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return miCliente;
    }

    @Override
    public boolean actualizarRegistro(clienteOB modelo, Integer idModelo) {
        try {
            preConsultas = miConexion.prepareStatement(misOperaciones[2]);
            preConsultas.setString(1, modelo.getPersona_Contacto());
            preConsultas.setString(2, modelo.getTlfn_Contacto());
            preConsultas.setString(3, modelo.getCif());
            preConsultas.setInt(4, modelo.getId_Cliente());

            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -"
                    + "\n" + "SE HA ACTUALIZADO CORRECTAMENTE EL REGISTRO EN LA TABLA PROYECTO."
                    + "\n" + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

            eliminarRegistro(modelo.getId_Cliente());

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
    public List<clienteOB> leerDatos() {
        try {
            preConsultas = miConexion.prepareStatement(misOperaciones[4]);
            ResultSet misDatos = preConsultas.executeQuery();

            while (misDatos.next()) {
                listaClientes.add(new clienteOB(misDatos.getInt("id_cliente"), misDatos.getString("persona_contacto"),
                        misDatos.getString("tlfn_contacto"), misDatos.getString("cif")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(proyectoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaClientes;
    }
}