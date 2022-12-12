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
    private List<Ruta> rutasLista;
    //ControlRutas controlRutas = new ControlRutas();

    public ControlVuelo() {
        vuelos = new ArrayList<>();
        this.rutasLista = new ArrayList<Ruta>();
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

    /** Metodo encargado de crear vuelos aparte de la ruta del archivo */
    public void crearVuelos(String rutaArchivo)
            throws FileNotFoundException, ParseException, IOException, org.json.simple.parser.ParseException {

        List<List<Ruta>> rutasVuelos = cargarDatos(rutaArchivo);

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

    /*
     * Buscar un vuelo apartir del parametro que le llega que es un vuelo de tipo
     * Vuelo
     */
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

    /* Metodo encargado de calcular el precio apartir de la lista de rutas */
    public double calcularPrecio(List<Ruta> rutas) {
        double precio = 0;
        for (Ruta ruta : rutas) {
            precio += ruta.getPrecio();
        }
        return precio;
    }

    /*
     * Metodo encargado de crear vuelos apartir de las rutas y ademas busca las
     * rutas con el buscarRutas que
     * recibe una ruta
     */
    public void crearNuevoVuelo(List<Ruta> rutas) {
        //ControlRutas controlRutas = new ControlRutas();
        for (int i = 0; i < rutas.size(); i++) {
            Ruta ruta = buscarRuta(rutas.get(i));

        }

    }

    /*
     * Metodo encargado de buscar un vuelo, donde se hacen las respectivos
     * comparaciones para buscar un
     * vuelo en especifico
     */
    public Vuelo buscarVuelo(Vuelo vuelo) {
        for (Vuelo vuelo1 : this.vuelos) {
            if (vuelo1.getOrigen().equals(vuelo.getOrigen()) && vuelo.getDestino().equals(vuelo.getDestino())
                    && vuelo1.getDuracion() == vuelo.getDuracion()) {
                return vuelo1;

            }
        }
        return null;
    }

    /* Metodo encargado de calcular la duracion de cada una de las rutas */
    public double calcularDuracion(List<Ruta> rutas) {
        double duracion = 0;
        for (Ruta ruta : rutas) {
            duracion += ruta.getDuracion();
        }
        return duracion;
    }

    /*
     * Metodo encargado de cargar los datos mediante la ruta que le llega como
     * argumento y se utiliza el metodo cargarDatos de la entidad CargarDatos
     */
    public List<List<Ruta>> cargarDatos(String ruta)
            throws FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException {
        CargarDatos datos = new CargarDatos();
        List<List<String[]>> rutasCargadas = datos.cargarDatos(ruta);

        List<List<Ruta>> rutasVuelos = new ArrayList<List<Ruta>>();

        for (List<String[]> rutas : rutasCargadas) {
            List<Ruta> rutasVuelo = new ArrayList<Ruta>();
            for (String[] rutaACargar : rutas) {
                Ruta rutaNueva = new Ruta(rutaACargar[0], rutaACargar[1], Double.parseDouble(rutaACargar[2]),
                        Double.parseDouble(rutaACargar[3]));
                rutasLista.add(rutaNueva);
                rutasVuelo.add(rutaNueva);
            }
            rutasVuelos.add(rutasVuelo);
        }

        return rutasVuelos;
    }

    public Ruta buscarRuta(Ruta ruta) {
        for (Ruta ruta1 : this.rutasLista) {
            if (ruta1.getOrigen().equals(ruta.getOrigen()) && ruta1.getDestino().equals(ruta.getDestino())
                    && ruta1.getDuracion() == ruta.getDuracion() && ruta1.getPrecio() == ruta.getPrecio()) {
                return ruta1;
            }
        }
        return null;
    }
}
