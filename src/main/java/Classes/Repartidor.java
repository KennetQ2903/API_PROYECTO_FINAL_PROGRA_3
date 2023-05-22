package Classes;

public class Repartidor {
    private String CUI;
    private String nombre;
    private String apellido;
    private String licencia;
    private String telefono;

    public Repartidor(String CUI, String nombre, String apellido, String licencia, String telefono) {
        this.CUI = CUI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.licencia = licencia;
        this.telefono = telefono;
    }

    public String getCUI() {
        return CUI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getLicencia() {
        return licencia;
    }

    public String getTelefono() {
        return telefono;
    }
}
