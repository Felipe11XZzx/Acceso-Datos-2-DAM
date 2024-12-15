/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package consultasBD;

/**
 *
 * @author estudiante
 */
public enum consultasAsignatura {
    
    INSERTAR("INSERT INTO ASIGNATURA (codigo_asignatura, nombre_asignatura, horas_semanales, nota_alumno, reporte_incidencia) VALUES (?, ?, ?, ?, ?)"),
    SELECCIONAR("SELECT * FROM ASIGNATURA WHERE codigo_asignatura = ?"),
    ELIMINAR("DELETE FROM ASIGNATURA WHERE codigo_asignatura = ?"),
    ACTUALIZAR("UPDATE ASIGNATURA SET nombre_asignatura  = ? ,  horas_semanales = ?, nota_alumno = ?, reporte_incidencia = ? WHERE (codigo_asignatura = ?)"),
    GENERAL("SELECT * FROM ASIGNATURA");
     
         private String consulta;  
         
         private consultasAsignatura(String Cconsulta) {
             this.consulta = Cconsulta;
         }
         
        public String getConsultaAsignatura() {
             return consulta;
        }
}
