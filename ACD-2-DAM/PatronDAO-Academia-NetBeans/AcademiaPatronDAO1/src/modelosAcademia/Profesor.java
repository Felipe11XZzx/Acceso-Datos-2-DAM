/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelosAcademia;

/**
 *
 * @author estudiante
 */

// CREACION DEL MODELO PROFESOR.
public class Profesor {
    
    
    // ATRIBUTOS DEL MODELO PROFESOR.
     private int id_profesor;
     private String dni_profesor;
     private String nombre_profesor;
     private String apellido_profesor;
     private String direccion_profesor;
     private String fecha_nacimiento;
     private int codPostal_profesor;
     private String telefono_profesor;
    
    public Profesor() {}

    public Profesor(int id_profesor, String dni_profesor, String nombre_profesor, String apellido_profesor, String direccion_profesor, String fecha_nacimiento, int codPostal_profesor, String telefono_profesor) {
        this.id_profesor = id_profesor;
        this.dni_profesor = dni_profesor;
        this.nombre_profesor = nombre_profesor;
        this.apellido_profesor = apellido_profesor;
        this.direccion_profesor = direccion_profesor;
        this.fecha_nacimiento = fecha_nacimiento;
        this.codPostal_profesor = codPostal_profesor;
        this.telefono_profesor = telefono_profesor;
        }

    // CONSTRUCTOR Y METODOS DE EL MODELO.
    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getDni_profesor() {
        return dni_profesor;
    }

    public void setDni_profesor(String dni_profesor) {
        this.dni_profesor = dni_profesor;
    }
   
    public String getNombre_profesor() {
        return nombre_profesor;
    }

    public void setNombre_profesor(String nombre_profesor) {
        this.nombre_profesor = nombre_profesor;
    }

    public String getApellido_profesor() {
        return apellido_profesor;
    }

    public void setApellido_profesor(String apellido_profesor) {
        this.apellido_profesor = apellido_profesor;
    }

    public String getDireccion_profesor() {
        return direccion_profesor;
    }

    public void setDireccion_profesor(String direccion_profesor) {
        this.direccion_profesor = direccion_profesor;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getCodPostal_profesor() {
        return codPostal_profesor;
    }

    public void setCodPostal_profesor(int codPostal_profesor) {
        this.codPostal_profesor = codPostal_profesor;
    }

    public String getTelefono_profesor() {
        return telefono_profesor;
    }

    public void setTelefono_profesor(String telefono_profesor) {
        this.telefono_profesor = telefono_profesor;
    }

    @Override
    public String toString() {
        return "Profesor Itaca {" + "ID Profesor: " + id_profesor + "\n Nombre Profesor: " + nombre_profesor + "\n Apellidos Profesor: " + apellido_profesor + "\n Direccion Profesor: " + direccion_profesor + "\n Fecha Nacimiento: " + fecha_nacimiento + "\n Codigo Postal: " + codPostal_profesor + "\n Telefono Profesor: " + telefono_profesor + '}';
    }
}