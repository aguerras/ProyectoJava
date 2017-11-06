package com.model;

/**
 *
 * @author Alexis
 */
public class Detalle_pedido {
    private Pedido id_pedido;
    private Producto id_producto;
    private int cantidad;

    public Detalle_pedido() {
    }
    
    public Detalle_pedido(Pedido id_pedido, Producto id_producto, int cantidad) {
        this.id_pedido = id_pedido;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
    }

    public Pedido getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Pedido id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Producto getId_producto() {
        return id_producto;
    }

    public void setId_producto(Producto id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
