/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.util.List;
import model.Proveedor;

/**
 *
 * @author Cristian
 */
public class ProveedorView {
         public static void mostrarProductos(List<Proveedor> proveedores) {
        if (proveedores.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            System.out.println("\n--- Lista de Productos ---");
            for (Proveedor proveedor : proveedores) {
                System.out.println(proveedor.getId() + ". " + proveedor.getNombre() + " - telefono: " + proveedor.getTelefono() );
            }
        }
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
}
