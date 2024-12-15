/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelosDaos;

import consultasBD.consultasAsignatura;
import modelosAcademia.Asignatura;
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
 * @author lfelipeh
 */
public class AsignaturaDao implements IDao<Asignatura, Integer> {
    
      //Declaración de variable para preparar las consultas.
    private Connection miConexion;

    //Declaración de variable para insertar valores a consultas.
    private PreparedStatement preConsulta;

    //Devuelve true si se ejecutó correctamente y false si algo falló
    private boolean operacionRealizada = false;

    //Objeto que servirá para almacenar información al buscar un registro.
    private Asignatura asignatura;

    //Lista de registros
    private List<Asignatura> asignaturas;

    public consultasAsignatura bdConsultas;
    
    public AsignaturaDao() throws ClassNotFoundException {
        miConexion = conexionBD.getInstance().getConnection();
        asignatura = new Asignatura();
        asignaturas = new ArrayList();
    }

    @Override
    public boolean crearRegistro(Asignatura model) {
        
         try {
            preConsulta = miConexion.prepareStatement(consultasAsignatura.INSERTAR.getConsultaAsignatura());
            preConsulta.setInt(1, model.getCodigo_asignatura());
            preConsulta.setString(2, model.getNombre_asignatura());
            preConsulta.setInt(3, model.getHoras_semanales());
            preConsulta.setDouble(4, model.getNota_alumno());
            preConsulta.setString(5, model.getReporte_incidencia());
          
            //Mostrar la consulta completa en pantalla
            System.out.println(preConsulta);

            if (preConsulta.executeUpdate() > 0) {
                operacionRealizada = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AsignaturaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return operacionRealizada;
    }

    @Override
    public Asignatura leerRegistro(Integer idModel) {
        
         try {
            preConsulta = miConexion.prepareStatement(consultasAsignatura.GENERAL.getConsultaAsignatura());
            preConsulta.setInt(1, idModel);
            ResultSet datosAsignatura = preConsulta.executeQuery();

            if (datosAsignatura.next()) {
                asignatura.setCodigo_asignatura(datosAsignatura.getInt("codigo_asignatura"));
                asignatura.setNombre_asignatura(datosAsignatura.getString("nombre_asignatura"));
                asignatura.setHoras_semanales(datosAsignatura.getInt("horas_semanales"));
                asignatura.setNota_alumno(datosAsignatura.getDouble("nota_alumno"));
                asignatura.setReporte_incidencia(datosAsignatura.getString("reporte_incidencia"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AsignaturaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return asignatura;
    }

    @Override
    public boolean actualizarRegistro(Asignatura model, Integer idModel) {
        
          try {
            preConsulta = miConexion.prepareStatement(consultasAsignatura.ACTUALIZAR.getConsultaAsignatura());
            preConsulta.setString(1, model.getNombre_asignatura());
            preConsulta.setInt(2, model.getHoras_semanales());
            preConsulta.setDouble(3, model.getNota_alumno());
            preConsulta.setString(4, model.getReporte_incidencia());
            preConsulta.setInt(5, idModel);         

            if (preConsulta.executeUpdate() > 0) {
                operacionRealizada = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AsignaturaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return operacionRealizada;
    }

    @Override
    public boolean borrarRegistro(Integer idModel) {
        
          try {
            preConsulta = miConexion.prepareStatement(consultasAsignatura.ELIMINAR.getConsultaAsignatura());
            preConsulta.setInt(1, idModel);

            if (preConsulta.executeUpdate() > 0) {
                operacionRealizada = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AsignaturaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return operacionRealizada;
    }

    @Override
    public List<Asignatura> leerRegistrosBD() {
        
        
        try {
            preConsulta = miConexion.prepareStatement(consultasAsignatura.GENERAL.getConsultaAsignatura());
            ResultSet datosAsignatura = preConsulta.executeQuery();
            
            while(datosAsignatura.next()){
                asignaturas.add(new Asignatura(datosAsignatura.getInt("codigo_asignatura"), datosAsignatura.getString("nombre_asignatura"), datosAsignatura.getInt("horas_semanales"), datosAsignatura.getDouble("nota_alumno"), datosAsignatura.getString("reporte_incidencia")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AsignaturaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return asignaturas;
    }
    
}
