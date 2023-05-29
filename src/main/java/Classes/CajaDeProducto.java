package Classes;

import java.time.LocalDateTime;

public class CajaDeProducto {
    private static int correlativoActual = 0;

    private int correlativo;
    private LocalDateTime fechaDeIngreso;

    private String description;

    public CajaDeProducto(LocalDateTime fechaDeIngreso, String description) {
        this.correlativo = generarCorrelativo();
        this.fechaDeIngreso = fechaDeIngreso;
        this.description = description;
    }

    private static int generarCorrelativo() {
        return ++correlativoActual;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public LocalDateTime getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
