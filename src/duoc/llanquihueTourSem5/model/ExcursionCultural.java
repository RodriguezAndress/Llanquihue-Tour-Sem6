package duoc.llanquihueTourSem5.model;

public class ExcursionCultural extends ServicioTuristico {
    private String lugarHistorico;

    public ExcursionCultural(String nombre, double duracionHoras, String lugarHistorico) {
        super(nombre, duracionHoras);
        this.lugarHistorico = lugarHistorico;
    }

    public String getLugarHistorico() { return lugarHistorico;
    }
    public void setLugarHistorico(String lugarHistorico) { this.lugarHistorico = lugarHistorico;
    }

    @Override
    public String toString() {
        return "ExcursionCultural," + getNombre() + "," +
                + getDuracionHoras() + "," + lugarHistorico;
    }
    public String mostrar() {
        return "Excursión Cultural: " + getNombre() + " | " + getDuracionHoras() + " hrs | Lugar: " + lugarHistorico;
    }
}
