/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelosDaos;

import conexionBD.conexionBD;
import consultasBD.consultasMatricula;
import consultasBD.consultasProfesor;
import interfaceIDao.IDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelosAcademia.Matriculas;
import modelosAcademia.Profesor;

/**
 *
 * @author estudiante
 */


public class MatriculaDao implements IDao<Matriculas, Integer>  {
    
       //Declaración de variable para preparar las consultas.
    private Connection miConexion;

    //Declaración de variable para insertar valores a consultas.
    private PreparedStatement preConsulta;

    //Devuelve true si se ejecutó correctamente y false si algo falló
    private boolean operacionRealizada = false;

    //Objeto que servirá para almacenar información al buscar un registro.
    private Matriculas matricula;

    //Lista de registros
    private List<Matriculas> matriculas;

    public consultasMatricula bdConsultas;

    // PARA CONSULTAS SIN PARAMETROS O CREADAS STATEMENT "SELECT * FROM DEPT WHERE ID=5", CONSULTAS SENCILLAS STATEMENT Y LUEGO EXECUTEQUERY();
    // PARA CONSULTAS QUE LES TENEMOS QUE PASAR PARAMENTROS PREPAREDSTATEMENT Y LUEGO EXECUTEUPDATE();
    
    public MatriculaDao() throws ClassNotFoundException {
        miConexion = conexionBD.getInstance().getConnection();
        matricula = new Matriculas();
        matriculas = new ArrayList();
    }
    
     @Override
    public boolean crearRegistro(Matriculas model) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        try {
            preConsulta = miConexion.prepareStatement(consultasMatricula.INSERTAR.getConsultaMatricula());
            preConsulta.setInt(1, model.getId_matricula());
            preConsulta.setString(2, model.getNombre_alumno());
            preConsulta.setString(3, model.getNombre_asignatura());
            preConsulta.setInt(4, model.getHoras_asignatura());

            //Mostrar la consulta completa en pantalla
            System.out.println(preConsulta);

            if (preConsulta.executeUpdate() > 0) {
                operacionRealizada = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(MatriculaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return operacionRealizada;
    }

    @Override
    public Matriculas leerRegistro(Integer idModel) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        try {
            preConsulta = miConexion.prepareStatement(consultasProfesor.GENERAL.getConsultaProfesor());
            preConsulta.setInt(1, idModel);
            ResultSet datosMatricula = preConsulta.executeQuery();

            if (datosMatricula.next()) {
                matricula.setId_matricula(datosMatricula.getInt("id_matricula"));
                matricula.setNombre_alumno(datosMatricula.getString("nombre_alumno"));
                matricula.setNombre_asignatura(datosMatricula.getString("nombre_asignatura"));
                matricula.setHoras_asignatura(datosMatricula.getInt("horas_asignatura"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MatriculaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return matricula;
    }

    @Override
    public boolean actualizarRegistro(Matriculas model, Integer idModel) {
        try {
            preConsulta = miConexion.prepareStatement(consultasMatricula.ACTUALIZAR.getConsultaMatricula());
            preConsulta.setString(1, model.getNombre_alumno());
            preConsulta.setString(2, model.getNombre_asignatura());
            preConsulta.setInt(3, model.getHoras_asignatura());
            preConsulta.setInt(4, idModel);

           
            if (preConsulta.executeUpdate() > 0) {
                operacionRealizada = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(MatriculaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return operacionRealizada;
    }

    @Override
    public boolean borrarRegistro(Integer idModel) {

        try {
            preConsulta = miConexion.prepareStatement(consultasMatricula.ELIMINAR.getConsultaMatricula());
            preConsulta.setInt(1, idModel);

            if (preConsulta.executeUpdate() > 0) {
                operacionRealizada = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(MatriculaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return operacionRealizada;
    }

    @Override
    public List<Matriculas> leerRegistrosBD() {

        try {
            preConsulta = miConexion.prepareStatement(consultasMatricula.GENERAL.getConsultaMatricula());
            ResultSet datosMatricula = preConsulta.executeQuery();
            
            while(datosMatricula.next()){
                matriculas.add(new Matriculas(datosMatricula.getInt("id_matricula"), datosMatricula.getString("nombre_alumno"), datosMatricula.getString("nombre_asignatura"), datosMatricula.getInt("horas_asignatura")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MatriculaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return matriculas;
    }
    
}
