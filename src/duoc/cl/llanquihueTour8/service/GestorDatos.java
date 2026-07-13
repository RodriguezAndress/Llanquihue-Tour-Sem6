package duoc.cl.llanquihueTour8.service;

import duoc.cl.llanquihueTour8.model.ExcursionCultural;
import duoc.cl.llanquihueTour8.model.PaseoLacustre;
import duoc.cl.llanquihueTour8.model.RutaGastronomica;
import duoc.cl.llanquihueTour8.model.ServicioTuristico;

import java.util.ArrayList;
import java.util.List;

public class GestorDatos {
    private List<ServicioTuristico> servicios;

    public GestorDatos(){
        servicios = new ArrayList<>();
        cargarServicios();
    }

    private void cargarServicios(){
        //Agg obj del padre
        servicios.add(new ServicioTuristico("Recorrido Centro Historico", 1.45));

        //Agg obj de hijos
        servicios.add(new RutaGastronomica("Recorrido Paseo Montalban", 2.45, 5));
        servicios.add(new RutaGastronomica("Camino Historico Precolonial", 2.30, 6));

        //agg obj hijo paseoLacustre
        servicios.add(new PaseoLacustre("Lago Negro", 1.45, "Canoa"));
        servicios.add(new PaseoLacustre("Laguna Piedra Azul", 2.15, "Canoa"));

        //Agg obj hijo ExcursionCultural
        servicios.add(new ExcursionCultural("Cerro San Cristobal", 3.15, "Santiago"));
        servicios.add(new ExcursionCultural("Teatro Municipal de Santiago", 1.45, "Teatro"));
    }
    public List<ServicioTuristico> obtenerServicios() {
        return servicios;
    }
}
