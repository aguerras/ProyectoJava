package com.model;

import java.sql.Date;

/**
 *
 * @author kguerra
 */
public class Producto {
    private int id_producto;
    private String nombre_producto;
    private String descripcion;
    private int id_proveedor;
    private String tipo;
    private Date temporalidad_inicial;
    private Date temporalidad_final;
    private Date expiracion;
    private float precio;
    private float descuento;
    private String condiciones;
    private int estado;
    private int devolucion;

    public Producto (int id_producto,String nombre_producto,String descripcion,int id_proveedor,String tipo,Date temporalidad_inicial,Date temporalidad_final,Date expiracion,float precio,float descuento,String condiciones,int estado,int devolucion) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.descripcion = descripcion;
        this.id_proveedor = id_proveedor;
        this.tipo = tipo;
        this.temporalidad_inicial = temporalidad_inicial;
        this.temporalidad_final = temporalidad_final;
        this.expiracion = expiracion;
        this.precio = precio;
        this.descuento = descuento;
        this.condiciones = condiciones;
        this.estado = estado;
        this.devolucion = devolucion;
    }

    public int getId_producto() {
        return id_producto;
    }
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }
    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }
    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getTemporalidad_inicial() {
        return temporalidad_inicial;
    }
    public void setTemporalidad_inicial(Date temporalidad_inicial) {
        this.temporalidad_inicial = temporalidad_inicial;
    }

    public Date getTemporalidad_final() {
        return temporalidad_final;
    }
    public void setTemporalidad_final(Date temporalidad_final) {
        this.temporalidad_final = temporalidad_final;
    }

    public Date getExpiracion() {
        return expiracion;
    }
    public void setExpiracion(Date expiracion) {
        this.expiracion = expiracion;
    }

    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getDescuento() {
        return descuento;
    }
    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public String getCondiciones() {
        return condiciones;
    }
    public void setCondiciones(String condiciones) {
        this.condiciones = condiciones;
    }

    public int getEstado() {
        return estado;
    }
    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getDevolucion() {
        return devolucion;
    }
    public void setDevolucion(int devolucion) {
        this.devolucion = devolucion;
    }
}
