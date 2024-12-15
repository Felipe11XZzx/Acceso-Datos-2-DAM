/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelosDaos;
import consultasBD.consultasProfesor;
import modelosAcademia.Profesor;
import interfaceIDao.IDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import conexionBD.conexionBD;

/**
 *
 * @author estudiante
 */
public class ProfesorDao implements IDao<Profesor, Integer> {
    
    //Declaración de variable para preparar las consultas.
    private Connection miConexion;

    //Declaración de variable para insertar valores a consultas.
    private PreparedStatement preConsulta;

    //Devuelve true si se ejecutó correctamente y false si algo falló
    private boolean operacionRealizada = false;

    //Objeto que servirá para almacenar información al buscar un registro.
    private Profesor profesor;

    //Lista de registros
    private List<Profesor> profesores;

    public consultasProfesor bdConsultas;

    // PARA CONSULTAS SIN PARAMETROS O CREADAS STATEMENT "SELECT * FROM DEPT WHERE ID=5", CONSULTAS SENCILLAS STATEMENT Y LUEGO EXECUTEQUERY();
    // PARA CONSULTAS QUE LES TENEMOS QUE PASAR PARAMENTROS PREPAREDSTATEMENT Y LUEGO EXECUTEUPDATE();
    public ProfesorDao() throws ClassNotFoundException {
        miConexion = conexionBD.getInstance().getConnection();
        profesor = new Profesor();
        profesores = new ArrayList();
    }

    @Override
    public boolean crearRegistro(Profesor model) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        try {
            preConsulta = miConexion.prepareStatement(consultasProfesor.INSERTAR.getConsultaProfesor());
            preConsulta.setInt(1, model.getId_profesor());
            preConsulta.setString(2, model.getDni_profesor());
            preConsulta.setString(3, model.getNombre_profesor());
            preConsulta.setString(4, model.getApellido_profesor());
            preConsulta.setString(5, model.getDireccion_profesor());
            preConsulta.setString(6, model.getFecha_nacimiento());
            preConsulta.setInt(7, model.getCodPostal_profesor());
            preConsulta.setString(8, model.getTelefono_profesor());

            //Mostrar la consulta completa en pantalla
            System.out.println(preConsulta);

            if (preConsulta.executeUpdate() > 0) {
                operacionRealizada = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfesorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return operacionRealizada;
    }

    @Override
    public Profesor leerRegistro(Integer idModel) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        try {
            preConsulta = miConexion.prepareStatement(consultasProfesor.GENERAL.getConsultaProfesor());
            preConsulta.setInt(1, idModel);
            ResultSet datosProfesor = preConsulta.executeQuery();

            if (datosProfesor.next()) {
                profesor.setDni_profesor(datosProfesor.getString("dni_profesor"));
                profesor.setNombre_profesor(datosProfesor.getString("nombre_profesor"));
                profesor.setApellido_profesor(datosProfesor.getString("apellido_profesor"));
                profesor.setDireccion_profesor(datosProfesor.getString("direccion_profesor"));
                profesor.setFecha_nacimiento(datosProfesor.getString("fecha_nacimiento"));
                profesor.setCodPostal_profesor(datosProfesor.getInt("codPostal_profesor"));
                profesor.setTelefono_profesor(datosProfesor.getString("telefono_profesor"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfesorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return profesor;
    }

    @Override
    public boolean actualizarRegistro(Profesor model, Integer idModel) {
        try {
            preConsulta = miConexion.prepareStatement(consultasProfesor.ACTUALIZAR.getConsultaProfesor());
            preConsulta.setString(1, model.getDni_profesor());
            preConsulta.setString(2, model.getNombre_profesor());
            preConsulta.setString(3, model.getApellido_profesor());
            preConsulta.setString(4, model.getDireccion_profesor());
            preConsulta.setString(5, model.getFecha_nacimiento());
            preConsulta.setInt(6, model.getCodPostal_profesor());
            preConsulta.setString(7, model.getTelefono_profesor());
            preConsulta.setInt(8, idModel);

            if (preConsulta.executeUpdate() > 0) {
                operacionRealizada = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfesorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return operacionRealizada;
    }

    @Override
    public boolean borrarRegistro(Integer idModel) {

        try {
            preConsulta = miConexion.prepareStatement(consultasProfesor.ELIMINAR.getConsultaProfesor());
            preConsulta.setInt(1, idModel);

            if (preConsulta.executeUpdate() > 0) {
                operacionRealizada = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfesorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return operacionRealizada;
    }

    @Override
    public List<Profesor> leerRegistrosBD() {

        try {
            preConsulta = miConexion.prepareStatement(consultasProfesor.GENERAL.getConsultaProfesor());
            ResultSet datosProfesor = preConsulta.executeQuery();
            
            while(datosProfesor.next()){
                profesores.add(new Profesor(datosProfesor.getInt("id_profesor"), datosProfesor.getString("dni_profesor"), datosProfesor.getString("nombre_profesor"), datosProfesor.getString("apellido_profesor"), datosProfesor.getString("direccion_profesor"), datosProfesor.getString("fecha_nacimiento"), datosProfesor.getInt("codPostal_profesor"), datosProfesor.getString("telefono_profesor")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfesorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return profesores;
    }
}
