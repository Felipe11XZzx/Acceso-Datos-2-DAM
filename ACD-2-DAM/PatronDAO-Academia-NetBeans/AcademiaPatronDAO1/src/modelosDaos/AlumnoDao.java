/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelosDaos;

import consultasBD.consultasAlumno;
import interfaceIDao.IDao;
import modelosAcademia.Alumno;
import java.util.List;
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
public class AlumnoDao implements IDao<Alumno, Integer> {

    //Declaración de variable para preparar las consultas.
    private Connection miConexion;

    //Declaración de variable para insertar valores a consultas.
    private PreparedStatement preConsulta;

    //Devuelve true si se ejecutó correctamente y false si algo falló
    private boolean operacionRealizada = false;

    //Objeto que servirá para almacenar información al buscar un registro.
    private Alumno alumno;

    //Lista de registros
    private List<Alumno> alumnos;

    public consultasAlumno bdConsultas;

    // PARA CONSULTAS SIN PARAMETROS O CREADAS STATEMENT "SELECT * FROM DEPT WHERE ID=5", CONSULTAS SENCILLAS STATEMENT Y LUEGO EXECUTEQUERY();
    // PARA CONSULTAS QUE LES TENEMOS QUE PASAR PARAMENTROS PREPAREDSTATEMENT Y LUEGO EXECUTEUPDATE();
    public AlumnoDao() throws ClassNotFoundException {
        miConexion = conexionBD.getInstance().getConnection();
        if (miConexion == null) {
            System.out.println("\nError: La conexión a la base de datos no se ha establecido.");
        } else {
            System.out.println("\nConexión establecida correctamente.");
        }
        alumno = new Alumno();

        alumnos = new ArrayList();
    }

    @Override
    public boolean crearRegistro(Alumno model) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        try {

            int registroCreado = 0;
            preConsulta = miConexion.prepareStatement(consultasAlumno.INSERTAR.getConsultaAlumno());
            preConsulta.setInt(1, model.getId_alumno());
            preConsulta.setString(2, model.getDni_alumno());
            preConsulta.setString(3, model.getNombre_alumno());
            preConsulta.setString(4, model.getApellido_alumno());
            preConsulta.setString(5, model.getDireccion_alumno());
            preConsulta.setString(6, model.getFecha_nacimiento());
            preConsulta.setInt(7, model.getCodPostal_alumno());
            preConsulta.setString(8, model.getTelefono_alumno());

            //Mostrar la consulta completa en pantalla
            System.out.println(preConsulta);

            if (preConsulta != null) {
                if (preConsulta.executeUpdate() > 0) {
                    operacionRealizada = true;
                    registroCreado++;
                    System.out.println("\nSe ha insertado esta cantidad de registros en la base de datos de Alumnos Itaca: " + registroCreado);
                }
            } else {
                System.out.println("\nLa consulta no se ha preparado correctamente.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return operacionRealizada;
    }

    @Override
    public Alumno leerRegistro(Integer idModel) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        try {
            preConsulta = miConexion.prepareStatement(consultasAlumno.GENERAL.getConsultaAlumno());
            preConsulta.setInt(1, idModel);
            ResultSet datosAlumnos = preConsulta.executeQuery();

            if (datosAlumnos.next()) {
                alumno.setDni_alumno(datosAlumnos.getString("dni_alumno"));
                alumno.setNombre_alumno(datosAlumnos.getString("nombre_alumno"));
                alumno.setApellido_alumno(datosAlumnos.getString("apellido_alumno"));
                alumno.setDireccion_alumno(datosAlumnos.getString("direccion_alumno"));
                alumno.setFecha_nacimiento(datosAlumnos.getString("fecha_nacimiento"));
                alumno.setCodPostal_alumno(datosAlumnos.getInt("codPostal_alumno"));
                alumno.setTelefono_alumno(datosAlumnos.getString("telefono_alumno"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumno;
    }

    @Override
    public boolean actualizarRegistro(Alumno model, Integer idModel) {
        try {
            int registroActualizado = 0;
            preConsulta = miConexion.prepareStatement(consultasAlumno.ACTUALIZAR.getConsultaAlumno());
            preConsulta.setString(1, model.getDni_alumno());
            preConsulta.setString(2, model.getNombre_alumno());
            preConsulta.setString(3, model.getApellido_alumno());
            preConsulta.setString(4, model.getDireccion_alumno());
            preConsulta.setString(5, model.getFecha_nacimiento());
            preConsulta.setInt(6, model.getCodPostal_alumno());
            preConsulta.setString(7, model.getTelefono_alumno());
            preConsulta.setInt(8, idModel);

            if (preConsulta.executeUpdate() > 0) {
                operacionRealizada = true;
                registroActualizado++;
                System.out.println("\nSe ha actualizado esta cantidad de registros en la base de datos de Alumnos Itaca: " + registroActualizado);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return operacionRealizada;
    }

    @Override
    public boolean borrarRegistro(Integer idModel) {

        try {
            int registroEliminado = 0;
            preConsulta = miConexion.prepareStatement(consultasAlumno.ELIMINAR.getConsultaAlumno());
            preConsulta.setInt(1, idModel);

            if (preConsulta.executeUpdate() > 0) {
                operacionRealizada = true;
                registroEliminado++;
                System.out.println("\n Se ha eliminado esta cantidad de registros en la base de datos de Alumnos Itaca: " + registroEliminado);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return operacionRealizada;
    }

    @Override
    public List<Alumno> leerRegistrosBD() {

        try {
            int registrosTotales = 0;
            preConsulta = miConexion.prepareStatement(consultasAlumno.GENERAL.getConsultaAlumno());
            ResultSet datosAlumno = preConsulta.executeQuery();

            while (datosAlumno.next()) {
                alumnos.add(new Alumno(datosAlumno.getInt("id_alumno"), datosAlumno.getString("dni_alumno"), datosAlumno.getString("nombre_alumno"), datosAlumno.getString("apellido_alumno"), datosAlumno.getString("direccion_alumno"), datosAlumno.getString("fecha_nacimiento"), datosAlumno.getInt("codPostal_alumno"), datosAlumno.getString("telefono_alumno")));
                registrosTotales++;
            }
            System.out.println("\n La base de datos del instituto Itaca, contiene este cantidad de alumnos: " + registrosTotales);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumnos;
    }
}
