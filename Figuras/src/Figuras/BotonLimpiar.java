package Figuras;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class BotonLimpiar implements ActionListener {

    Lienzo lienzo;

    public BotonLimpiar(Lienzo lienzo) {
        this.lienzo = lienzo;
    }

    public void actionPerformed(ActionEvent ae) {
        lienzo.repaint();
    }
}
