package Models;
public class clienteOB {
    private int id_Cliente;
    private String persona_Contacto;
    private String tlfn_Contacto;
    private String cif;

    public clienteOB() {
        this.id_Cliente = 0;
        this.persona_Contacto = "";
        this.tlfn_Contacto = "";
        this.cif = "";
    }

    public clienteOB(int PidCliente, String Pcontacto, String Pmovil, String Pcif) {
        this.id_Cliente = PidCliente;
        this.persona_Contacto = Pcontacto;
        this.tlfn_Contacto = Pmovil;
        this.cif = Pcif;
    }

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public String getPersona_Contacto() {
        return persona_Contacto;
    }

    public void setPersona_Contacto(String persona_Contacto) {
        this.persona_Contacto = persona_Contacto;
    }

    public String getTlfn_Contacto() {
        return tlfn_Contacto;
    }

    public void setTlfn_Contacto(String tlfn_Contacto) {
        this.tlfn_Contacto = tlfn_Contacto;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    @Override
    public String toString() {
        return  "!TABLA GBD CLIENTE¡ :" + "clienteOB [ ID_CLIENTE = " + id_Cliente + ", PERSONA_CONTACTO = " + persona_Contacto + ", TELÉFONO_CONTACTO = "
                + tlfn_Contacto + ", CIF = " + cif + "]";
    }

    
}
