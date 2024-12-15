package ficherosBinarios.practica6;

import java.io.Serializable;

public class Persona implements Serializable {

    private String nombre_persona;
    private int edad_persona;

    public Persona(String Pnombre, int Pedad){
        this.nombre_persona = Pnombre;
        this.edad_persona = Pedad;
    }

    public Persona() {
        this.nombre_persona = null;
    }

    public String getNombre_persona() {
        return nombre_persona;
    }

    public void setNombre_persona(String nombre_persona) {
        this.nombre_persona = nombre_persona;
    }

    public int getEdad_persona() {
        return edad_persona;
    }

    public void setEdad_persona(int edad_persona) {
        this.edad_persona = edad_persona;
    }

    @Override
    public String toString() {
        return "Persona [Nombre = " + nombre_persona + ", Edad = " + edad_persona + "]";
    }
}
