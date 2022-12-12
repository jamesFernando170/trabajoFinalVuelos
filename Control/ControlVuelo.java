package Control;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import Entidades.Ruta;
import Entidades.Vuelo;

public class ControlVuelo {
    private List<Vuelo> vuelos;
    ControlRutas controlRutas = new ControlRutas();

    public ControlVuelo() {
        vuelos = new ArrayList<>();
    }

    /**
     * Metodo encargado de buscar todos los vuelos que cumplan con la condicion de
     * ser igual al origen
     * y destino que nos llega por parametros
     * 
     * @param origen
     * @param destino
     */
    public List<Vuelo> obtenerVuelosSolicitados(String origen, String destino) throws IOException {
        if (origen == "" && destino == "") {
            throw new IOException();
        }
        List<Vuelo> vuelosRetornar = new ArrayList<>();

        for (Vuelo vuelo : this.vuelos) {
            if (vuelo.getOrigen().equals(origen) && vuelo.getDestino().equals(destino)) {
                vuelosRetornar.add(vuelo);
            }
        }
        return vuelosRetornar;
    }

    public void crearVuelos(String rutaArchivo) throws FileNotFoundException, ParseException, IOException, org.json.simple.parser.ParseException {

        List<List<Ruta>> rutasVuelos = controlRutas.cargarDatos(rutaArchivo);

        String origen;
        String destino;
        double duracion;
        double precio;
        boolean conEscala = false;

        for (List<Ruta> rutas : rutasVuelos) {
            duracion = calcularDuracion(rutas);
            precio = calcularPrecio(rutas);
            if (rutas.size() == 2) {
                origen = rutas.get(0).getOrigen();
                destino = rutas.get(1).getDestino();
                conEscala = true;
            } else {
                origen = rutas.get(0).getOrigen();
                destino = rutas.get(0).getDestino();
            }
            Vuelo vuelo = new Vuelo(origen, destino, precio, duracion, conEscala);

            vuelo.agregarRuta(rutas);

            vuelos.add(vuelo);
        }
    }

    public Vuelo buscarVueloDisponible(Vuelo vuelo) {
        for (Vuelo vuelo1 : vuelos) {
            if (vuelo1.getOrigen().equals(vuelo.getOrigen())
                    && vuelo1.getDestino().equals(vuelo.getDestino())
                    && vuelo1.getDuracion() == vuelo.getDuracion()
                    && vuelo1.getPrecio() == vuelo.getPrecio()
                    && vuelo1.isEscala() == vuelo.isEscala()) {
                return vuelo1;
            }
        }
        return null;
    }

    public double calcularPrecio(List<Ruta> rutas) {
        double precio = 0;
        for (Ruta ruta : rutas) {
            precio += ruta.getPrecio();
        }
        return precio;
    }

    public void crearNuevoVuelo(List<Ruta> rutas) {
        ControlRutas controlRutas = new ControlRutas();
        for (int i = 0; i < rutas.size(); i++) {
            Ruta ruta = controlRutas.buscarRuta(rutas.get(i));

        }

    }

    public Vuelo buscarVuelo(Vuelo vuelo) {
        for (Vuelo vuelo1 : this.vuelos) {
            if (vuelo1.getOrigen().equals(vuelo.getOrigen()) && vuelo.getDestino().equals(vuelo.getDestino())
                    && vuelo1.getDuracion() == vuelo.getDuracion()) {
                return vuelo1;

            }
        }
        return null;
    }
    public double calcularDuracion(List<Ruta> rutas){
        double duracion = 0;
         for (Ruta ruta : rutas) {
            duracion += ruta.getDuracion();
         }
         return duracion;
    }
}
