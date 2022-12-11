package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Vuelo {
    private String origen;
    private String destino;
    private double precio;
    private int duracion;
    private boolean escala;
    private List<Ruta> rutas;

    public Vuelo(String origen, String destino, double precio, int duracion, boolean escala) {
        this.origen = origen;
        this.destino = destino;
        this.precio = precio;
        this.duracion = duracion;
        this.escala = escala;
        this.rutas = new ArrayList<Ruta>();
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
