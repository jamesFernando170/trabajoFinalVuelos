package Control;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import Entidades.Ruta;

public class ControlRutas {
    private List<Ruta> rutasLista;

    public ControlRutas() {
        this.rutasLista = new ArrayList<Ruta>();
    }

    public List<List<Ruta>> cargarDatos(String ruta) throws FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException{
        CargarDatos datos = new CargarDatos();
        List<List<String[]>> rutasCargadas = datos.cargarDatos(ruta);

        List<List<Ruta>> rutasVuelos = new ArrayList<List<Ruta>>();
        
        for (List<String[]> rutas : rutasCargadas) {
            List<Ruta> rutasVuelo = new ArrayList<Ruta>();
            for (String[] rutaACargar : rutas) {
                Ruta rutaNueva = new Ruta(rutaACargar[0], rutaACargar[1], Double.parseDouble(rutaACargar[2]), Double.parseDouble(rutaACargar[3]));
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
