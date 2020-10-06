package Figuras;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

class Lienzo extends Canvas implements MouseListener, MouseMotionListener {

    int mx;
    int my;
    int x2;
    int y2;
    int op;
    int alto, ancho;
    String posX, posY;
    Principal ven;
    private Color color = Color.black;

    public Lienzo(Principal ven) {
        super();
        setBackground(Color.BLACK);
        addMouseListener(this);
        addMouseMotionListener(this);
        this.ven = ven;
        ven.limpiar.addActionListener(new BotonLimpiar(this));
        ven.sliderAlto.addChangeListener(new Alto(this));
        ven.sliderAncho.addChangeListener(new Ancho(this));
    }

    public void mouseClicked(MouseEvent e) {
        if (op == 2 || op == 3) {
            ven.sliderAlto.setEnabled(true);
            ven.sliderAncho.setEnabled(true);
        }
    }

    public void mousePressed(MouseEvent e) {

        mx = e.getX();
        my = e.getY();
        op = ven.i;
        Graphics g = getGraphics();
        color = ven.jlcolor.getForeground();
        g.setColor(color);
        if (op == 2) {
            g.drawRect(mx, my, ancho, alto);
        } else if (op == 3) {

            g.drawOval(mx, my, ancho, alto);
        }
    }

    public void mouseReleased(MouseEvent e) {
        op = ven.i;
        color = ven.jlcolor.getForeground();
        Graphics g = getGraphics();
        g.setColor(color);
        if (op == 1) {
            g.drawLine(mx, my, e.getX(), e.getY());
        }
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        //repaint();
        op = ven.i;
        Graphics g = getGraphics();
        g.setColor(color);
        if (op == 4) {
            g.drawLine(mx, my, x, y);
            mx = x;
            my = y;
            g.dispose();
        }
        posX = "Coordenada x: \n" + String.valueOf(e.getX());
        ven.xpos.setText(posX);
        posY = "Coordenada y: ln" + String.valueOf(e.getY());
        ven.ypos.setText(posY);

    }

    public void mouseMoved(MouseEvent e) {
        posX = "Coordenada x: \n" + String.valueOf(e.getX());
        ven.xpos.setText(posX);
        posY = "Coordenada y: \n" + String.valueOf(e.getY());
        ven.ypos.setText(posY);

    }

    public void paint(Graphics g) {
        super.paint(g);
    }

    public void update(Graphics g) {

        super.update(g);
        paint(g);
    }

    public void nuevoColor() {
        this.color = ven.color;
    }
}
