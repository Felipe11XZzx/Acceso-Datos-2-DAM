/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package consultasBD;

/**
 *
 * @author estudiante
 */
public enum consultasProfesor {
    
    INSERTAR("INSERT INTO PROFESOR (id_profesor, dni_profesor, nombre_profesor, apellido_profesor, direccion_profesor, fecha_nacimiento, codPostal_profesor, telefono_profesor) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"),
    SELECCIONAR("SELECT * FROM PROFESOR WHERE id_profesor = ?"),
    ELIMINAR("DELETE FROM PROFESOR WHERE id_profesor = ?"),
    ACTUALIZAR("UPDATE PROFESOR SET dni_profesor = ?, nombre_profesor  = ? ,  apellido_profesor= ?,  direccion_profesor = ?, fecha_nacimiento = ?, codPostal_profesor = ? , telefono_profesor = ? WHERE (id_profesor = ?)"),
    GENERAL("SELECT * FROM PROFESOR");
     
         private String consulta;  
         
         private consultasProfesor(String Cconsulta) {
             this.consulta = Cconsulta;
         }
         
        public String getConsultaProfesor() {
             return consulta;
        }
}
