package Models;
public class proyectoOB {
    
    private int idProyecto;
    private String nombreProyecto;
    private String ubicacionProyecto;
    private int idCliente;

    public proyectoOB(){
        this.idProyecto = 0;
        this.nombreProyecto = "";
        this.ubicacionProyecto = "";
        this.idCliente = 0;
    }

    public proyectoOB(int PidProyecto, String PnombreProyecto, String PubicacionProyecto, int PidCliente){
        this.idProyecto = PidProyecto;
        this.nombreProyecto = PnombreProyecto;
        this.ubicacionProyecto = PubicacionProyecto;
        this.idCliente = PidCliente;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getUbicacionProyecto() {
        return ubicacionProyecto;
    }

    public void setUbicacionProyecto(String ubicacionProyecto) {
        this.ubicacionProyecto = ubicacionProyecto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "!TABLA GBD PROYECTO¡ : [ ID_PROYECTO = " + idProyecto + ", NOMBRE_PROYECTO = " + nombreProyecto + ", UBICACIÓN_PROYECTO = " + ubicacionProyecto + ", ID_CLIENTE = " + idCliente + "]";
    }
}