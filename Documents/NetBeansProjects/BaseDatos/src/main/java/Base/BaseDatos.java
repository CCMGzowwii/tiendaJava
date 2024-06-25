package Base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import controller.CategoriaController;
import controller.ProductoController;
import javax.swing.JFrame;
import vista.Vcategoria;
import java.util.Scanner;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author Cristian
 */
public class BaseDatos {

    public static void main(String[] args) {
        /* CategoriaController categoriaController = new CategoriaController();
        categoriaController.mostrarMenu();
        
        ProductoController productoController = new ProductoController();
        productoController.mostrarMenu();*/
        
        Vcategoria vcategoria = new Vcategoria();
        vcategoria.setVisible(true);
        JFrame frame = new JFrame("consulta categoria");
        frame.getContentPane().add(vcategoria);
       
       frame.pack();
       frame.setVisible(true);
       frame.setLocationRelativeTo(null);
    }
}
