package Figuras;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JSlider;

public class Ancho implements ChangeListener {

    Lienzo lienzo;

    public Ancho(Lienzo lienzo) {
        this.lienzo = lienzo;
    }

    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        lienzo.ancho = slider.getValue();
    }
}