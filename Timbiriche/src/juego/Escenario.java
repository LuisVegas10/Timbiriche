package juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.RenderingHints;
import java.awt.Shape;

/**
 * <code>Escenario</code> es la uqe hace todo el proceso del juego.
 *
 * @see javax.swing.JPanel
 * @author Vegas Luis
 * @author Marcano Oriana
 * @version 1.0
 */
public class Escenario extends javax.swing.JPanel {

    private Point pPosicion;
    private final Object[][] escenario;
    private final String ESPACIO_VACIO = "VACIO", LINEA_VACIO = "0", LINEA_OCUPADA = "1";
    private final int TAMAÑO_TOTAL;
    private final Juego juego;

    /**
     * El contrucotr de {@link Escenario} principal.
     * @param juego
     * @param tamaño 
     */
    public Escenario(Juego juego, int tamaño) {
        this.juego = juego;
        setBackground(Color.white);
        setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 1, Color.black));
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent event) {
                Point point = null;
                for (int y = 0; y < escenario.length; y += 2) {
                    for (int x = 0; x < escenario[y].length; x += 2) {
                        Ellipse2D r = (Ellipse2D) escenario[y][x];
                        if (r.contains(event.getPoint())) {
                            point = new Point(x, y);
                            break;
                        }
                    }
                }
                if (point != null) {
                    if (pPosicion == null) {
                        pPosicion = point;
                        Graphics2D g2d = (Graphics2D) getGraphics();
                        g2d.setColor(juego.getColor());
                        g2d.fillOval((point.x * 21), (point.y * 21), 11, 11);
                    } else {
                        if (isPosible(point)) {
                            int x, y;
                            if (pPosicion.x == point.x) {
                                x = pPosicion.x;
                                y = pPosicion.y > point.y ? pPosicion.y - 1 : pPosicion.y + 1;
                            } else {
                                x = pPosicion.x > point.x ? pPosicion.x - 1 : pPosicion.x + 1;
                                y = pPosicion.y;
                            }
                            if (escenario[y][x].equals(LINEA_VACIO)) {
                                escenario[y][x] = LINEA_OCUPADA;
                                if (!isFormaCuadro(x, y, pPosicion.x == point.x)) {
                                    juego.cambio();
                                }
                                juego.completo();
                            }
                        }
                        pPosicion = null;
                        repaint();
                    }
                }
            }
        });
        TAMAÑO_TOTAL = (tamaño - 1) * (tamaño - 1);
        tamaño = tamaño * 2 - 1;
        escenario = new Object[tamaño][tamaño];
        for (int y = 0; y < escenario.length; y++) {
            for (int x = 0; x < escenario[y].length; x++) {
                if ((y % 2) == 0 && (x % 2) == 0) {
                    escenario[y][x] = new Ellipse2D.Double((x * 21), (y * 21), 10, 10);
                } else if ((y % 2) == 1 && (x % 2) == 1) {
                    escenario[y][x] = new Punto(ESPACIO_VACIO, Color.white);
                } else {
                    escenario[y][x] = LINEA_VACIO;
                }
            }
        }
    }

    private class Punto {

        public String letra;
        public Color color;

        public Punto(String letra, Color color) {
            this.letra = letra;
            this.color = color;
        }
    }

    protected int getTamaño() {
        return TAMAÑO_TOTAL;
    }

    private boolean isFormaCuadro(int x, int y, boolean bandera) {
        boolean forma = false;
        if (bandera) {
            if (x != escenario.length - 1) {
                forma = isCuadrado(y, x + 1);
            }
            if (x != 0) {
                forma = isCuadrado(y, x - 1) || forma;
            }
        } else {
            if (y != escenario.length - 1) {
                forma = isCuadrado(y + 1, x);
            }
            if (y != 0) {
                forma = isCuadrado(y - 1, x) || forma;
            }
        }
        return forma;
    }

    private boolean isCuadrado(int y, int x) {
        if (isLinea(y + 1, x) && isLinea(y - 1, x) && isLinea(y, x + 1) && isLinea(y, x - 1)) {
            escenario[y][x] = new Punto(juego.getLetra() + "", juego.getColor());
            juego.aumentarPunto();
            return true;
        } else {
            return false;
        }
    }

    private boolean isLinea(int y, int x) {
        return escenario[y][x].equals(LINEA_OCUPADA);
    }

    private boolean isPosible(Point destino) {
        return !pPosicion.equals(destino) && !(pPosicion.x != destino.x && pPosicion.y != destino.y) && (Math.abs(pPosicion.x - destino.x) <= 2 && Math.abs(pPosicion.y - destino.y) <= 2);
    }

    @Override
    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        g2d.setColor(Color.black);
        for (int y = 0; y < escenario.length; y++) {
            for (int x = 0; x < escenario[y].length; x++) {
                if ((y % 2) == 0 && (x % 2) == 0) {
                    g2d.draw((Shape) escenario[y][x]);
                    g2d.fillOval(x * 21, y * 21, 11, 11);
                } else if ((y % 2) == 1 && (x % 2) == 1) {
                    Punto punto = (Punto) escenario[y][x];
                    if (!punto.letra.equals(ESPACIO_VACIO)) {
                        g2d.setColor(punto.color);
                        g2d.drawString(punto.letra, x * 21, y * 21 + 13);
                        g2d.setColor(Color.black);
                    }
                } else if (escenario[y][x].equals(LINEA_OCUPADA)) {
                    if ((y % 2) == 1 && (x % 2) == 0) {
                        g2d.fillRect((x * 21) + 4, (y - 1) * 21, 3, 51);
                    } else if ((y % 2) == 0 && (x % 2) == 1) { //X
                        g2d.fillRect((x - 1) * 21, (y * 21) + 4, 51, 3);
                    }
                }
            }
        }
    }
}
