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

    public Vuelo(String origen, String destino, boolean escala) {
        this.origen = origen;
        this.destino = destino;
        this.precio = 0;
        this.duracion = 0;
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

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isEscala() {
        return escala;
    }

    // Metodo encargado de agregar una ruta mediante las rutas
    public void agregarRuta(List<Ruta> rutas) {
        for (Ruta ruta : rutas) {
            this.rutas.add(ruta);
        }
    }

    /* Metodo encargado de calcular la duracion de cada una de las rutas */
    public void calcularDuracion() {
        for (Ruta ruta : rutas) {
            this.duracion += ruta.getDuracion();
        }
    }

    /* Metodo encargado de calcular el precio apartir de la lista de rutas */
    public void calcularPrecio() {
        for (Ruta ruta : rutas) {
            precio += ruta.getPrecio();
        }
    }

    @Override
    public String toString() {
        return "Vuelo [origen=" + origen + ", destino=" + destino + ", precio=" + precio + ", duracion=" + duracion
                + ", conEscala=" + escala + "]";
    }

}
