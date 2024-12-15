/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package consultasBD;

/**
 *
 * @author estudiante
 */
public enum consultasMatricula {
    
    INSERTAR("INSERT INTO MATRICULA (id_matricula, nombre_alumno , nombre_asignatura, horas_asignatura VALUES (?, ?, ?, ?)"),
    SELECCIONAR("SELECT * FROM MATRICULA WHERE id_matricula = ?"),
    ELIMINAR("DELETE FROM MATRICULA WHERE id_matricula = ?"),
    ACTUALIZAR("UPDATE MATRICULA SET nombre_alumno  = ? ,  nombre_asignatura = ?, horas_asignatura = ? WHERE (id_matricula = ?)"),
    GENERAL("SELECT * FROM MATRICULA");
     
         private String consulta;  
         
         private consultasMatricula(String Cconsulta) {
             this.consulta = Cconsulta;
         }
         
        public String getConsultaMatricula() {
             return consulta;
        }
}
