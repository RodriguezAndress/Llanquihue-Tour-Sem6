package duoc.cl.llanquihueTour8.model;

public class ExcursionCultural extends ServicioTuristico {
    private String lugarHistorico;

    public ExcursionCultural(String nombre, double duracionHoras, String lugarHistorico) {
        super(nombre, duracionHoras);
        this.lugarHistorico = lugarHistorico;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println(".....Excursión Cultural.....");
        super.mostrarInformacion();
        System.out.println("Lugar Historico: "+lugarHistorico);
    }
}
