package Figuras;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class RadioButton implements ActionListener {

    Principal ven;

    public RadioButton(Principal ven) {
        this.ven = ven;
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < ven.stringColores.length; i++) {
            if (ven.stringColores[i].equals(e.getActionCommand())) {
                ven.jlcolor.setForeground(ven.colores[i]);

                break;
            }
        }
    }
}
