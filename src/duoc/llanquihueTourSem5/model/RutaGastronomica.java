package duoc.llanquihueTourSem5.model;

public class RutaGastronomica extends ServicioTuristico {
    private int numeroDeParadas;

    public RutaGastronomica(String nombre, double duracionHoras,  int numeroDeParadas) {
        super(nombre, duracionHoras);
        this.numeroDeParadas = numeroDeParadas;
    }

    public int getNumeroDeParadas() { return numeroDeParadas;
    }
    public void setNumeroDeParadas(int numeroDeParadas) { this.numeroDeParadas = numeroDeParadas;
    }

    @Override
    public String toString() {
        return "RutaGastronomica," + getNombre() + "," + getDuracionHoras() +
                "," + numeroDeParadas;
    }
    public String mostrar(){
        return "RutaGastronomica: " + getNombre() + "|" + getDuracionHoras()
                + " hrs | Paradas: " + numeroDeParadas;
    }
}

