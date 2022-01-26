package juego;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import proceso.Jugador;
import proceso.Proceso;
import proceso.Puntuacion;
import proceso.Tiempo;
import sonido.Sonido;

/**
 * <code>Juego</code> es la ventana en la que se va a jugar y muestra los
 * nombre, el tiempo y los botones de rendicion y el escenario del juego.
 *
 * @see javax.swing.JFrame
 * @see java.awt.event.ActionListener
 * @author Vegas Luis
 * @author Marcano Oriana
 * @version 1.0
 */
public class Juego extends javax.swing.JFrame implements java.awt.event.ActionListener {

    private final JButton btnJugador1, btnSonido, btnSinSonido, btnJugador2;
    private final JLabel lblJugador1, lblJugador2;
    private boolean isBandera = (int) (Math.random() * 2) == 1, //Rando si comienza el jugador 1 o el jgador 2.
            isDecisionFinal;
    private final Escenario escenario;
    private final Jugador[] jugador;
    private final Tiempo thrd1;

    /**
     * El contrucotr de {@link Juego} principal.
     *
     * @param nombre1 Nombre del jugador 1.
     * @param nombre2 Nombre del jugador 2.
     * @param tamaño Tamaño que va tener el escenario.
     */
    public Juego(String nombre1, String nombre2, int tamaño) {
        jugador = new Jugador[]{new Jugador(nombre1, new Color(255, 192, 0), 0, false), //Crear los perfiles de los jugadores
            new Jugador(nombre2, new Color(0, 176, 240), 0, false)};
        setLayout(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Timbiriche");
        setSize(506, 529);
        setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon("Datos/Icono.png").getImage());
        getContentPane().setBackground(Color.white);

        lblJugador1 = new JLabel();
        lblJugador1.setBounds(10, 10, 190, 30);
        lblJugador1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED)); //Cambio el borde
        lblJugador1.setHorizontalAlignment(SwingConstants.CENTER);                  //Que el texto aparezca centrado
        lblJugador1.setFont(new Font(Font.DIALOG, Font.BOLD, 12));
        lblJugador1.setForeground(new Color(255, 192, 0));
        lblJugador1.setText("Jugador 1: " + jugador[0].nombre);
        add(lblJugador1);

        lblJugador2 = new JLabel();
        lblJugador2.setBounds(300, 10, 190, 30);
        lblJugador2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        lblJugador2.setHorizontalAlignment(SwingConstants.CENTER);
        lblJugador2.setFont(new Font(Font.DIALOG, Font.BOLD, 12));
        lblJugador2.setForeground(new Color(0, 176, 240));
        lblJugador2.setText("Jugador 2: " + jugador[1].nombre);
        add(lblJugador2);

        escenario = new Escenario(this, tamaño);
        switch (tamaño) {
            case 5:
                escenario.setBounds(160, 160, 179, 179);
                break;
            case 7:
                escenario.setBounds(118, 118, 263, 263);
                break;
            default:
                escenario.setBounds(55, 55, 389, 389);
                break;
        }
        add(escenario);

        btnJugador1 = new JButton();
        btnJugador1.setBounds(50, 460, 140, 30);
        btnJugador1.setBorder(null);
        btnJugador1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnJugador1.setIcon(new ImageIcon("Datos/Image3.png"));
        btnJugador1.setRolloverIcon(new ImageIcon("Datos/Image4.png"));
        btnJugador1.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
        btnJugador1.setForeground(new Color(255, 192, 0));
        btnJugador1.setHorizontalTextPosition(SwingConstants.CENTER);
        btnJugador1.setText("Rendirse");
        btnJugador1.setToolTipText("Si presiona el boron el Jugador 1 se rinde.");
        btnJugador1.addActionListener(this);
        add(btnJugador1);

        btnSonido = new JButton();
        btnSonido.setBounds(233, 460, 34, 33);
        btnSonido.setBorder(null);
        btnSonido.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSonido.setIcon(new ImageIcon("Datos/Sonido1.png"));
        btnSonido.setRolloverIcon(new ImageIcon("Datos/Sonido2.png"));
        btnSonido.setToolTipText("Presionar este boton quita el sonido.");
        btnSonido.addActionListener(this);
        add(btnSonido);

        btnSinSonido = new JButton();
        btnSinSonido.setBounds(233, 460, 34, 33);
        btnSinSonido.setVisible(false);
        btnSinSonido.setBorder(null);
        btnSinSonido.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSinSonido.setIcon(new ImageIcon("Datos/Sonido3.png"));
        btnSinSonido.setRolloverIcon(new ImageIcon("Datos/Sonido4.png"));
        btnSinSonido.setToolTipText("Presionar este boton pone el sonido.");
        btnSinSonido.addActionListener(this);
        add(btnSinSonido);

        btnJugador2 = new JButton();
        btnJugador2.setBounds(310, 460, 140, 30);
        btnJugador2.setBorder(null);
        btnJugador2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnJugador2.setIcon(new ImageIcon("Datos/Image3.png"));
        btnJugador2.setRolloverIcon(new ImageIcon("Datos/Image4.png"));
        btnJugador2.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
        btnJugador2.setForeground(new Color(0, 176, 240));
        btnJugador2.setText("Rendirse");
        btnJugador2.setHorizontalTextPosition(SwingConstants.CENTER);
        btnJugador2.setToolTipText("Si presiona el boron el Jugador 2 se rinde.");
        btnJugador2.addActionListener(this);
        add(btnJugador2);

        cambio();   //Asigna el primer cambio

        thrd1 = new Tiempo();
        add(thrd1.getlblTiempo());  //Agrega el lblTiempo a la ventana
        thrd1.start();              //Empieza a correr el tiempo
        Sonido.JUEGO.loop();        //Empieza la musica
    }

    /**
     * Esta funcion retorna la letra del jugador que esta jugando el turno.
     *
     * @return Retorna la letra del jugador que esta jugando el turno.
     */
    public char getLetra() {
        return jugador[Jugador.getBoolean(isBandera)].nombre.charAt(0);
    }

    /**
     * Esta funcion retorna el color del jugador que esta jugando el turno.
     *
     * @return Retorna el color del jugador que esta jugando el turno.
     */
    public Color getColor() {
        return jugador[Jugador.getBoolean(isBandera)].color;
    }

    /**
     * Este metodo si un jugador a formado un cuadrito gana un punto.
     */
    public void aumentarPunto() {
        jugador[Jugador.getBoolean(isBandera)].cantidad++;
    }

    /**
     * Este metodo cambia el turno de los jugadores.
     */
    public void cambio() {
        isBandera = !isBandera;
        btnJugador1.setEnabled(!isBandera);
        btnJugador2.setEnabled(isBandera);
    }

    /**
     * Este metodo verifica si el juego a sido completado.
     */
    public void completo() {
        if ((jugador[0].cantidad + jugador[1].cantidad) == escenario.getTamaño()) {
            escenario.repaint();
            finDeJuego();
        }
    }

    /**
     * Este metodo pone fin a los proceso del juego.
     */
    private void finDeJuego() {
        thrd1.stop();       //Detiene el proceso de la duracion de la partida
        String mensaje = "Jugador 1: " + jugador[0].nombre + ". Puntuacion: " + jugador[0].cantidad + " ",
                juegador2 = "\nJugador 2: " + jugador[1].nombre + ". Puntuacion: " + jugador[1].cantidad + " ";
        if (jugador[0].cantidad == jugador[1].cantidad && !jugador[0].rendido && !jugador[1].rendido) {
            mensaje += "Empate" + juegador2 + "Empate";
            empate(); //Si se dio un empate
        } else {
            isDecisionFinal = (jugador[0].cantidad > jugador[1].cantidad && !jugador[0].rendido) || jugador[1].rendido;
            if (isDecisionFinal) {  //Si gano el juagor 1
                mensaje += "Gano" + juegador2 + "Perdio";
            } else {                //Si gano el jugador 2
                mensaje += "Perdio" + juegador2 + "Gano";
            }
            estadisticas();
        }
        mensaje += "\nTiempo de Juego: " + thrd1.getText() + ".";
        Sonido.JUEGO.stop();    //Detiene la musica
        Sonido.GANAR.play();
        JOptionPane.showMessageDialog(null, mensaje, "Juego Finalizado", JOptionPane.INFORMATION_MESSAGE);
        new ventanas.Inicio().setVisible(true); //Regresa al Inicio
        dispose();  //Destruye esta ventana
    }

    /**
     * Este metodo compara el puntaje de los jugadores con el de los anteriores
     * jugadores.
     */
    public void empate() {
        Puntuacion[] puntuaciones = Proceso.getPuntacion();
        isDecisionFinal = false;
        puntuaciones = calcularPuntuacion(puntuaciones);
        isDecisionFinal = true;
        puntuaciones = calcularPuntuacion(puntuaciones);
        Proceso.setPuntacion(puntuaciones);
    }

    /**
     * Este metodo compara el puntaje del jugador con el de los anteriores
     * jugadores.
     */
    public void estadisticas() {
        Puntuacion[] puntuaciones = Proceso.getPuntacion();
        calcularPuntuacion(puntuaciones);
        Proceso.setPuntacion(puntuaciones);
    }

    /**
     * Busca si la puntuacion de el/los jugador/jugadores es mejor a la de los
     * jugadores que an jugador antes.
     *
     * @param puntuaciones Top 5 de los mejores jugadores.
     * @return Nuevo Top 5 de los mejores jugadores.
     */
    public Puntuacion[] calcularPuntuacion(Puntuacion[] puntuaciones) {
        for (int i = 0; i < puntuaciones.length; i++) {
            String[] marca = puntuaciones[i].puntacion.split("/");
            try {
                if (jugador[Jugador.getBoolean(!isDecisionFinal)].cantidad > Integer.parseInt(marca[0])) {
                    for (int j = 4; j > i; j--) {
                        puntuaciones[j].mover(puntuaciones[j - 1]);
                    }
                    puntuaciones[i].mover(jugador[Jugador.getBoolean(!isDecisionFinal)].nombre, thrd1.getText(), jugador[Jugador.getBoolean(!isDecisionFinal)].cantidad + "/" + escenario.getTamaño());
                    break;
                }
            } catch (NumberFormatException exception) {
                puntuaciones[i].mover(jugador[Jugador.getBoolean(!isDecisionFinal)].nombre, thrd1.getText(), jugador[Jugador.getBoolean(!isDecisionFinal)].cantidad + "/" + escenario.getTamaño());
                break;
            }
        }
        return puntuaciones;
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent event) {
        Sonido.CLICK.play();
        if (event.getSource() == btnJugador1) {
            jugador[0].rendido = true;
            finDeJuego();
        } else if (event.getSource() == btnSonido) {
            btnSonido.setVisible(false);
            btnSinSonido.setVisible(true);
            Sonido.JUEGO.stop();
        } else if (event.getSource() == btnSinSonido) {
            btnSonido.setVisible(true);
            btnSinSonido.setVisible(false);
            Sonido.JUEGO.loop();
        } else if (event.getSource() == btnJugador2) {
            jugador[1].rendido = true;
            finDeJuego();
        }
    }

    public static void main(String[] args) {
        new Juego("Luis", "Vegas", 5).setVisible(true);
    }
}
