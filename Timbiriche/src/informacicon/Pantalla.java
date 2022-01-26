package informacicon;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import juego.Juego;
import ventanas.Inicio;

/**
 * <code>Pantalla</code> pide los 2 nombres de los jugadores y el nivel en que
 * se va a jugar.
 *
 * @see javax.swing.JDialog
 * @see java.awt.event.ActionListener
 * @author Vegas Luis
 * @author Marcano Oriana
 * @version 1.0
 */
public class Pantalla extends javax.swing.JDialog implements java.awt.event.ActionListener {

    private final JButton btnIngresar, btnCancelar;
    private final JTextField txfNombre1, txfNombre2;
    private final JToggleButton tbtnSecillo, tbtnNormal, tbtnComlicado;
    private int nTamaño;
    private final Inicio inicio;

    /**
     * El contrucotr de {@link Pantalla} principal.
     */
    public Pantalla(Inicio inicio) {
        this.inicio = inicio;
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);
        setSize(559, 213);
        setUndecorated(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);

        txfNombre1 = new JTextField();
        txfNombre1.setBounds(44, 30, 156, 36);
        txfNombre1.setBorder(null);
        txfNombre1.setOpaque(false);
        txfNombre1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txfNombre1.setHorizontalAlignment(JTextField.CENTER);
        add(txfNombre1);

        JLabel lblIcon_1 = new JLabel();    //Muestra la imagen de diseño para el JTextField
        lblIcon_1.setBounds(40, 30, 164, 36);
        lblIcon_1.setIcon(new ImageIcon("Datos/Image.png"));
        add(lblIcon_1);

        txfNombre2 = new JTextField();
        txfNombre2.setBounds(354, 30, 156, 36);
        txfNombre2.setBorder(null);
        txfNombre2.setOpaque(false);
        txfNombre2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txfNombre2.setHorizontalAlignment(JTextField.CENTER);
        add(txfNombre2);

        JLabel lblIcon_2 = new JLabel();
        lblIcon_2.setBounds(354, 30, 164, 36);
        lblIcon_2.setIcon(new ImageIcon("Datos/Image.png"));
        add(lblIcon_2);

        ButtonGroup bg = new ButtonGroup(); //Agrupa los botones para que solo uno pueda estar seleccionado
        tbtnSecillo = new JToggleButton();  //Un boton en dos posiciones, si esta seleccionado o si no esta seleccionado
        tbtnSecillo.setBounds(40, 88, 164, 36);
        tbtnSecillo.setBorder(null);
        tbtnSecillo.setContentAreaFilled(false);
        tbtnSecillo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tbtnSecillo.setIcon(new ImageIcon("Datos/Image.png"));
        tbtnSecillo.setRolloverIcon(new ImageIcon("Datos/Image2.png"));
        tbtnSecillo.setSelectedIcon(new ImageIcon("Datos/Image2.png")); //La imagen que se va a mostrar cuando el boton este seleccionado
        tbtnSecillo.setFont(new Font("Bookman Old Style", Font.PLAIN, 24));
        tbtnSecillo.setForeground(Color.black);
        tbtnSecillo.setText("Sencillo");
        tbtnSecillo.setHorizontalTextPosition(SwingConstants.CENTER);
        tbtnSecillo.setToolTipText("Dificulta Sencillo.");
        tbtnSecillo.addActionListener(this);
        add(tbtnSecillo);
        bg.add(tbtnSecillo);    //Agrega el boton al ButtonGroup

        tbtnNormal = new JToggleButton();
        tbtnNormal.setBounds(197, 88, 164, 36);
        tbtnNormal.setBorder(null);
        tbtnNormal.setContentAreaFilled(false);
        tbtnNormal.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tbtnNormal.setIcon(new ImageIcon("Datos/Image.png"));
        tbtnNormal.setRolloverIcon(new ImageIcon("Datos/Image2.png"));
        tbtnNormal.setSelectedIcon(new ImageIcon("Datos/Image2.png"));
        tbtnNormal.setFont(new Font("Bookman Old Style", Font.PLAIN, 24));
        tbtnNormal.setForeground(Color.black);
        tbtnNormal.setText("Normal");
        tbtnNormal.setHorizontalTextPosition(SwingConstants.CENTER);
        tbtnNormal.setToolTipText("Dificulta Normal.");
        tbtnNormal.addActionListener(this);
        add(tbtnNormal);
        bg.add(tbtnNormal);

