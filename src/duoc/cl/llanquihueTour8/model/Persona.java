package duoc.cl.llanquihueTour8.model;

public abstract class Persona {
    protected String nombre;
    protected String especialidad;
    protected String rol;

    //Constructor para clase hija Guia Turistico
    public Persona(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.rol = null;
    }

    /*Constructor para clase hija Colaborador Externo
    Se usa el booleano para diferenciar los constructores y no arroje error por recibir
    los mismos parametros que el anterior.*/

    public Persona(String nombre, String rol, boolean esRol) {
        this.nombre = nombre;
        this.rol = rol;
       // this.especialidad = null; // Queda vacío
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
