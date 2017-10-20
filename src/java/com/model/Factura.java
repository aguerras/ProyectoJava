package com.model;

import java.sql.Date;

/**
 *
 * @author kguerra
 */
public class Factura {
    private int id_factura;
    private int precio_total;
    private int id_usuario;
    private int id_facturacion;
    private int tipo;
    private Date fecha_facturacion;

    public Factura (int id_factura,int precio_total,int id_usuario,int id_facturacion,int tipo,Date fecha_facturacion) {
        this.id_factura = id_factura;
        this.precio_total = precio_total;
        this.id_usuario = id_usuario;
        this.id_facturacion = id_facturacion;
        this.tipo = tipo;
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

    public int getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_facturacion() {
        return id_facturacion;
    }
    public void setId_facturacion(int id_facturacion) {
        this.id_facturacion = id_facturacion;
    }

    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Date getFecha_facturacion() {
        return fecha_facturacion;
    }
    public void setFecha_facturacion(Date fecha_facturacion) {
        this.fecha_facturacion = fecha_facturacion;
    }
}
