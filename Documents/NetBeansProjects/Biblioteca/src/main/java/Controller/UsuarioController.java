/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioController {
    private UsuarioDAO usuarioDAO;
    
    public UsuarioController() {
        usuarioDAO = new UsuarioDAO();
    }

public void crearUsuario(String nombre, String email, String telefono) {
        Usuario usuario = new Usuario(0,nombre, email, telefono);
        usuarioDAO.crearUsuario(usuario);
    }

 public List <Usuario> leerUsuario() {
        List<Usuario> usuarios = usuarioDAO.leerUsuarios();
        return usuarios;
    }

public void actualizarUsuario(int id_usuario, String nombre, String email, String telefono) {
        Usuario usuario = new Usuario(id_usuario, nombre, email, telefono);
        usuarioDAO.actualizarUsuario(usuario);
    }

public void eliminarUsuarios(int id_usuario) {
        usuarioDAO.eliminarUsuario(id_usuario);
    }

}

