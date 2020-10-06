
package Figuras;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;


public class Principal extends JFrame{
    
    public static void main(String[] args) {
        new Principal().setVisible(true);
    }
    
    int i = -1;
    JPanel Dibujo, Botones, Colores;
    JButton salir, limpiar, cambiarcolor, Dibujar;
    JComboBox opcion;
    JLabel jl, jlcolor, jlAlto, jlAncho, xpos, ypos, jlpos;
    JSlider sliderAlto, sliderAncho;
    String[] stringColores = null;
    Color[] colores = null;
    Container cp = getContentPane();
    Color color;
    Lienzo lienzo;
    
    public Principal(){
        
        super("------------------------------------------------------------------------------------------------------------------------------------------------------------Figuras----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        this.setLayout(new BorderLayout());
        stringColores = new String[]{"Blanco", "Azul cyan", "Rosa", "Verde", "Amariillo"};
        colores = new Color[]{Color.WHITE, Color.CYAN, Color.PINK, Color.GREEN, Color.YELLOW};
        Botones = new JPanel();
        Colores = new JPanel();
        Colores.setLayout(new BoxLayout(Colores, BoxLayout.Y_AXIS));
        xpos = new JLabel("Coordenada x: \n");
        ypos = new JLabel("Coordenada y: \n");
        jlpos = new JLabel("Posicion del cursor");
        jl = new JLabel("¿Que desea dibujar?");
        jlcolor = new JLabel("Color utilizando");
        jlcolor.setForeground(Color.BLACK);
        jlcolor.setFont(new Font("Algerian", Font.ROMAN_BASELINE, 15));
        jlAlto = new JLabel("Alto");
        jlAlto.setAlignmentY(Component.CENTER_ALIGNMENT);
        jlAlto.setFont(new Font("Algerian", Font.ROMAN_BASELINE, 15));
        jlAncho = new JLabel("Ancho");
        jlAncho.setAlignmentY(Component.CENTER_ALIGNMENT);
        jlAncho.setFont(new Font("Algerian", Font.ROMAN_BASELINE, 15));
        //Sliders
        int initValue = 1;
        int minimum = 1;
        int maximum = 700;
        sliderAncho = new JSlider(minimum, maximum, initValue);
        sliderAncho.setPaintTicks(true);
        sliderAncho.setBounds(350, 100, 250, 50);
        sliderAlto = new JSlider(minimum, maximum, initValue);
        sliderAlto.setPaintTicks(true);
        sliderAlto.setBounds(350, 100, 250, 50);
        //radiobuton
        JRadioButton rbColores[] = new JRadioButton[stringColores.length];
        ButtonGroup grup = new ButtonGroup();
        for (int i = 0; i < stringColores.length; i++) {
            rbColores[i] = new JRadioButton(stringColores[i]);
            rbColores[i].setActionCommand(stringColores[i]);
            rbColores[i].setAlignmentY(Component.CENTER_ALIGNMENT);
            grup.add(rbColores[i]);
            Colores.add(rbColores[i]);
                rbColores[i].addActionListener(new RadioButton(this));
        }
        salir = new JButton("Salir del programa");
        limpiar = new JButton("Limpiar el lienzo");
        Dibujar = new JButton("Dibujar en el lienzo");
        opcion = new JComboBox();
        opcion.addItem("Seleccione aqui");
        opcion.addItem("Linea recta");
        opcion.addItem("Rectangulo o Cuadrado");
        opcion.addItem("Circulo");
        opcion.addItem("Dibujo libre");
        opcion.setEnabled(false);
        cp.add(new Lienzo(this), BorderLayout.CENTER);
        cp.add(Colores, BorderLayout.WEST);
        cp.add(Botones, BorderLayout.NORTH);
        Botones.add(Dibujar);
        Botones.add(jl);
        Botones.add(opcion);
        Botones.add(limpiar);
        Botones.add(salir);
        Colores.add(jlcolor);
        Colores.add(jlAlto);
        Colores.add(sliderAlto);
        Colores.add(jlAncho);
        Colores.add(sliderAncho);
        Colores.add(jlpos);
        Colores.add(xpos);
        Colores.add(ypos);
        sliderAlto.setEnabled(false);
        sliderAncho.setEnabled(false);
        Colores.setVisible(false);
        Dibujar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                opcion.setEnabled(true);
                Colores.setVisible(true);
            }
        });
        
        opcion.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                JComboBox fuente = (JComboBox) ie.getSource();
                i = fuente.getSelectedIndex();
            }
        });
        salir.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
        });
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.getRootPane().setWindowDecorationStyle(7);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
    }
    
}
