package duoc.llanquihueTour7.model;

public class RutaGastronomica extends ServicioTuristico {
    private int numeroDeParadas;

    public RutaGastronomica(String nombre, double duracionHoras, int numeroDeParadas) {
        super(nombre, duracionHoras);
        this.numeroDeParadas = numeroDeParadas;
    }

    @Override
    public void mostrarInformacion(){
        System.out.println("......Ruta Gastronomica......");
        super.mostrarInformacion();
        System.out.println("Número de Paradas: "+numeroDeParadas);
    }
}
