package com.data;

import com.db.Conexion;
import com.model.Detalle_pedido;
import java.util.List;

/**
 *
 * @author Alexis
 */
public class FacturaDatos {
    // Usamos singleton
    private static FacturaDatos instancia;
    private FacturaDatos() {
    }
    public static synchronized FacturaDatos getInstancia() {
        if (instancia == null) {
            instancia = new FacturaDatos();
        }
        return instancia;
    }
    
    public String insertarFactura(String id_usuario) {
        String id_factura = "";
        String id_pedido = Conexion.getInstancia().db_string("SELECT id_pedido FROM pedido WHERE id_usuario = " + id_usuario, "");
        float precio_total = PedidoDatos.getInstancia().getPrecioTotal(id_usuario);
        if (precio_total != 0) {
            id_factura = String.valueOf(Conexion.getInstancia().db_insert("INSERT INTO factura (precio_total, id_usuario, id_tipo, fecha_facturacion) "
                + "VALUES ("+ precio_total
                + ","+ id_usuario
                + ",1,now());"));

            if (!id_factura.isEmpty()) {
                List<Detalle_pedido> pedidos = (List<Detalle_pedido>)(List<?>) PedidoDatos.getInstancia().getPedidos(id_pedido);
                for (int i = 0; i < pedidos.size(); i++) {
                    Detalle_pedido detallePedido = (Detalle_pedido) pedidos.get(i);
                    if (detallePedido != null) {
                        int id_producto = detallePedido.getId_producto().getId_producto();
                        int cantidad = detallePedido.getCantidad();
                        Conexion.getInstancia().db_exec("INSERT INTO detalle_factura (id_factura, id_producto, cantidad) "
                            + "VALUES ("+ id_factura
                            + ","+ id_producto
                            + ","+ cantidad
                            + ")");
                        String cantidad_actual = Conexion.getInstancia().db_string("SELECT cantidad - " + cantidad + " FROM producto where id_producto = " + id_producto, "");
                        Conexion.getInstancia().db_exec("UPDATE producto SET cantidad = " + cantidad_actual + " WHERE id_producto = " + id_producto);
                    }
                }
            }
        }
        PedidoDatos.getInstancia().eliminarPedidos(id_usuario);
        
        return id_factura;
    }
}
