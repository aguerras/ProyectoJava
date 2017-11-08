package com.model;

/**
 *
 * @author kguerra
 */
public class Factura {
    private int id_factura;
    private int precio_total;
    private Usuario id_usuario;
    private Tipo_factura id_tipo;
    private String fecha_facturacion;

    public Factura() {
    }
    
    public Factura(int precio_total, Usuario id_usuario, Tipo_factura id_tipo, String fecha_facturacion) {
        this.precio_total = precio_total;
        this.id_usuario = id_usuario;
        this.id_tipo = id_tipo;
        this.fecha_facturacion = fecha_facturacion;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public int getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(int precio_total) {
        this.precio_total = precio_total;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Tipo_factura getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(Tipo_factura id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getFecha_facturacion() {
        return fecha_facturacion;
    }

    public void setFecha_facturacion(String fecha_facturacion) {
        this.fecha_facturacion = fecha_facturacion;
    }
}
