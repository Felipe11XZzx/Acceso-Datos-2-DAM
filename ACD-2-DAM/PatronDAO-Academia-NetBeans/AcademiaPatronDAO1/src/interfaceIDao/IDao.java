/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaceIDao;
import java.util.List;

//TECNOLOGIA SQL QUE DEBO USAR ES  HSQLDB.

/**
 *
 * @author estudiante
 *  @param <T> Clase que corresponde al modelo del dao, (Tipo del objeto: "Persona.java", "Coche.java").
 *  @param <V> Tipo de dato del id del modelo, (String, int, double).
 */
public interface IDao<T, V> {
    
    public boolean crearRegistro(T model);
    
    public T leerRegistro(V idModel);
    
    public boolean actualizarRegistro(T model, V idModel);
    
    public boolean borrarRegistro(V idModel);
    
    public List<T> leerRegistrosBD();
    
}