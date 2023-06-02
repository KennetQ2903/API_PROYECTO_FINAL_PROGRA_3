package Classes;

import java.time.LocalDateTime;

public class Delivery {
    private int ID;
    private Cliente cliente;
    private Repartidor repartidor;
    private Vehiculo vehiculo;
    private String origen;
    private String destino;
    private LocalDateTime fechaInicio;
    private CajaDeProducto producto;
    private String estado;


    public Delivery(DeliveryRequest request, int ID, Vehiculo vehiculo, Repartidor repartidor, CajaDeProducto producto, Cliente cliente) {
        this.ID = ID;
        this.fechaInicio = generateFechaInicio();
        this.estado = deliveryPending();
        this.cliente = cliente;
        this.repartidor = repartidor;
        this.vehiculo = vehiculo;
        this.origen = request.getOrigen();
        this.destino = request.getDestino();
        this.producto = producto;
    }

    public String deliveryComplete() {
        return "Completado";
    }

    public String deliveryPending() {
        return "Pendiente";
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDateTime generateFechaInicio() {
        return LocalDateTime.now();
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio() {
        this.fechaInicio = generateFechaInicio();
    }

    public CajaDeProducto getProducto() {
        return producto;
    }

    public void setProducto(CajaDeProducto producto) {
        this.producto = producto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
