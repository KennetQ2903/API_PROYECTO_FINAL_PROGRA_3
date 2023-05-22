package Classes;

public class NodoCaja {
    CajaDeProducto caja;
    NodoCaja siguiente;

    public NodoCaja(CajaDeProducto caja){
        this.caja = caja;
        this.siguiente =null;
    }
}
