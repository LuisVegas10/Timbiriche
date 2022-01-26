package informacicon;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * <code>Estadisticas</code> muestra los 5 mejoress jugadores que an ganado un
 * juego.
 *
 * @see javax.swing.JDialog
 * @author Vegas Luis
 * @author Marcano Oriana
 * @version 1.0
 */
public class Estadisticas extends javax.swing.JDialog {

    private proceso.Puntuacion[] puntuaciones = proceso.Proceso.getPuntacion();

    /**
     * El contrucotr de {@link Estadisticas} principal.
     */
    public Estadisticas() {
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);                                 //Deja a Inicio en estado inativo hasta que se cierra Estadisticas
        setSize(501, 151);
        setUndecorated(true);                           //Quita el marco
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);

        JTable tblLista = new JTable();
        tblLista.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
        DefaultTableModel dftmLista = new DefaultTableModel() {             //Creo la tabla del tblLista
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;   //Indico que no se puede modifical el contenido
            }
        };
        dftmLista.addColumn("#");       //Agrego las columnas
        dftmLista.addColumn("Nombre");
        dftmLista.addColumn("Tiempo");
        dftmLista.addColumn("Puntacion");
        for (int i = 0; i < puntuaciones.length; i++) { //Agrego las filas
            dftmLista.addRow(new Object[]{(i + 1), puntuaciones[i].nombre, puntuaciones[i].tiempo, puntuaciones[i].puntacion});
        }
        tblLista.setModel(dftmLista); //Agrego el model al tblLista
        for (int i = 0; i < dftmLista.getColumnCount(); i++) {
            tblLista.getColumnModel().getColumn(i).setResizable(false); //Indico que no se pueda cambiar el tamaño de las columnas
        }
        tblLista.getColumnModel().getColumn(0).setPreferredWidth(30);   //Establezco el tamaño de la columna
        tblLista.getColumnModel().getColumn(1).setPreferredWidth(220);
        tblLista.getColumnModel().getColumn(2).setPreferredWidth(95);
        tblLista.getColumnModel().getColumn(3).setPreferredWidth(95);
        tblLista.getTableHeader().setReorderingAllowed(false);          //Indico que no se puedan mover las posiciones de las clumnas por otras
        DefaultTableCellRenderer dftcLista = new DefaultTableCellRenderer();
        dftcLista.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);    //Indico que el texto se ponga en el centro
        tblLista.getColumnModel().getColumn(0).setCellRenderer(dftcLista);
        tblLista.getColumnModel().getColumn(2).setCellRenderer(dftcLista);
        tblLista.getColumnModel().getColumn(3).setCellRenderer(dftcLista);
        JScrollPane scrllLista = new JScrollPane();
        scrllLista.setViewportView(tblLista);
        scrllLista.setBounds(30, 31, 440, 103);
        add(scrllLista);

        JButton btnSalir = new JButton();
        btnSalir.setBounds(465, 2, 34, 33);
        btnSalir.setBorder(null);
        btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSalir.setIcon(new ImageIcon("Datos/X.png"));
        btnSalir.setRolloverIcon(new ImageIcon("Datos/X2.png"));
        btnSalir.addActionListener((java.awt.event.ActionEvent event) -> {
            sonido.Sonido.CLICK.play();
            dispose();
        });
        add(btnSalir);
    }

    @Override
    public void paint(java.awt.Graphics g) {
        super.paint(g);

        g.drawLine(0, 0, 500, 0);
        g.drawLine(500, 0, 500, 150);
        g.drawLine(0, 0, 0, 150);
        g.drawLine(0, 150, 500, 150);
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.drawString("Mejores 5 jugadores:", 30, 22);
        g.drawImage(new ImageIcon("Datos/Estilo.png").getImage(), 0, 28, null);
    }
}
