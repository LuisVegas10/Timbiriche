package informacicon;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;

/**
 * <code>AcercaDe</code> Muestra la informacion general del programa y una
 * pequeña informacion de como jugar el juego.
 *
 * @see javax.swing.JDialog
 * @author Vegas Luis
 * @author Marcano Oriana
 * @version 1.0
 */
public class AcercaDe extends javax.swing.JDialog {

    /**
     * El contrucotr de {@link AcercaDe} principal.
     */
    public AcercaDe() {
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);
        setSize(400, 500);
        setUndecorated(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.black);

        JButton btnSalir = new JButton();
        btnSalir.setBounds(358, 5, 34, 33);
        btnSalir.setBorder(null);
        btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSalir.setIcon(new ImageIcon("Datos/X.png"));
        btnSalir.setRolloverIcon(new ImageIcon("Datos/X2.png"));
        btnSalir.addActionListener((java.awt.event.ActionEvent event) -> {
            sonido.Sonido.CLICK.play();
            dispose();
        });
        add(btnSalir);

        JScrollPane scrllVentana = new JScrollPane(new Ventana());
        scrllVentana.setBounds(1, 43, 398, 456);
        scrllVentana.setBorder(null);
        add(scrllVentana);
    }

    /**
     * Una clase interna que es la muestra toda la informacion disponible.
     *
     * @see javax.swing.JPanel
     */
    private class Ventana extends javax.swing.JPanel {

        /**
         * El contrucotr de {@link Ventana} principal.
         */
        public Ventana() {
            setPreferredSize(new java.awt.Dimension(381, 880)); //El tamaño que vaa tener el panel
            setBackground(Color.white);
        }

        @Override
        public void paintComponent(java.awt.Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2d.drawImage(new ImageIcon("Datos/Icono2.png").getImage(), 132, 10, null);
            g2d.setFont(new Font("Arial", Font.BOLD, 20));
            g2d.drawString("Timbiriche", 138, 160);
            g2d.setFont(new Font("Arial", Font.PLAIN, 16));
            g2d.drawString("Version: 1.0", 148, 180);

            g2d.drawImage(new ImageIcon("Datos/Infor.png").getImage(), 0, 200, null);
            g2d.drawImage(new ImageIcon("Datos/Ejemplo.png").getImage(), 40, 520, null);

            g2d.drawString("Desarrollado por:", 150, 845);
            g2d.drawString("Marcano Oriana y Vegas Luis", 100, 865);
        }
    }

    @Override
    public void paint(java.awt.Graphics g) {
        super.paint(g);
        g.setColor(Color.white);
        g.fillRect(1, 1, 398, 42);
    }
}
