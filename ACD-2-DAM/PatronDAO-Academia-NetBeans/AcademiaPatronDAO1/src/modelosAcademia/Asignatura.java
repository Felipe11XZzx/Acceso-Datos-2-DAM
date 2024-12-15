/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelosAcademia;

/**
 *
 * @author estudiante
 */
public class Asignatura {
    
    private int codigo_asignatura;
    private String nombre_asignatura;
    private int horas_semanales;
    private double nota_alumno;
    private String reporte_incidencia;
    
    public Asignatura() {}
    
    public Asignatura(int codigo_asignatura, String nombre_asignatura, int horas_semanales, double nota_alumno, String reporte_incidencia) {
        this.codigo_asignatura = codigo_asignatura;
        this.nombre_asignatura = nombre_asignatura;
        this.horas_semanales = horas_semanales;
        this.nota_alumno = nota_alumno;
        this.reporte_incidencia = reporte_incidencia;
    }

    public int getCodigo_asignatura() {
        return codigo_asignatura;
    }

    public void setCodigo_asignatura(int codigo_asignatura) {
        this.codigo_asignatura = codigo_asignatura;
    }

    public String getNombre_asignatura() {
        return nombre_asignatura;
    }

    public void setNombre_asignatura(String nombre_asignatura) {
        this.nombre_asignatura = nombre_asignatura;
    }

    public int getHoras_semanales() {
        return horas_semanales;
    }

    public void setHoras_semanales(int horas_semanales) {
        this.horas_semanales = horas_semanales;
    }

    public double getNota_alumno() {
        return nota_alumno;
    }

    public void setNota_alumno(double nota_alumno) {
        this.nota_alumno = nota_alumno;
    }

    public String getReporte_incidencia() {
        return reporte_incidencia;
    }

    public void setReporte_incidencia(String reporte_incidencia) {
        this.reporte_incidencia = reporte_incidencia;
    } 
    
    
    @Override
    public String toString() {
        return "Asignatura DAM Itaca {" + "ID Asignatura: " + codigo_asignatura + "Nombre Asignatura: " + nombre_asignatura + "\n Horas Semanales: " + horas_semanales + "\n Nota Alumno DAM: " + nota_alumno + "\n Reporte Incidencia: " + reporte_incidencia + '}';
    } 
}