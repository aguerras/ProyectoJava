package com.model;

import com.model.Usuario;

/**
 *
 * @author Alexis
 */
public class Pedido {
    private int id_pedido;
    private Usuario id_usuario;
    private float precio_total;
    
    public Pedido() {
    }
    
    public Pedido(Usuario id_usuario, float precio_total) {
        this.id_usuario = id_usuario;
        this.precio_total = precio_total;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public float getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(float precio_total) {
        this.precio_total = precio_total;
    }
}
