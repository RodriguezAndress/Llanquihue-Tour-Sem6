package duoc.cl.llanquihueTour8.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Archivo {
    private static final String ARCHIVO_SALIDA = "src/duoc/cl/llanquihueTour8/resources/entidades.txt";

    private Archivo() {

    }

    /** Agrega una línea al final del archivo .txt (modo append, no borra lo anterior). */
    public static void guardarLinea(String linea) {
        try (FileWriter fw = new FileWriter(ARCHIVO_SALIDA, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(linea);
        } catch (IOException e) {
            System.out.println("No se pudo guardar en el archivo: " + e.getMessage());
        }
    }

    public static List<String> leerLineas() {
        List<String> lineas = new ArrayList<>();
        File archivo = new File(ARCHIVO_SALIDA);

        if (!archivo.exists()) {
            return lineas; // aún no se ha guardado nada, no es un error
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.isBlank()) {
                    lineas.add(linea);
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }

        return lineas;
    }

}
