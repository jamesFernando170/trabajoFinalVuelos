package Entidades;

public class Ruta {
    private String origen;
    private String destino;
    private double precio;
    private double duracion;

    public Ruta(String origen, String destino, double precio, double d) {
        this.origen = origen;
        this.destino = destino;
        this.precio = precio;
        this.duracion = d;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public double getDuracion() {
        return duracion;
    }    

    public double getPrecio(){
        return this.precio;
    }

    @Override
    public String toString() {
        return "Ruta [origen=" + origen + ", destino=" + destino + ", precio=" + precio + ", duracion=" + duracion
                + "]";
    }
}