        tbtnComlicado = new JToggleButton();
        tbtnComlicado.setBounds(354, 88, 164, 36);
        tbtnComlicado.setBorder(null);
        tbtnComlicado.setContentAreaFilled(false);
        tbtnComlicado.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tbtnComlicado.setIcon(new ImageIcon("Datos/Image.png"));
        tbtnComlicado.setRolloverIcon(new ImageIcon("Datos/Image2.png"));
        tbtnComlicado.setSelectedIcon(new ImageIcon("Datos/Image2.png"));
        tbtnComlicado.setFont(new Font("Bookman Old Style", Font.PLAIN, 24));
        tbtnComlicado.setForeground(Color.black);
        tbtnComlicado.setText("Complicada");
        tbtnComlicado.setHorizontalTextPosition(SwingConstants.CENTER);
        tbtnComlicado.setToolTipText("Dificulta Complicada.");
        tbtnComlicado.addActionListener(this);
        add(tbtnComlicado);
        bg.add(tbtnComlicado);

        btnIngresar = new JButton();
        btnIngresar.setBounds(40, 146, 164, 36);
        btnIngresar.setBorder(null);
        btnIngresar.setContentAreaFilled(false);
        btnIngresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnIngresar.setIcon(new ImageIcon("Datos/Image.png"));
        btnIngresar.setRolloverIcon(new ImageIcon("Datos/Image2.png"));
        btnIngresar.setFont(new Font("Bookman Old Style", Font.PLAIN, 24));
        btnIngresar.setForeground(Color.black);
        btnIngresar.setText("Ingresar");
        btnIngresar.setHorizontalTextPosition(SwingConstants.CENTER);
        btnIngresar.setToolTipText("Pasar a jugar.");
        btnIngresar.addActionListener(this);
        add(btnIngresar);

        btnCancelar = new JButton();
        btnCancelar.setBounds(354, 146, 164, 36);
        btnCancelar.setBorder(null);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCancelar.setIcon(new ImageIcon("Datos/Image.png"));
        btnCancelar.setRolloverIcon(new ImageIcon("Datos/Image2.png"));
        btnCancelar.setFont(new Font("Bookman Old Style", Font.PLAIN, 24));
        btnCancelar.setForeground(Color.black);
        btnCancelar.setText("Cancelar");
        btnCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
        btnCancelar.setToolTipText("Regresar al menu.");
        btnCancelar.addActionListener(this);
        add(btnCancelar);
    }

    @Override
    public void paint(java.awt.Graphics g) {
        super.paint(g);

        g.drawLine(0, 0, 558, 0);
        g.drawLine(558, 0, 558, 212);
        g.drawLine(0, 0, 0, 212);
        g.drawLine(0, 212, 558, 212);
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.drawString("Ingrese nombre del jugador 1:", 20, 22);
        g.drawString("Ingrese nombre del jugador 2:", 334, 22);
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent event) {
        sonido.Sonido.CLICK.play();
        if (event.getSource() == tbtnSecillo) {
            nTamaño = 5;
        } else if (event.getSource() == tbtnNormal) {
            nTamaño = 7;
        } else if (event.getSource() == tbtnComlicado) {
            nTamaño = 10;
        } else if (event.getSource() == btnIngresar) {
            String nombre_1 = txfNombre1.getText(), nombre_2 = txfNombre2.getText();
            if (!tbtnSecillo.isSelected() && !tbtnNormal.isSelected() && !tbtnComlicado.isSelected()) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar la dificultad.", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
            } else if (nombre_1.isEmpty() || nombre_2.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe Ingresar los 2 nombres.", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
            } else if (nombre_1.equalsIgnoreCase(nombre_2)) {
                JOptionPane.showMessageDialog(null, "Los nombres deben ser diferentes.", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
            } else if (nombre_1.length() < 4 || nombre_2.length() < 4) {
                JOptionPane.showMessageDialog(null, "Los nombres deben tener mínimo de 4 letras.", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
            } else if (nombre_1.length() > 12 || nombre_2.length() > 12) {
                JOptionPane.showMessageDialog(null, "Los nombres deben tener máximo de 12 letras.", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
            } else if (nombre_1.contains(" ") || nombre_1.contains(" ")) {
                JOptionPane.showMessageDialog(null, "Los nombres no pueden tener espacios.", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
            } else {
                nombre_1 = nombre_1.toLowerCase();
                nombre_1 = nombre_1.replaceFirst(nombre_1.charAt(0) + "", (nombre_1.charAt(0) + "").toUpperCase());
                nombre_2 = nombre_2.toLowerCase();
                nombre_2 = nombre_2.replaceFirst(nombre_2.charAt(0) + "", (nombre_2.charAt(0) + "").toUpperCase());
                new Juego(nombre_1, nombre_2, nTamaño).setVisible(true);
                inicio.dispose();
                dispose();
            }
        } else if (event.getSource() == btnCancelar) {
            dispose();
        }
    }
}
