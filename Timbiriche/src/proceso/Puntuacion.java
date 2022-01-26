package proceso;

/**
 * <code>Puntuacion</code> acumula los datos de los 5 mejores jugadores.
 *
 * @author Vegas Luis
 * @author Marcano Oriana
 * @version 1.0
 */
public class Puntuacion {

    public String nombre;
    public String tiempo;
    public String puntacion;

    /**
     * El contrucotr de {@link Puntuacion} principal.
     *
     * @param nombre Nombre del jugador.
     * @param tiempo Duracion de la partida.
     * @param puntacion Puntuacion que tuvo el juador en la partida.
     */
    public Puntuacion(String nombre, String tiempo, String puntacion) {
        this.nombre = nombre;
        this.tiempo = tiempo;
        this.puntacion = puntacion;
    }

    /**
     * Este metodo mueve los datos de posicion para indicar a un nuevo jugador en los 5
     * mejores.
     *
     * @param puntuacion Datos que se van a mover.
     */
    public void mover(Puntuacion puntuacion) {
        mover(puntuacion.nombre, puntuacion.tiempo, puntuacion.puntacion);
    }

    /**
     * Este metodo actualiza los nuevos datos.
     * @param nombre Nombre del jugador.
     * @param tiempo Duracion de la partida.
     * @param puntacion Puntuacion que tuvo el juador en la partida.
     */
    public void mover(String nombre, String tiempo, String puntacion) {
        this.nombre = nombre;
        this.tiempo = tiempo;
        this.puntacion = puntacion;
    }
}
