package duoc.llanquihueTourSem5.model;

public class PaseoLacustre extends ServicioTuristico {
    private String tipoDeEmbarcacion;

    public PaseoLacustre(String nombre, double duracionHoras, String tipoDeEmbarcacion) {
        super(nombre, duracionHoras);
        this.tipoDeEmbarcacion = tipoDeEmbarcacion;
    }

    public String getTipoDeEmbarcacion() { return tipoDeEmbarcacion;
    }
    public void setTipoDeEmbarcacion(String tipoDeEmbarcacion) { this.tipoDeEmbarcacion = tipoDeEmbarcacion;
    }

    @Override
    public String toString() {
        return "PaseoLacustre," + getNombre() + "," +
                getDuracionHoras() + "," + tipoDeEmbarcacion;
    }
    public String mostrar() {
        return "Paseo Lacustre: " + getNombre() + " | " + getDuracionHoras() + " hrs | Embarcación: " + tipoDeEmbarcacion;
    }
}
