package duoc.cl.llanquihueTour8.model;

public class Vehiculo implements IRegistrable{
    private String patente;
    private String tipo;

    public Vehiculo(String patente, String tipo) {
        this.patente = patente;
        this.tipo = tipo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("Patente: "+patente + " | Tipo de vehiculo: "+tipo);
        System.out.println("Este es el vehiculo que encargado del recorrido");
    }
}
