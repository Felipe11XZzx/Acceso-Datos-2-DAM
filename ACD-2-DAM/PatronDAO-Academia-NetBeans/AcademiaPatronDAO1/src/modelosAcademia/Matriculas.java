/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelosAcademia;

/**
 *
 * @author estudiante
 */
public class Matriculas {
    
    private int id_matricula;
    private String nombre_alumno;
    private String nombre_asignatura;
    private int horas_asignatura;
    
    public Matriculas() {}

    public Matriculas(int id_matricula, String nombre_alumno, String nombre_asignatura, int horas_asignatura) {
        this.id_matricula = id_matricula;
        this.nombre_alumno = nombre_alumno;
        this.nombre_asignatura = nombre_asignatura;
        this.horas_asignatura = horas_asignatura;
    }

    public int getId_matricula() {
        return id_matricula;
    }

    public void setId_matricula(int id_matricula) {
        this.id_matricula = id_matricula;
    }

    public String getNombre_alumno() {
        return nombre_alumno;
    }

    public void setNombre_alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }

    public String getNombre_asignatura() {
        return nombre_asignatura;
    }

    public void setNombre_asignatura(String nombre_asignatura) {
        this.nombre_asignatura = nombre_asignatura;
    }

    public int getHoras_asignatura() {
        return horas_asignatura;
    }

    public void setHoras_asignatura(int horas_asignatura) {
        this.horas_asignatura = horas_asignatura;
    }  
    
     @Override
    public String toString() {
        return "Matricula DAM Itaca {" + "ID Matricula: " + id_matricula + "Nombre Alumno Matriculado: " + nombre_alumno + "\n Nombre Asignatura Matriculada: " + nombre_asignatura + "\n Horas Impartidas Asignatura: " + horas_asignatura + '}';
    } 
}