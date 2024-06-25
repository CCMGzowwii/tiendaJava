/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package biblioteca;
import config.DatabaseConnection;
import java.sql.Connection;
import dao.LibroDAO;
import javax.swing.JFrame;
import vista.Vistabiblioteca;

/**
 *
 * @author Cristian
 */
public class Biblioteca {
    public static void main(String[] args) {
                Vistabiblioteca vbiblioteca = new Vistabiblioteca();
        vbiblioteca.setVisible(true);
        JFrame frame = new JFrame("consulta categoria");
        frame.getContentPane().add(vbiblioteca);
        
               frame.pack();
       frame.setVisible(true);
       frame.setLocationRelativeTo(null);
    }   
    
 }

    

