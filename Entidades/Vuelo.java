package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Vuelo {
    private String origen;
    private String destino;
    private double precio;
    private double duracion;
    private boolean escala;
    private List<Ruta> rutas;

    public Vuelo(String origen, String destino, double precio, double duracion2, boolean escala) {
        this.origen = origen;
        this.destino = destino;
        this.precio = precio;
        this.duracion = duracion2;
        this.escala = escala;
        this.rutas = new ArrayList<Ruta>();
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

    public double getPrecio() {
        return precio;
    }

    public boolean isEscala() {
        return escala;
    }

    public void agregarRuta(List<Ruta> rutas) {
        for (Ruta ruta : this.rutas) {
            rutas.add(ruta);
        }
    }

    @Override
    public String toString() {
        return "Vuelo [origen=" + origen + ", destino=" + destino + ", precio=" + precio + ", duracion=" + duracion
                + ", conEscala=" + escala + "]";
    }

}
