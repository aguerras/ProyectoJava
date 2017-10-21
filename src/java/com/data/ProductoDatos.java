package com.data;

import com.db.Conexion;
import com.model.Producto;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
    
    public List<Producto> getProductos() {
        String consulta = "SELECT "
                + "prod.nombre_producto, "
                + "prod.descripcion, "
                + "prod.id_proveedor, "
                + "prod.tipo, prod.precio, "
                + "prod.descuento, "
                + "prod.estado "
                + "prov.nombre"nombre,direccion,telefono,fax,nombre_comercial,DATE_FORMAT(fecha_creacion,'%d-%m-%Y'),nit
                + "FROM producto prod "
                + "JOIN proveedor prov ON prov.id_proveedor = prod.id_proveedor";
        
        List<Producto> listaProducto = new ArrayList<Producto>();
        List<ArrayList> lista = new ArrayList<ArrayList>(Conexion.getInstancia().db_list_of_lists(consulta));
        for (Iterator<ArrayList> i = lista.iterator(); i.hasNext();) {
            ArrayList<String> lista2 = new ArrayList<String>(i.next());
            String nombre_producto = lista2.get(0);
            String descripcion = lista2.get(1);
            int id_proveedor = Integer.parseInt(lista2.get(2));
            int tipo = Integer.parseInt(lista2.get(3));
            float precio = Float.parseFloat(lista2.get(4));
            float descuento = Float.parseFloat(lista2.get(5));
            int estado = Integer.parseInt(lista2.get(6));
            Producto producto = new Producto(0, nombre_producto, descripcion, id_proveedor, tipo, precio, descuento, estado);
            listaProducto.add(producto);
        }

        return listaProducto;
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
