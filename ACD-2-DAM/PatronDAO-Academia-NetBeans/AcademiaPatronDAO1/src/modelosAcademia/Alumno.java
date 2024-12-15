/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelosAcademia;
/**
 *
 * @author estudiante
 */

// CREACION DEL MODELO ALUMNO.
public class Alumno {
    
    // ATRIBUTOS DEL MODELO ALUMNO.
    private int id_alumno;
    private String dni_alumno;
    private String nombre_alumno;
    private String apellido_alumno;
    private String direccion_alumno;
    private String fecha_nacimiento;
    private int codPostal_alumno;
    private String telefono_alumno;

    // CONSTRUCTOR Y METODOS DE EL MODELO.
    
    public Alumno() {}
    
    public Alumno(int id_alumno, String nombre_alumno, String dni_alumno, String apellido_alumno, String direccion_alumno, String fecha_nacimiento, int codPostal_alumno, String telefono_alumno) {
        this.id_alumno = id_alumno;
        this.dni_alumno = dni_alumno;
        this.nombre_alumno = nombre_alumno;
        this.apellido_alumno = apellido_alumno;
        this.direccion_alumno = direccion_alumno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.codPostal_alumno = codPostal_alumno;
        this.telefono_alumno = telefono_alumno;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getDni_alumno() {
        return dni_alumno;
    }

    public void setDni_alumno(String dni_alumno) {
        this.dni_alumno = dni_alumno;
    }

    public String getNombre_alumno() {
        return nombre_alumno;
    }

    public void setNombre_alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }

    public String getApellido_alumno() {
        return apellido_alumno;
    }

    public void setApellido_alumno(String apellido_alumno) {
        this.apellido_alumno = apellido_alumno;
    }

    public String getDireccion_alumno() {
        return direccion_alumno;
    }

    public void setDireccion_alumno(String direccion_alumno) {
        this.direccion_alumno = direccion_alumno;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getCodPostal_alumno() {
        return codPostal_alumno;
    }

    public void setCodPostal_alumno(int codPostal_alumno) {
        this.codPostal_alumno = codPostal_alumno;
    }

    public String getTelefono_alumno() {
        return telefono_alumno;
    }

    public void setTelefono_alumno(String telefono_alumno) {
        this.telefono_alumno = telefono_alumno;
    }

    public String[] toArrayString() {
        String Alumn [] = new String [8];
        Alumn[0] = Integer.toString(id_alumno);
        Alumn[1] = dni_alumno;
        Alumn[2] = nombre_alumno;
        Alumn[3] = apellido_alumno;
        Alumn[4] = direccion_alumno;
        Alumn[5] = fecha_nacimiento;
        Alumn[6] = Integer.toString(codPostal_alumno);
        Alumn[7] = telefono_alumno;
        return Alumn;
    }
    
    @Override
    public String toString() {
        return "Alumno Itaca {" + "ID Alumno: " + id_alumno + "DNI Alumno: " + dni_alumno + "\n Nombre Alumno: " + nombre_alumno + "\n Apellido Alumno: " + apellido_alumno + "\n Direccion Alumno: " + direccion_alumno + "\n Fecha Nacimiento: " + fecha_nacimiento + "\n Codigo Postal: " + codPostal_alumno + "\n Telefono Alumno: " + telefono_alumno + '}';
    } 
}
