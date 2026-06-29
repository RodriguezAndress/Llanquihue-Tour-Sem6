package duoc.llanquihueTourSem5.util;

import java.io.*;
import duoc.llanquihueTourSem5.model.ServicioTuristico;
import java.util.ArrayList;

public class Archivo {
    private static final String DIRECTORIO = "src/resources";
    private static final String ARCHIVO = DIRECTORIO + "/recorridos.txt";

    public static void guardarLista(ArrayList<ServicioTuristico> lista) {
        File dir = new File(DIRECTORIO);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (ServicioTuristico t : lista) {
                bw.write(t.toString()); // usa el toString del Tour
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<ServicioTuristico> leerLista() {
        ArrayList<ServicioTuristico> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(ServicioTuristico.fromString(linea)); // reconstruye el objeto
            }
        } catch (IOException e) {
            System.out.println("Fallo al leer el archivo: " + e.getMessage());
        }
        return lista;
    }
}
