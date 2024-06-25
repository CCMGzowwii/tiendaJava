/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import config.ConexionBD;
import model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristian
 */
public class ClienteDAO {
    
   private Connection conexion;
    private ConexionBD conexionBD;

      public ClienteDAO() {
        conexionBD = new ConexionBD();
        conexion = conexionBD.getConexion();
    }
      
    public void crearCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nombre,direccion,telefono) VALUES (?,?,?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getDireccion());
            statement.setString(3, cliente.getTelefono());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    public List<Cliente> leerCliente() {
        List<Cliente> cliente = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String telefono =resultSet.getString("direccion");
                String direccion =resultSet.getString("telefono");
                Cliente clientes = new Cliente(id, nombre,direccion,telefono);
                cliente.add(clientes);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar los datos: " + e.getMessage());
        }
        return cliente;
    }

    public void actualizarCliente(Cliente cliente) {
        String sql = "UPDATE cliente SET nombre = ?,direccion = ?,telefono = ? WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, cliente.getNombre());
             statement.setString(2, cliente.getDireccion());
            statement.setString(3, cliente.getTelefono());
            statement.setInt(4, cliente.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar los datos: " + e.getMessage());
        }
    }

    public void eliminarCliente(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar los datos: " + e.getMessage());
        }
    }

    public void cerrarConexion() {
        conexionBD.closeConexion(conexion);
    }
}  
    
    
    

