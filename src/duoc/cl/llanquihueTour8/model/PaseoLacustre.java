package duoc.cl.llanquihueTour8.model;

public class PaseoLacustre extends ServicioTuristico {
    private String tipoDeEmbarcacion;

    public PaseoLacustre(String nombre, double duracionHoras, String tipoDeEmbarcacion) {
        super(nombre, duracionHoras);
        this.tipoDeEmbarcacion = tipoDeEmbarcacion;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println(".....Paseo Lacustre.....");
        super.mostrarInformacion();
        System.out.println("Tipo de Embarcación: "+tipoDeEmbarcacion);
    }
}
