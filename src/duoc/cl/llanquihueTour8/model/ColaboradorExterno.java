package duoc.cl.llanquihueTour8.model;

public class ColaboradorExterno extends Persona implements IRegistrable{
    public ColaboradorExterno(String nombre, String rol) {
        super(nombre, rol, true);
    }

    @Override
    public void mostrarResumen() {
        System.out.println("Colaborador: " + nombre + " | Rol: "+rol);
        System.out.println("Hola, soy un colaborador externo y voy a ayudarte en este tour.");
    }
}
