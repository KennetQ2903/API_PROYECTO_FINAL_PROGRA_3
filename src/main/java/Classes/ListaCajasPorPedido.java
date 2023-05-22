package Classes;

import java.util.ArrayList;

public class ListaCajasPorPedido {
    NodoCaja cabeza;

    public ListaCajasPorPedido(){this.cabeza = null;}

    public void agregar(CajaDeProducto caja) {
        NodoCaja nuevoNodo = new NodoCaja(caja);

        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoCaja nodoActual = cabeza;
            while (nodoActual.siguiente != null) {
                nodoActual = nodoActual.siguiente;
            }
            nodoActual.siguiente = nuevoNodo;
        }
    }

    public ArrayList<CajaDeProducto> obtenerCajasPorPedido() {
        ArrayList<CajaDeProducto> cajas = new ArrayList<>();
        NodoCaja nodoActual = cabeza;
        while (nodoActual != null) {
            cajas.add(nodoActual.caja);
            nodoActual = nodoActual.siguiente;
        }
        return cajas;
    }
}
