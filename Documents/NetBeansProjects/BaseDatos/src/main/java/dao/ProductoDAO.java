/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import config.ConexionBD;
import model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristian
 */
public class ProductoDAO {
     private Connection conexion;
    private ConexionBD conexionBD;

    public ProductoDAO() { 
        conexionBD = new ConexionBD();
        conexion = conexionBD.getConexion();
    }

    public void crearProducto(Producto producto){
        String sql = "INSERT INTO productos (nombre, precio, categoria) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, producto.getNombre());
            statement.setDouble(2, producto.getPrecio());
            statement.setInt(3, producto.getCategoria());
            statement.executeUpdate();
        } catch (SQLException e) {
                System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }
    


    public List<Producto> leerProductos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try (Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                double precio = resultSet.getDouble("precio");
                int categoriaId = resultSet.getInt("categoria");
                Producto producto = new Producto(id, nombre, precio, categoriaId);
                productos.add(producto);
            }
        } catch (SQLException e) {
                System.out.println("Error al consultar los datos: " + e.getMessage());
        }
        return productos;
    }

    public void actualizarProducto(Producto producto) {
        String sql = "UPDATE productos SET nombre = ?, precio = ?, categoria = ? WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, producto.getNombre());
            statement.setDouble(2, producto.getPrecio());
            statement.setInt(3, producto.getCategoria());
            statement.setInt(4, producto.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
                System.out.println("Error al actualizar los datos: " + e.getMessage());
        }
    }

    public void eliminarProducto(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";
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

    
       public int verificarP(int id) {
        String sql = "SELECT COUNT(*) AS cuenta FROM  productos  p where p.id = ?";
        int resultado=0;
        
         try (PreparedStatement statement = conexion.prepareStatement(sql)){
             statement.setInt(1, id);
             ResultSet resultSet = statement.executeQuery();
             while (resultSet.next()){
                 resultado = resultSet.getInt("cuenta");
             }
            
              } catch (SQLException e) {
                System.out.println("Error al verificar los datos: " + e.getMessage());
        
         }
        return resultado;
       }   
       
    public List <Producto> buscarProductoxNombre(String nombre){
           List<Producto> resultado = new ArrayList<>();
           String sql = "SELECT p.nombre, p.precio, p.categoria FROM productos p WHERE p.nombre LIKE ?";
        try(PreparedStatement statement = conexion.prepareStatement(sql)){
                statement.setString(1,nombre);
                 ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
               String producto = resultSet.getString("nombre");
               double precio = resultSet.getDouble("precio");
               int categoria = resultSet.getInt("categoria");
               Producto busqueda = new Producto(nombre,precio,categoria);
               resultado.add(busqueda);
            }
               
        } catch (SQLException e){
            System.out.println("error al consultar los datos: "+ e.getMessage());
        }
        return resultado;
    }
  
}



