package Classes;

import java.time.LocalDateTime;

public class CajaDeProducto {
    private static int correlativoActual = 0;

    private int correlativo;
    private LocalDateTime fechaDeIngreso;

    public CajaDeProducto(LocalDateTime fechaDeIngreso) {
        this.correlativo = generarCorrelativo();
        this.fechaDeIngreso = fechaDeIngreso;
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
}
