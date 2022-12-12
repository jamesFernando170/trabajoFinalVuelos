package Control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CargarDatos {

    public CargarDatos() {
    }

    /**
     * Metodo encargado de procesar y cargar la informacion que se encuentra en el
     * archivo JSON
     * 
     * @param archivo
     * @return
     */
    public List<List<String[]>> cargarDatos(String archivo)
            throws FileNotFoundException, ParseException, IOException, org.json.simple.parser.ParseException {
        JSONParser parser = new JSONParser();
        FileReader fileReader;
        File file = new File(archivo);
        fileReader = new FileReader(file);
        JSONArray array = (JSONArray) parser.parse(fileReader);

        if (fileReader.read() == 0) {
            throw new IOException("El archivo está vacío");
        }

        if (array.isEmpty()) {
            throw new ParseException("El formato del archivo es inválido", 202);
        }

        if (!file.exists()) {
            throw new FileNotFoundException("No se encontró el archivo");
        }

        List<List<String[]>> rutas = new ArrayList<List<String[]>>();

        for (int i = 0; i < array.size(); i++) {
            String llave = String.valueOf(i + 1);
            JSONObject obj = (JSONObject) array.get(i);
            JSONArray vuelos = (JSONArray) obj.get(llave);

            List<String[]> rutaB = new ArrayList<String[]>();

            for (int j = 0; j < vuelos.size(); j++) {
                JSONObject ruta = (JSONObject) vuelos.get(j);
                String origen = (String) ruta.get("origen");
                String destino = (String) ruta.get("destino");
                String precio = String.valueOf(ruta.get("precio"));
                String duracion = String.valueOf(ruta.get("duracion"));
                String[] rutaC = { origen, destino, precio, duracion };
                rutaB.add(j, rutaC);
            }
            rutas.add(i, rutaB);
        }
        return rutas;
    }

}
