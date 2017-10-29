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
    
    public void insertarProducto(String nombre_producto, String descripcion, String id_proveedor, String precio, String descuento) {
        Conexion.getInstancia().db_exec("INSERT INTO producto (nombre_producto, descripcion, id_proveedor, tipo, precio, descuento, estado) "
            + "VALUES ('"+ nombre_producto
            + "','"+ descripcion
            + "',"+ id_proveedor
            + ",1,"+ precio
            + ","+ descuento
            + ",1)");
    }
}
