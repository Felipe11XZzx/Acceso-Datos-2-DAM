package Interfaces;
import java.util.List;

/**
 * @param <T> Clase que corresponde al modelo del dao
 * @param <V> Tipo de dato del id del modelo
 */

    public interface IDao<T, V> {

    // DEVUELVE TRUE SI SE CREA EL REGISTRO EN LA TABLA.
    public boolean crearRegistro(T modelo);

    // IDMODELO ES LA CLAVE DEL REGISTRO, T ES QUE NOS DEVUELVA ESE REGISTRO SI SE ENCUENTRA.
    public T leerRegistro(V idModelo);

    // TMODEL ES EL OBJETO O MOLDE QUE USAREMOS (TABLA SQLITE), IDMODEL CLAVE DEL REGISTRO Y NOS DEVUELVE UN BOOLEAN DEPENDIEDO EL RESULTADO.
    public boolean actualizarRegistro(T modelo, V idModelo);

    // IDMODEL CLAVE DEL REGISTRO A ELIMINAR PARA POSTERIORMENTE ACTUALIZAR LA QUERY.
    public boolean eliminarRegistro(V idModelo);

    // NO DEVOLVERA LA LISTA CON LOS REGISTROS Y DATOS DE LA ESTRUCTURA.
    public List<T> leerDatos();
   
}
