package Classes;

public class Vehiculo {
    private String Placa;
    private String Modelo;
    private String Marca;
    private String Color;
    private String Year;

    public Vehiculo(String Placa, String Modelo, String Marca, String Color, String Year){
        this.Placa = Placa;
        this.Modelo = Modelo;
        this.Marca = Marca;
        this.Color = Color;
        this.Year = Year;
    }

    public String getPlaca() {
        return Placa;
    }

    public String getModelo() {
        return Modelo;
    }

    public String getMarca() {
        return Marca;
    }

    public String getColor() {
        return Color;
    }

    public String getYear() {
        return Year;
    }
}
