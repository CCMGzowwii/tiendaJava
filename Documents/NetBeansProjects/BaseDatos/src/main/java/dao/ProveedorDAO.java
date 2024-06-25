/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import config.ConexionBD;
import model.Proveedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Cristian
 */
public class ProveedorDAO {
     private Connection conexion;
    private ConexionBD conexionBD;

      public ProveedorDAO() {
        conexionBD = new ConexionBD();
        conexion = conexionBD.getConexion();
    }
      
    public void crearProveedor(Proveedor proveedor) {
        String sql = "INSERT INTO proveedor (nombre,telefono) VALUES (?,?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, proveedor.getNombre());
            statement.setString(2, proveedor.getTelefono());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    public List<Proveedor> leerProveedor() {
        List<Proveedor> proveedores = new ArrayList<>();
        String sql = "SELECT * FROM proveedor";
        try (Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String telefono =resultSet.getString("telefono");
                Proveedor proveedor = new Proveedor(id, nombre,telefono);
                proveedores.add(proveedor);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar los datos: " + e.getMessage());
        }
        return proveedores;
    }

    public void actualizarProveedor(Proveedor proveedor) {
        String sql = "UPDATE proveedor SET nombre = ?,telefono = ? WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, proveedor.getNombre());
              statement.setString(2, proveedor.getTelefono());
            statement.setInt(3, proveedor.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar los datos: " + e.getMessage());
        }
    }

    public void eliminarProducto(int id) {
        String sql = "DELETE FROM proveedor WHERE id = ?";
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