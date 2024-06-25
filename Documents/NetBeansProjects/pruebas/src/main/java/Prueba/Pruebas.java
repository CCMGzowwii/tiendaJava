package Prueba;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author Cristian
 */
public class Pruebas {

    public static void main(String[] args) {
                JFrame frame = new JFrame("Ventana con JToolBar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JToolBar toolBar = new JToolBar();
        toolBar.add(new JButton("Botón 1"));
        toolBar.add(new JButton("Botón 2"));
        toolBar.add(new JButton("Botón 3"));

        frame.add(toolBar, "North");
        frame.setVisible(true);
        
    }
    
    
}
