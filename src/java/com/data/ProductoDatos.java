package com.data;

import com.db.Conexion;
import com.model.Producto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Alexis
 */

// La clase ProductoDatos nos servira para obtener los datos de la clase conexion y enviarselos a los servlets.
public class ProductoDatos {
    // Usamos singleton
    private static ProductoDatos instancia;
    private ProductoDatos() {
    }
    public static synchronized ProductoDatos getInstancia() {
        if (instancia == null) {
            instancia = new ProductoDatos();
        }
        return instancia;
    }
    
    //Función para insertar un producto en la DB.
    public void insertarProducto(String nombre_producto, String descripcion, String id_proveedor, String id_tipo, String precio, String descuento, String path_img, String cantidad) {
        Conexion.getInstancia().db_exec("INSERT INTO producto (nombre_producto, descripcion, id_proveedor, id_tipo, precio, descuento, path_img, id_usuario, cantidad, estado) "
            + "VALUES ('"+ nombre_producto
            + "','"+ descripcion
            + "',"+ id_proveedor
            + ","+ id_tipo
            + ","+ precio
            + ","+ descuento
            + ",'"+ path_img
            + "',1,"+ cantidad
            + ",1)");
    }
    
    //Función para editar un producto en la DB.
    public void editarProducto(String id_producto,String nombre_producto, String descripcion, String id_proveedor, String id_tipo, String precio, String descuento, String path_img, String cantidad) {
        Conexion.getInstancia().db_exec("UPDATE producto SET "
            + "nombre_producto = '"+ nombre_producto
            + "', descripcion = '"+ descripcion
            + "', id_proveedor = "+ id_proveedor
            + ", id_tipo = "+ id_tipo 
            + ", precio = "+ precio
            + ", descuento = "+ descuento
            + ", path_img = '"+ path_img
            + "', cantidad = "+ cantidad
            + ", estado = 1"
            + " WHERE id_producto = " + id_producto);
    }
    
    //Función para eliminar un producto en la DB.
    public void eliminarProducto(String id_producto) {
        Conexion.getInstancia().db_exec("UPDATE producto SET estado = 0 WHERE id_producto = " + id_producto);
    }
    
    //Función para insertar un tipo de producto en la DB.
    public void insertarTipoProducto(String nombre_tipo) {
        Conexion.getInstancia().db_exec("INSERT INTO tipo_producto (nombre_tipo) "
            + "VALUES ('"+ nombre_tipo + "')");
    }
    
    //Función para editar un tipo de producto en la DB.
    public void editarTipoProducto(String id_tipo,String nombre_tipo) {
        Conexion.getInstancia().db_exec("UPDATE tipo_producto SET "
            + "nombre_tipo = '"+ nombre_tipo + "' WHERE id_tipo = " + id_tipo);
    }
    
    //Función para eliminar un tipo de producto en la DB.
    public void eliminarTipoProducto(String id_tipo) {
        Conexion.getInstancia().db_exec("UPDATE tipo_producto SET estado = 0 WHERE id_tipo = " + id_tipo);
    }
}
