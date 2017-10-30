package com.model;

/**
 *
 * @author kguerra
 */
public class Producto {
    private int id_producto;
    private String nombre_producto;
    private String descripcion;
    private Proveedor id_proveedor;
    private Tipo_producto id_tipo;
    private float precio;
    private float descuento;
    private int estado;
    private String path_img;
    private Usuario id_usuario;
    private int cantidad;

    public Producto () {
    }
    
    public Producto(int id_producto, String nombre_producto, String descripcion, Proveedor id_proveedor, Tipo_producto id_tipo, float precio, float descuento, int estado, String path_img, Usuario id_usuario, int cantidad) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.descripcion = descripcion;
        this.id_proveedor = id_proveedor;
        this.id_tipo = id_tipo;
        this.precio = precio;
        this.descuento = descuento;
        this.estado = estado;
        this.path_img = path_img;
        this.id_usuario = id_usuario;
        this.cantidad = cantidad;
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

    public Proveedor getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(Proveedor id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public Tipo_producto getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(Tipo_producto id_tipo) {
        this.id_tipo = id_tipo;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getPath_img() {
        return path_img;
    }

    public void setPath_img(String path_img) {
        this.path_img = path_img;
    }
    
    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
