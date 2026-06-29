import duoc.llanquihueTourSem5.model.ServicioTuristico;
import duoc.llanquihueTourSem5.service.GestorDatos;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // GestorDatos crea, guarda y retorna la lista leída desde el archivo
        ArrayList<ServicioTuristico> tours = GestorDatos.crearTours();
        GestorDatos.mostrarTours(tours);
    }
}