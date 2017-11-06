package com.data;

import com.db.Conexion;
import com.model.Detalle_pedido;
import com.model.Pedido;
import com.model.Producto;
import java.util.List;

/**
 *
 * @author Alexis
 */
public class PedidoDatos {
    // Usamos singleton
    private static PedidoDatos instancia;
    private PedidoDatos() {
    }
    public static synchronized PedidoDatos getInstancia() {
        if (instancia == null) {
            instancia = new PedidoDatos();
        }
        return instancia;
    }
    
    public String numeroArticulos(String id_pedido) {
        return Conexion.getInstancia().db_string("SELECT SUM(cantidad) FROM detalle_pedido WHERE id_pedido = " + id_pedido + ";", "");
    }
    
    public List<Object> getPedidos(String id_pedido) {
        return Conexion.getInstancia().db_object(Detalle_pedido.class, "id_pedido = " + id_pedido);
    }
    
    // Funcion insertarPedido para insertar un pedido en el carrito en la base de datos.
    public void insertarPedido(String id_usuario, String id_producto) {
        Producto producto = (Producto) Conexion.getInstancia().db_object(Producto.class, "id_producto = " + id_producto).get(0);
        float precio_total = 0;
        int cantidad = 1;
        String id_pedido = "";
        Pedido pedido = null;
        Detalle_pedido detalle_pedido = null;
        
        List<Pedido> pedidos = (List<Pedido>)(List<?>) Conexion.getInstancia().db_object(Pedido.class, "id_usuario = " + id_usuario);
        if (!pedidos.isEmpty()) {
            pedido = pedidos.get(0);
            id_pedido = String.valueOf(pedido.getId_pedido());
            precio_total = pedido.getPrecio_total() + (cantidad * producto.getPrecio());
            Conexion.getInstancia().db_exec("Update pedido SET precio_total = " + precio_total + " WHERE id_pedido = " + pedido.getId_pedido());
            List<Detalle_pedido> detalles_pedido = (List<Detalle_pedido>)(List<?>) Conexion.getInstancia().db_object(Detalle_pedido.class, "id_pedido = " + pedido.getId_pedido() + " AND id_producto = " + id_producto);
            if (!detalles_pedido.isEmpty()) {
                detalle_pedido = detalles_pedido.get(0);
                cantidad = cantidad + detalle_pedido.getCantidad();
                Conexion.getInstancia().db_exec("Update detalle_pedido SET cantidad = " + cantidad + " WHERE id_pedido = " + pedido.getId_pedido() + " AND id_producto = " + id_producto);
                return;
            } else {
                if (!id_pedido.isEmpty()) {
                    Conexion.getInstancia().db_exec("INSERT INTO detalle_pedido (id_pedido, id_producto, cantidad) "
                        + "VALUES ("+ id_pedido
                        + ","+ id_producto
                        + ","+ cantidad
                        + ")");
                }
            }
        }
        
        if (pedido == null) {
            precio_total = cantidad * producto.getPrecio();
            id_pedido = String.valueOf(Conexion.getInstancia().db_insert("INSERT INTO pedido (id_usuario, precio_total) "
                + "VALUES ("+ id_usuario
                + ","+ precio_total
                + ");"));

            if (id_pedido.isEmpty()) {
                Conexion.getInstancia().db_exec("INSERT INTO detalle_pedido (id_pedido, id_producto, cantidad) "
                    + "VALUES ("+ id_pedido
                    + ","+ id_producto
                    + ","+ cantidad
                    + ")");
            }
        }
        
        this.setPrecioTotal(id_pedido);
    }
    
    public void setPrecioTotal(String id_pedido) {
        Pedido pedido = (Pedido) Conexion.getInstancia().db_object(Pedido.class, "id_pedido = " + id_pedido).get(0);
        float total = 0;
        if (pedido != null) {
            List<Detalle_pedido> detalle = (List<Detalle_pedido>)(List<?>) Conexion.getInstancia().db_object(Detalle_pedido.class, "id_pedido = " + id_pedido);
            if (detalle.size() != 0) {
                for (int i = 0; i < detalle.size(); i++) {
                    Producto producto = (Producto) Conexion.getInstancia().db_object(Producto.class, "id_producto = " + detalle.get(i).getId_producto().getId_producto()).get(0);
                    total = total + detalle.get(i).getCantidad() * producto.getPrecio();
                }
            }
            Conexion.getInstancia().db_exec("Update pedido SET precio_total = " + total + " WHERE id_pedido = " + id_pedido);
        }
    }
    
    //Función para eliminar un pedido en la DB.
    public void eliminarPedido(String id_usuario, String id_producto) {
        String id_pedido = "";
        Pedido pedido = (Pedido) Conexion.getInstancia().db_object(Pedido.class, "id_usuario = " + id_usuario).get(0);
        Producto producto = (Producto) Conexion.getInstancia().db_object(Producto.class, "id_producto = " + id_producto).get(0);
        id_pedido = String.valueOf(pedido.getId_pedido());
        if (pedido != null && producto != null) {
            Detalle_pedido detalle = (Detalle_pedido) Conexion.getInstancia().db_object(Detalle_pedido.class, "id_pedido = " + id_pedido).get(0);
            if (detalle != null) {
                float precio_total = pedido.getPrecio_total() - (detalle.getCantidad() * producto.getPrecio());
                Conexion.getInstancia().db_exec("Update pedido SET precio_total = " + precio_total + " WHERE id_pedido = " + id_pedido);
                Conexion.getInstancia().db_exec("DELETE FROM detalle_pedido WHERE id_pedido = " + id_pedido + " AND id_producto = " + id_producto);
                this.setPrecioTotal(id_pedido);
            }
        }
    }
}
