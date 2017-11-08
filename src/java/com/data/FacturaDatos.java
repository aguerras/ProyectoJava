package com.data;

import com.db.Conexion;
import com.model.Detalle_pedido;
import com.model.Pedido;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    
    public void insertarFactura(String id_usuario) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
        String fecha = sdf.format(new Date());
        String id_pedido = Conexion.getInstancia().db_string("SELECT id_pedido FROM pedido WHERE id_usuario = " + id_usuario, "");
        float precio_total = PedidoDatos.getInstancia().getPrecioTotal(id_usuario);
        if (precio_total != 0) {
            String id_factura = String.valueOf(Conexion.getInstancia().db_insert("INSERT INTO factura (precio_total, id_usuario, id_tipo, fecha_facturacion) "
                + "VALUES ("+ precio_total
                + ","+ id_usuario
                + ",1," + fecha
                + ");"));

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
                    }
                }
            }
        }
        PedidoDatos.getInstancia().eliminarPedidos(id_usuario);
    }
}
