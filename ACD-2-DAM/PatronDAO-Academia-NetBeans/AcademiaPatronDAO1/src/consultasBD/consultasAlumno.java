/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package consultasBD;

/**
 *
 * @author estudiante
 */
public enum consultasAlumno {
    INSERTAR("INSERT INTO ALUMNO (id_alumno, dni_alumno, nombre_alumno, apellido_alumno, direccion_alumno, fecha_nacimiento, codPostal_alumno, telefono_alumno) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"),
    SELECCIONAR("SELECT * FROM ALUMNO WHERE id_alumno = ?"),
    ELIMINAR("DELETE FROM ALUMNO WHERE id_alumno = ?"),
    ACTUALIZAR("UPDATE ALUMNO SET dni_alumno = ?, nombre_alumno  = ? , apellido_alumno= ?,  direccion_alumno = ?, fecha_nacimiento = ?, codPostal_alumno = ? , telefono_alumno = ? WHERE (id_alumno = ?)"),
    GENERAL("SELECT * FROM ALUMNO");
     
         private String consulta;  
         
         private consultasAlumno(String Cconsulta) {
             this.consulta = Cconsulta;
         }
         
        public String getConsultaAlumno() {
             return consulta;
        }
}
