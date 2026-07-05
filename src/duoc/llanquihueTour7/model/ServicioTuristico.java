package duoc.llanquihueTour7.model;

public class ServicioTuristico {
    private String nombre;
    private double duracionHoras;

    public ServicioTuristico(String nombre, double duracionHoras) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
    }



    public void mostrarInformacion(){
        System.out.println("Servicio Turistico: " + nombre + "|" + duracionHoras + "hrs" );
    }
}
