/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogicaAcademia;

import java.util.ArrayList;
import java.util.List;
import modelosAcademia.Alumno;

/**
 *
 * @author lfelipeh
 */
public class logicaAlumnos {
        
    private static List<Alumno> listaAlumnos = new ArrayList<>();
    
    public static void agregarAlumno(Alumno Palumno){
        listaAlumnos.add(Palumno);
    }
    
    public static List<Alumno> getListaClientes(){
        return listaAlumnos;
    }
}