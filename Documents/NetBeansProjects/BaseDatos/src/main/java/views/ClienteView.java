/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;
import model.Cliente;
import java.util.List;
/**
 *
 * @author Cristian
 */
public class ClienteView {
         public static void mostrarCliente(List<Cliente> cliente) {
        if (cliente.isEmpty()) {
            System.out.println("No hay clientes disponibles.");
        } else {
            System.out.println("\n--- Lista de Clientes ---");
            for (Cliente clientes : cliente) {
                System.out.println(clientes.getId() + ". " + clientes.getNombre());
            }
        }
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
}
