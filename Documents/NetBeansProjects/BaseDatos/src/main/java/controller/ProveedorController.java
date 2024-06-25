/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.Proveedor;
import dao.ProveedorDAO;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Cristian
 */
public class ProveedorController {
       private ProveedorDAO proveedorDAO;
    private Scanner scanner;

    public ProveedorController() {
       proveedorDAO = new ProveedorDAO();
        scanner = new Scanner(System.in);
    }
    
    public void crearproveedor (int id,String nombre,String telefono){
        Proveedor crearprov = new Proveedor(0,nombre,telefono);
        proveedorDAO.crearProveedor(crearprov);
        
    }
    
     public List <Proveedor> leerProveedor() {
        List<Proveedor> proveedores = proveedorDAO.leerProveedor();
        return proveedores;
    }
      public void actualizarproveedor (int id,String nombre,String telefono){
            Proveedor actualizarprov = new Proveedor(id,nombre,telefono);
            proveedorDAO.actualizarProveedor(actualizarprov);
      }
      
      public void eliminarproveedor (int id){
          proveedorDAO.eliminarProducto(id);
      }
}
