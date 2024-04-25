/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package bda.itson.airportmongo;

import datos.DAOAerolinea;
import java.util.ArrayList;
import modelos.Aerolinea;

/**
 *
 * @author ID145
 */
public class AirportMongo {

    public static void main(String[] args) {
        DAOAerolinea a = new DAOAerolinea();

        // Método agregar.
        Aerolinea aerolinea = new Aerolinea("Volaris", "mexico", "MXN", true);
        Aerolinea aerolinea1 = new Aerolinea("Interjet", "Mexico", "MXN", true);
        Aerolinea aerolinea2 = new Aerolinea("American Airlines", "Estados Unidos", "USD", false);
        Aerolinea aerolinea3 = new Aerolinea("Emirates", "Emiratos Árabes Unidos", "AED", false);
        Aerolinea aerolinea4 = new Aerolinea("British Airways", "Reino Unido", "GBP", true);
        a.AgregarAerolinea(aerolinea);
        a.AgregarAerolinea(aerolinea1);
        a.AgregarAerolinea(aerolinea2);
        a.AgregarAerolinea(aerolinea3);
        a.AgregarAerolinea(aerolinea4);

        // Método obtener todas.
        ArrayList<Aerolinea> lista = a.obtenerAerolineas();
        for (Aerolinea as : lista) {
            System.out.println(a.toString());
        }

        // Método eliminar.
        String primerId = a.obtenerPrimerIdAerolinea();
        if (primerId != null) {
            System.out.println("ID del primer documento encontrado: " + primerId);

            boolean eliminado = a.eliminarAerolinea(primerId);
            if (eliminado) {
                System.out.println("Aerolínea eliminada correctamente.");
            } else {
                System.out.println("La aerolínea no pudo ser eliminada.");
            }
        }

    }
}
