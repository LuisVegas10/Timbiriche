package sonido;

import java.applet.Applet;
import java.applet.AudioClip;

/**
 * <code>Sonido</code> contiene los sonido que va a reproducir el programa.
 *
 * @author Vegas Luis
 * @author Marcano Oriana
 * @version 1.0
 */
public class Sonido {

    public static final AudioClip JUEGO = Applet.newAudioClip(Sonido.class.getResource("/sonido/Juego.wav"));
    public static final AudioClip CLICK = Applet.newAudioClip(Sonido.class.getResource("/sonido/Click.wav"));
    public static final AudioClip GANAR = Applet.newAudioClip(Sonido.class.getResource("/sonido/Ganar.wav"));
}
