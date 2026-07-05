import duoc.llanquihueTour7.model.ServicioTuristico;
import duoc.llanquihueTour7.service.GestorDatos;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GestorDatos gestor = new GestorDatos();
        List<ServicioTuristico> lista = gestor.obtenerServicios();

        for (ServicioTuristico servicio : lista){
            servicio.mostrarInformacion();
            System.out.println("\n--------***--------");
        }
    }
}