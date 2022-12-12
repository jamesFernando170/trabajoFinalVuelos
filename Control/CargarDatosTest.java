package Control;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CargarDatosTest {
    @Test
    void testRutaCompleta()
            throws FileNotFoundException, ParseException, IOException, org.json.simple.parser.ParseException {
        String rutaArchivo = "Vuelos.json";
        CargarDatos datosCargar = new CargarDatos();
        assertNotNull(datosCargar.cargarDatos(rutaArchivo));
    }

    @Test
    void testRutaIncompleta()
            throws FileNotFoundException, ParseException, IOException, org.json.simple.parser.ParseException {
        String rutaArchivo = "Vue.json";
        CargarDatos datosCargar = new CargarDatos();
        assertThrows(FileNotFoundException.class, () -> datosCargar.cargarDatos(rutaArchivo));
    }
}
