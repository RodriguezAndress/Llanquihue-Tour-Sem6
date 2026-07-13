package duoc.cl.llanquihueTour8.model;

public class GuiaTuristico extends Persona implements IRegistrable{

    public GuiaTuristico(String nombre, String especialidad) {
        super(nombre, especialidad);
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("Guía: " + nombre + " | Especialidad: "+especialidad);
        System.out.println("Hola, soy tu guía turistico");
    }

}
