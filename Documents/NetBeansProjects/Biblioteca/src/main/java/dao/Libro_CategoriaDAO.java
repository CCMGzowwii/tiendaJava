/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.DatabaseConnection;

import model.Libro_Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Libro_CategoriaDAO {
    private Connection conexion;
    private DatabaseConnection conexionBD;
    private int categoria_id; 

    public Libro_CategoriaDAO() {
        conexionBD = new DatabaseConnection();
        conexion = conexionBD.getConexion();
    }
    
    public void crearLibro_Categoria(Libro_Categoria libro_categoria) {
        String sql = "INSERT INTO libro_categoria (libros_id, categorias_id) VALUES (?,?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, libro_categoria.getLibro_id());
            statement.setInt(2,libro_categoria.getCategoria_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    public List<Libro_Categoria> leerLibros_Categorias() {
        List<Libro_Categoria> libros_categorias = new ArrayList<>();
        String sql = "SELECT * FROM libros_categorias";
        try (Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int libros_id = resultSet.getInt("libros_id");
                int categorias_id = resultSet.getInt("categorias_id");
                Libro_Categoria libro_categoria = new Libro_Categoria(libros_id, categorias_id);
                libros_categorias.add(libro_categoria);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar los datos: " + e.getMessage());
        }
        return libros_categorias;
    }

    public void actualizarLibro_Categoria(Libro_Categoria libro_categoria) {
        String sql = "UPDATE libros_categorias SET libros_id =?, categorias_id=?, WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1,libro_categoria.getLibro_id());
            statement.setInt(1,libro_categoria.getCategoria_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar los datos: " + e.getMessage());
        }
    }

    public void eliminarLibro_Categoria (int libro_id) {
        String sql = "DELETE FROM libro_categoria WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, libro_id);
            statement.setInt(2, categoria_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar los datos: " + e.getMessage());
        }
    }

    public void cerrarConexion() {
        conexionBD.closeConexion(conexion);
    }
    
}