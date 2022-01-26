package proceso;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * <code>Proceso</code> guarda y lee los datos de los mejores jugadores.
 *
 * @author Vegas Luis
 * @author Marcano Oriana
 * @version 1.0
 */
public class Proceso {

    /**
     * Este metodo guardar los nuevos datos de los jugadores en el top 5 de
     * mejores jugadores en el blog de notas llamado Puntuacion.
     *
     * @param puntuaciones Variable con los nuevos top 5 de jugadores.
     */
    public static void setPuntacion(Puntuacion[] puntuaciones) {
        try {
            BufferedWriter bw = new BufferedWriter(new java.io.FileWriter("Datos/Puntuacion.txt"));
            for (Puntuacion puntuacion : puntuaciones) {
                bw.write(puntuacion.nombre);
                bw.write(", ");
                bw.write(puntuacion.tiempo);
                bw.write(", ");
                bw.write(puntuacion.puntacion);
                bw.newLine();
            }
            bw.close();
        } catch (IOException exception) {
        }
    }

    /**
     * Esta funcion lee el blog de nota que guarda las puntuaciones y los guarda
     * en la variable puntuaciones.
     *
     * @return Los 5 mejores jugadores.
     */
    public static Puntuacion[] getPuntacion() {
        Puntuacion[] puntuaciones = new Puntuacion[5];
        try {
            String linea;
            BufferedReader br = new BufferedReader(new java.io.FileReader("Datos/Puntuacion.txt"));
            for (int i = 0; i < puntuaciones.length; i++) {
                linea = br.readLine();
                if (linea != null) {
                    String[] columna = linea.split(", ");
                    puntuaciones[i] = new Puntuacion(columna[0], columna[1], columna[2]);
                }
            }
            br.close();
        } catch (IOException exception) { //En caso de que no esta Puntuacion.txt
            for (int i = 0; i < puntuaciones.length; i++) {
                puntuaciones[i] = new Puntuacion(" ", " ", " ");
            }
        }
        return puntuaciones;
    }
}
