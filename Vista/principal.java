package Vista;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.json.simple.parser.ParseException;

import Control.ControlVuelo;

import Entidades.Vuelo;

public class principal {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws java.text.ParseException, ParseException {
        String rutaArchivo = "Rutas.json";

        ControlVuelo controlVuelos = new ControlVuelo();

        String origen = JOptionPane.showInputDialog(null, "Ingrese la ciudad Origen");
        String destino = JOptionPane.showInputDialog(null, "Ingrese la ciudad destino");

        System.out.println("Vuelos posibles: ");
        try {
            controlVuelos.crearVuelos(rutaArchivo);
            for (Vuelo vuelo : controlVuelos.obtenerVuelosSolicitados(origen, destino)) {
                System.out.println(vuelo);
            }
        }

        catch (FileNotFoundException e) {
            System.out.println(e.getStackTrace() + " :File Not Found");
        } catch (ParseException e) {
            System.out.println(e.getStackTrace() + " :Could not parse");
        } catch (IOException e) {
            System.out.println(e.getStackTrace() + " :IOException");
        }
    }
}
