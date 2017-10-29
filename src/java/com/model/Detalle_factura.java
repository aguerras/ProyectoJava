package com.model;

/**
 *
 * @author kguerra
 */
public class Detalle_factura {
    private Factura id_factura;
    private Producto id_producto;
    private int cantidad;

    public Detalle_factura() {
    }
    
    public Detalle_factura (Factura id_factura,Producto id_producto,int cantidad) {
        this.id_factura = id_factura;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
    }

    public Factura getId_factura() {
        return id_factura;
    }
    public void setId_factura(Factura id_factura) {
        this.id_factura = id_factura;
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
