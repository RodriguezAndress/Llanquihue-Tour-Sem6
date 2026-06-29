package duoc.llanquihueTourSem5.service;

import duoc.llanquihueTourSem5.model.ExcursionCultural;
import duoc.llanquihueTourSem5.model.PaseoLacustre;
import duoc.llanquihueTourSem5.model.RutaGastronomica;
import duoc.llanquihueTourSem5.model.ServicioTuristico;
import duoc.llanquihueTourSem5.util.Archivo;
import java.util.ArrayList;

public class GestorDatos {
    public static ArrayList<ServicioTuristico> crearTours(){

        ArrayList<ServicioTuristico> tours = new ArrayList<>();

        //Agg obj del padre
        tours.add(new ServicioTuristico("Recorrido Centro Historico", 1.45));
        tours.add(new ServicioTuristico("Buceo con Tiburones", 3.30));

        //Agg obj de hijos
        tours.add(new RutaGastronomica("Recorrido Paseo Montalban", 2.45, 5));
        tours.add(new RutaGastronomica("Camino Historico Precolonial", 2.30, 6));

        //agg obj hijo paseoLacustre
        tours.add(new PaseoLacustre("Lago Negro", 1.45, "Canoa"));
        tours.add(new PaseoLacustre("Laguna Piedra Azul", 2.15, "Canoa"));

        //Agg obj hijo ExcursionCultural
        tours.add(new ExcursionCultural("Cerro San Cristobal", 3.15, "Santiago"));
        tours.add(new ExcursionCultural("Teatro Municipal de Santiago", 1.45, "Teatro"));

        //guardar en el archivo
        Archivo.guardarLista(tours);

        //leer desde el archivo
        return Archivo.leerLista();


    }
    public static void mostrarTours(ArrayList<ServicioTuristico> tours) {
        for (ServicioTuristico t : tours) {
            System.out.println(t.mostrar());
            //System.out.println("Tour: " + t.getNombre() + " - " + "Duración: " + t.getDuracionHoras() + " hrs");
        }
    }


}