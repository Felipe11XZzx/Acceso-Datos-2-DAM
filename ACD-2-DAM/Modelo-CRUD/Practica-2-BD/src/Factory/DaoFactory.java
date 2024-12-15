package Factory;
import Daos.clienteDao;
import Daos.proyectoDao;
import Interfaces.IDao;

public class DaoFactory {

    public enum DaoType{
        proyectoOB, clienteOB;
    }

    /**
     * @param daoType recibe el tipo de dao que quieres crear. (EN MI CASO LAS TABLAS DE LA PRÁCTICA NÚMERO 3: DEPARTAMENTO, EMPLEADO, CLIENTE, PROYECTO.) |     
     * @return una instancia del dao que indicamos
     * @throws ClassNotFoundException 
    */

    @SuppressWarnings("rawtypes")
    public static IDao getDao (DaoType tipoDao) throws ClassNotFoundException{
        IDao Objetodao = null;
        switch (tipoDao){
            case proyectoOB:
                Objetodao = new proyectoDao();
                break;
            
            case clienteOB:
                Objetodao = new clienteDao();
                break;
        }
        return Objetodao;
    }
}
