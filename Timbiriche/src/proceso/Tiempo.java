package proceso;

import java.awt.Font;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JLabel;

/**
 * <code>Tiempo</code> Calcula el tiempo de juego que lleva la partida.
 *
 * @see javax.swing.Thread
 * @author Vegas Luis
 * @author Marcano Oriana
 * @version 1.0
 */
public class Tiempo extends Thread {

    private final JLabel lblTiempo;
    private int nSegundos = 0;

    /**
     * El contrucotr de {@link Tiempo} principal.
     */
    public Tiempo() {
        lblTiempo = new JLabel();
        lblTiempo.setBounds(210, 10, 80, 30);
        lblTiempo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));    //Cambia el diseño del bordel de la etiqueta
        lblTiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTiempo.setFont(new Font(Font.DIALOG, Font.PLAIN, 12));
    }

    /**
     * Esta funcion retorna el lblTiempo para que se agrege a
     * {@link juego.Juego}.
     *
     * @return
     */
    public java.awt.Component getlblTiempo() {
        return lblTiempo;
    }

    /**
     * Estaa funcion retorna el texto de {@code lblTiempo}.
     *
     * @return
     */
    public String getText() {
        return lblTiempo.getText();
    }

    /**
     * Esta funcion calcula la duracion de la partida en base a los segundos
     * acumulados desde que comenzo el juego.
     *
     * @return
     */
    private String calcularTiempo() {
        double minutos = (double) nSegundos / 60;
        int segundos = new BigDecimal((minutos - (int) minutos) * 60).setScale(0, RoundingMode.HALF_UP).intValue();
        double horas = minutos / 60;
        minutos = new BigDecimal((horas - (int) horas) * 60).setScale(0, RoundingMode.HALF_UP).intValue();
        String duracion = ((int) horas < 10 ? "0" : "") + (int) horas + "h " + (((int) minutos < 10 ? "0" : "") + (int) minutos) + "m " + (segundos < 10 ? "0" : "") + segundos + "s";
        return duracion;
    }

    @Override
    public void run() {
        while (true) {
            try {
                nSegundos++;                        //Aumenta el segundo
                lblTiempo.setText(calcularTiempo());//Establece la duracion en el lblTiempo
                Thread.sleep(1000);                 //indica que se va a repetir cada 1 segundo
            } catch (InterruptedException exception) {
            }
        }
    }
}
