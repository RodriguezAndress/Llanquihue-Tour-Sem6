package duoc.cl.llanquihueTour8.service;
import duoc.cl.llanquihueTour8.model.*;
import duoc.cl.llanquihueTour8.util.Archivo;

import java.util.ArrayList;
import java.util.List;

public class GestorEntidades {
    List<IRegistrable> entidades;

    public GestorEntidades(){
        entidades = new ArrayList<>();
        cargarEntidades();
        cargarDesdeArchivo();
    }
    private void cargarEntidades(){

        entidades.add(new GuiaTuristico("Juan Landaeta", "Kayak"));
        entidades.add(new Vehiculo("SK-3541", "Furgoneta"));
        entidades.add(new ColaboradorExterno("Carmen Saenz", "Chofer"));

    }

    private void cargarDesdeArchivo() {
        for (String linea : Archivo.leerLineas()) {
            IRegistrable entidad = parsearLinea(linea);
            if (entidad != null) {
                entidades.add(entidad);
            }
        }
    }
    //Vuelve cada linea a obj
    private IRegistrable parsearLinea(String linea) {
        try {
            String[] partes = linea.split("\\|");
            if (partes.length != 2) return null;

            String parte1 = partes[0].trim(); // ubica el primer parametro como patente
            String parte2 = partes[1].trim(); // aqui el segundo, tipo de vehiculo

            String tipo = parte1.substring(0, parte1.indexOf(":")).trim();
            String valor1 = parte1.substring(parte1.indexOf(":") + 1).trim();
            String valor2 = parte2.substring(parte2.indexOf(":") + 1).trim();

            return switch (tipo) {
                case "Guía" -> new GuiaTuristico(valor1, valor2);
                case "Colaborador" -> new ColaboradorExterno(valor1, valor2);
                case "Vehículo" -> new Vehiculo(valor1, valor2);
                default -> null;
            };
        } catch (Exception e) {
            System.out.println("No se pudo interpretar la línea: " + linea);
            return null;
        }
    }

    public List<IRegistrable> obtenerEntidades() {return entidades;}

    // Agrega la entidad a la lista y la guarda
    public void agregarEntidad(IRegistrable entidad) {
        entidades.add(entidad);
       Archivo.guardarLinea(formatearLinea(entidad));
    }


    public String formatearLinea(IRegistrable entidad) {
        if (entidad instanceof GuiaTuristico g) {
            return "Guía: " + g.getNombre() + " | Especialidad: " + g.getEspecialidad();
        } else if (entidad instanceof ColaboradorExterno c) {
            return "Colaborador: " + c.getNombre() + " | Rol: " + c.getRol();
        } else if (entidad instanceof Vehiculo v) {
            return "Vehículo: " + v.getPatente() + " | Tipo: " + v.getTipo();
        }
        return entidad.toString();
    }

}
