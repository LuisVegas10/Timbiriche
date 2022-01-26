package proceso;

import java.awt.Color;

/**
 * <code>Jugador</code> guarda la informacion de los jugadores.
 *
 * @author Vegas Luis
 * @author Marcano Oriana
 * @version 1.0
 */
public class Jugador {

    public String nombre;
    public Color color;
    public int cantidad;
    public boolean rendido;

    /**
     * El contrucotr de {@link Jugador} principal.
     * @param nombre
     * @param color
     * @param cantidad
     * @param rendido
     */
    public Jugador(String nombre, Color color, int cantidad, boolean rendido) {
        this.nombre = nombre;
        this.color = color;
        this.cantidad = cantidad;
        this.rendido = rendido;
    }

    /**
     * Esta funcion recible un boolean indicado los turno si es {@code true} es
     * turno del jugador 2 y si es {@code false} es turno del jugador 1.
     *
     * @param turno boolean indicado el turno del jugador.
     * @return El numero del jugador.
     */
    public static int getBoolean(boolean turno) {
        return turno ? 1 : 0; // posicion del arrelog 
    }
}
