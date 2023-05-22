package Classes;

import java.util.ArrayList;

public class ListaUsuario {
    NodoUsuario cabeza;

    public ListaUsuario() {
        this.cabeza = null;
    }

    public void agregar(Usuario usuario) {
        NodoUsuario nuevoNodo = new NodoUsuario(usuario);

        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoUsuario nodoActual = cabeza;
            while (nodoActual.siguiente != null) {
                nodoActual = nodoActual.siguiente;
            }
            nodoActual.siguiente = nuevoNodo;
        }
    }

    public void imprimir() {
        NodoUsuario nodoActual = cabeza;
        while (nodoActual != null) {
            Usuario usuario = nodoActual.usuario;
            System.out.println("ID: " + usuario.getID());
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Apellido: " + usuario.getApellido());
            System.out.println("Contraseña: " + usuario.getPassword());
            System.out.println();
            nodoActual = nodoActual.siguiente;
        }
    }
    public ArrayList<Usuario> obtenerUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        NodoUsuario nodoActual = cabeza;
        while (nodoActual != null) {
            usuarios.add(nodoActual.usuario);
            nodoActual = nodoActual.siguiente;
        }
        return usuarios;
    }

    public Usuario obtenerUsuarioPorNombre(String nombre) {
        NodoUsuario actual = cabeza;
        while (actual != null) {
            if (actual.usuario.getNombre().equals(nombre)) {
                return actual.usuario;
            }
            actual = actual.siguiente;
        }
        return null; // Usuario no encontrado
    }
}
