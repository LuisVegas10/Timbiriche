package ventanas;

import informacicon.Estadisticas;
import informacicon.Pantalla;
import informacicon.AcercaDe;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 * <code>Inicio</code> contiene al metodo main y es el menu con la que inicia el
 * programa. Esta clase contiene 4 {@link JButton}.
 *
 * @see javax.swing.JFrame
 * @see java.awt.event.ActionListener
 * @author Vegas Luis
 * @author Marcano Oriana
 * @version 1.0
 */
public class Inicio extends javax.swing.JFrame implements java.awt.event.ActionListener {

    private final JButton btnJugar, btnAcercaDe, btnEstadisticas, btnSalir;

    /**
     * El contrucotr de {@link Inicio} principal.
     */
    public Inicio() {
        setLayout(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Timbiriche");
        setSize(370, 529);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);                //Establece el color del fondo
        setIconImage(new ImageIcon("Datos/Icono.png").getImage());  //Establece el icono del la clase

        btnJugar = new JButton();
        btnJugar.setBounds(100, 246, 164, 36);
        btnJugar.setBorder(null);                                       //Quita lo borde
        btnJugar.setContentAreaFilled(false);                           //Quita el fondo del boton
        btnJugar.setCursor(new Cursor(Cursor.HAND_CURSOR));             //Establece el puntero
        btnJugar.setIcon(new ImageIcon("Datos/Image.png"));             //Pone la imagen
        btnJugar.setRolloverIcon(new ImageIcon("Datos/Image2.png"));    //Pone la imagen de cuando el mouse esta en el boton
        btnJugar.setFont(new Font("Bookman Old Style", Font.PLAIN, 24));
        btnJugar.setForeground(Color.black);
        btnJugar.setText("Jugar");
        btnJugar.setHorizontalTextPosition(SwingConstants.CENTER);      //Que el Texto aparezca en el crento del boton
        btnJugar.setToolTipText("Inicia el juego.");                    //Un mensaje cuando el mouse esta sobre el boton
        btnJugar.addActionListener(this);
        add(btnJugar);

        btnAcercaDe = new JButton();
        btnAcercaDe.setBounds(100, 302, 164, 36);
        btnAcercaDe.setBorder(null);
        btnAcercaDe.setContentAreaFilled(false);
        btnAcercaDe.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAcercaDe.setIcon(new ImageIcon("Datos/Image.png"));
        btnAcercaDe.setRolloverIcon(new ImageIcon("Datos/Image2.png"));
        btnAcercaDe.setFont(new Font("Bookman Old Style", Font.PLAIN, 24));
        btnAcercaDe.setForeground(Color.black);
        btnAcercaDe.setText("Acerca De");
        btnAcercaDe.setHorizontalTextPosition(SwingConstants.CENTER);
        btnAcercaDe.setToolTipText("Muestra la informacion del programa.");
        btnAcercaDe.addActionListener(this);
        add(btnAcercaDe);

        btnEstadisticas = new JButton();
        btnEstadisticas.setBounds(100, 358, 164, 36);
        btnEstadisticas.setBorder(null);
        btnEstadisticas.setContentAreaFilled(false);
        btnEstadisticas.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEstadisticas.setIcon(new ImageIcon("Datos/Image.png"));
        btnEstadisticas.setRolloverIcon(new ImageIcon("Datos/Image2.png"));
        btnEstadisticas.setFont(new Font("Bookman Old Style", Font.PLAIN, 24));
        btnEstadisticas.setForeground(Color.black);
        btnEstadisticas.setText("Estadísticas");
        btnEstadisticas.setHorizontalTextPosition(SwingConstants.CENTER);
        btnEstadisticas.setToolTipText("Muestra la estadisticas del juego.");
        btnEstadisticas.addActionListener(this);
        add(btnEstadisticas);

        btnSalir = new JButton();
        btnSalir.setBounds(144, 414, 76, 36);
        btnSalir.setBorder(null);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSalir.setIcon(new ImageIcon("Datos/Salir.png"));
        btnSalir.setRolloverIcon(new ImageIcon("Datos/Salir2.png"));
        btnSalir.setToolTipText("Finaliza el programa.");
        btnSalir.addActionListener(this);
        add(btnSalir);

    }

    @Override
    public void paint(java.awt.Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        int x = 3, y = 26;  //Margen del marco

        g2d.drawImage(new ImageIcon("Datos/Fondo.png").getImage(), x, y, null);
        g2d.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));
        g2d.drawString("@2020 Proyectos Informaticos", x + 82, y + 490);
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent event) {
        sonido.Sonido.CLICK.play();
        if (event.getSource() == btnJugar) {
            new Pantalla(this).setVisible(true);
        } else if (event.getSource() == btnAcercaDe) {
            new AcercaDe().setVisible(true);
        } else if (event.getSource() == btnEstadisticas) {
            new Estadisticas().setVisible(true);
        } else if (event.getSource() == btnSalir) {
            System.exit(0);
        }
    }

    /**
     * El metodo que inicia el programa.
     *
     * @param args
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Inicio().setVisible(true);
        });
    }
}
