package Model;
// Clase que representa una película con sus atributos principales.
public class Pelicula {
    private String titulo;
    private int anio;
    private String director;
    private String categoria;
    protected String setTitulo;

    // Constructor

    public Pelicula() {
    }

    public Pelicula(String titulo, int anio, String director, String categoria) {
        // Implementar inicialización de atributos. (0,3 puntos)
        this.titulo = titulo;
        this.anio = anio;
        this.director = director;
        this.categoria = categoria;
    }

    // Métodos getters
    public String getTitulo() { /* Implementar */
        // (0,05 puntos)
        return this.titulo;
    }

    public int getAnio() { /* Implementar */
        // (0,05 puntos)
        return this.anio;
    }

    public String getDirector() { /* Implementar */
        // (0,05 puntos)
        return this.director;
    }

    public String getCategoria() { /* Implementar */
        // (0,05 puntos)
        return this.categoria;
    }

    public void setTitulo(String Ptitulo) {
        this.titulo = Ptitulo;
    }

    public void setAnio(int Panio) {
        this.anio = Panio;
    }

    public void setDirector(String Pdirector) {
        this.director = Pdirector;
    }

    public void setCategoria(String Pcategoria) {
        this.categoria = Pcategoria;
    }
}
