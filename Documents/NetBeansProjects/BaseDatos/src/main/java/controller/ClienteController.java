/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import dao.ClienteDAO;
import model.Cliente;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Cristian
 */
public class ClienteController {
      private ClienteDAO clienteDAO;
    private Scanner scanner;

    public ClienteController() {
       clienteDAO = new ClienteDAO();
        scanner = new Scanner(System.in);
    }
    
    public void crearcliente ( int id,String nombre,String direccion,String telefono){
        Cliente crearc = new Cliente(0,nombre,direccion,telefono);
        clienteDAO.crearCliente(crearc);
    }
      public List <Cliente> leerClientes() {
        List<Cliente> clientes = clienteDAO.leerCliente();
        return clientes;
    }
    
      public void actualizarcliente ( int id,String nombre,String direccion,String telefono){
          Cliente actualizarc = new Cliente(id,nombre,direccion,telefono);
          clienteDAO.actualizarCliente(actualizarc);
      }
      
      public void eliminarcliente (int id){
          clienteDAO.eliminarCliente(id);
      }      
}



