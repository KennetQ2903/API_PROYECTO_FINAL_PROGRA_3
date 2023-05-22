package Classes;

public class Usuario {
    private static int contadorID = 0;
    int ID;
    String nombre;
    String apellido;
    String password;

    public Usuario(String nombre, String apellido, String password) {
        this.ID = generarID();
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
    }

    private static int generarID() {
        return ++contadorID;
    }

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getPassword() {
        return password;
    }

}
