package duoc.llanquihueTourSem5.model;

public class ServicioTuristico {
    private String nombre;
    private double duracionHoras;

    public ServicioTuristico(String nombre, double duracionHoras) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getDuracionHoras() { return duracionHoras; }

    public void setDuracionHoras(double duracionHoras) { this.duracionHoras = duracionHoras; }


    @Override
    public String toString() {
        return "ServicioTuristico," + nombre + "," + duracionHoras;
    }
    public String mostrar(){
        return "Servicio Turistico: " + nombre + "|" + duracionHoras + "hrs";
    }

    //Pasa el toString a objeto nuevamente y corta el string con cada coma y crea un arreglo
    public static ServicioTuristico fromString(String linea) {
        String[] partes = linea.split(",");
        String tipo = partes[0];

        switch (tipo) {
            case "RutaGastronomica":
                return new RutaGastronomica(partes[1], Double.parseDouble(partes[2]), Integer.parseInt(partes[3]));
            case "PaseoLacustre":
                return new PaseoLacustre(partes[1], Double.parseDouble(partes[2]), partes[3]);
            case "ExcursionCultural":
                return new ExcursionCultural(partes[1], Double.parseDouble(partes[2]), partes[3]);
            default:
                return new ServicioTuristico(partes[1], Double.parseDouble(partes[2]));
        }

        }

}
