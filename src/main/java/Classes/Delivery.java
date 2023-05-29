package Classes;

import java.time.LocalDateTime;

public class Delivery {
    private int ID;
    private long cliente;
    private String repartidor;
    private Vehiculo vehiculo;
    private String origen;
    private String destino;
    private LocalDateTime fechaInicio;
    private int producto;
    private String estado;


    public Delivery(DeliveryRequest request, int ID, Vehiculo vehiculo) {
        this.ID = ID;
        this.fechaInicio = generateFechaInicio();
        this.estado = deliveryPending();
        this.cliente = request.getCliente();
        this.repartidor = request.getRepartidor();
        this.vehiculo = vehiculo;
        this.origen = request.getOrigen();
        this.destino = request.getDestino();
        this.producto = request.getProducto();
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


    public long getCliente() {
        return cliente;
    }

    public void setCliente(long cliente) {
        this.cliente = cliente;
    }

    public String getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(String repartidor) {
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

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
