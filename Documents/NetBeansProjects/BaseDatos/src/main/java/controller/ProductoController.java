/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import views.ProductoView;
import dao.ProductoDAO;
import model.Producto;
import views.ProductoView;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Cristian
 */
public class ProductoController {
     private ProductoDAO productoDAO;
    private Scanner scanner;

    public ProductoController() {
        productoDAO = new ProductoDAO();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Menú de Productos ---");
            System.out.println("1. Crear producto");
            System.out.println("2. Leer productos");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5.verificar producto");
            System.out.println("6.buscar producto");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    crearProducto();
                    break;
                case 2:
                    leerProductos();
                    break;
                case 3:
                    actualizarProducto();
                    break;
                case 4:
                    
                    break;
                case 5:
                     verificarP();
                    break;
                case 6:
                     buscarP();
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);
    }

    public void crearProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        System.out.print("\nIngrese el ID de la categoria que desea actualizar: ");
        int categoriaId = scanner.nextInt();
        Producto producto = new Producto(0, nombre, precio,categoriaId);
        productoDAO.crearProducto(producto);
        ProductoView.mostrarMensaje("Producto creado exitosamente.");
    }
       public void crearproductov (String nombre,double precio, int categoria){
        Producto crearproductov = new Producto(nombre,precio,categoria);
        productoDAO.crearProducto(crearproductov);
        
   }

     public List <Producto> leerProductos() {
        List<Producto> productos = productoDAO.leerProductos();
        
        return productos;
    }
    
        public List<Producto> leerproductosv() {
        List<Producto> productos = productoDAO.leerProductos();
        return productos;
    }

    public void actualizarProducto() {
        leerProductos();
        System.out.print("\nIngrese el ID del producto que desea actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        System.out.print("Ingrese el nuevo nombre del producto: ");
        String nuevoNombre = scanner.nextLine();
        System.out.print("Ingrese el nuevo precio del producto: ");
        double nuevoPrecio = scanner.nextDouble();
        System.out.print("\nIngrese el ID de la categoria que desea actualizar: ");
        int categoriaId = scanner.nextInt();
        Producto producto = new Producto(id, nuevoNombre, nuevoPrecio, categoriaId);
        productoDAO.actualizarProducto(producto);
        ProductoView.mostrarMensaje("Producto actualizado exitosamente.");
    }
    
    public void acualizarProductov(int id,String nombre,double precio, int categoria){
       Producto producto = new Producto(id,nombre,precio,categoria);
       productoDAO.actualizarProducto(producto);
    }

    public void eliminarProducto(int id) {
        productoDAO.eliminarProducto(id);
    }
    
   
    
    
    private void verificarP() {
        leerProductos();
        System.out.print("\nIngrese el ID del producto que desea validar: ");
        int id = scanner.nextInt();
       int resul= productoDAO.verificarP(id);
        if (resul == 1){
             ProductoView.mostrarMensaje("Producto verificado.");
        }
        else{
        ProductoView.mostrarMensaje("Producto no existente");
        }
    }
    
    private void buscarP(){
       
        System.out.print("\nIngrese el caracter o caracteres que contenga el producto que desea buscar ");
        String nombre = scanner.nextLine();
        /*productoDAO.buscarProductoxNombre(nombre);*/
         List<Producto> productos = productoDAO.buscarProductoxNombre(nombre);
        ProductoView.mostrarProductos(productos);
    }
}

    

