package com.model;

import java.sql.Date;

/**
 *
 * @author kguerra
 */
public class Detalle_producto {
    private int id_producto;
    private int cantidad;
    private int ilimitado;
    private int id_usuario_creacion;
    private Date fecha_creacion;

    public Detalle_producto (int id_producto,int cantidad,int ilimitado,int id_usuario_creacion,Date fecha_creacion) {
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.ilimitado = ilimitado;
        this.id_usuario_creacion = id_usuario_creacion;
        this.fecha_creacion = fecha_creacion;
    }

    public int getId_producto() {
        return id_producto;
    }
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIlimitado() {
        return ilimitado;
    }
    public void setIlimitado(int ilimitado) {
        this.ilimitado = ilimitado;
    }

    public int getId_usuario_creacion() {
        return id_usuario_creacion;
    }
    public void setId_usuario_creacion(int id_usuario_creacion) {
        this.id_usuario_creacion = id_usuario_creacion;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }
    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
}
