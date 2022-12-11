package Entidades;

public class Ruta {
    private String origen;
    private String destino;
    private double precio;
    private int duracion;

    public Ruta(String origen, String destino, double precio, int duracion) {
        this.origen = origen;
        this.destino = destino;
        this.precio = precio;
        this.duracion = duracion;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public int getDuracion() {
        return duracion;
    }    
}
