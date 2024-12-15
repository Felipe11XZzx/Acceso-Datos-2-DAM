/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factoryDAO;

import modelosDaos.AlumnoDao;
import interfaceIDao.IDao;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lfelipeh
 */
public class DaoFactory {
    
    public enum Daotype {
        ALUMNO
    }
    
    public static IDao getDaoType (Daotype PDao) {
    
        IDao dao = null;
        switch(PDao) {
            case ALUMNO:
            {
                try {
                    dao = new AlumnoDao();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DaoFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

        }
        
        return dao;
    }
}
