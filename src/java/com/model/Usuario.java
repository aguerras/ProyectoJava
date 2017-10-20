package com.model;

import java.sql.Date;

/**
 *
 * @author Alexis
 */
public class Usuario {
    private int id_usuario;
    private String nombres;
    private String apellidos;
    private int sexo;
    private String email;
    private java.sql.Date fecha_nacimiento; 
    private java.sql.Date fecha_creacion; 
    private int id_rol;
    private String foto;
    private int id_pais;
    private String telefono;
    private String clave_acceso;
    private int estado;

    public Usuario(int id_usuario, String nombres, String apellidos, int sexo, String email, Date fecha_nacimiento, Date fecha_creacion, int id_rol, String foto, int id_pais, String telefono, String clave_acceso, int estado) {
        this.id_usuario = id_usuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.email = email;
        this.fecha_nacimiento = fecha_nacimiento;
        this.fecha_creacion = fecha_creacion;
        this.id_rol = id_rol;
        this.foto = foto;
        this.id_pais = id_pais;
        this.telefono = telefono;
        this.clave_acceso = clave_acceso;
        this.estado = estado;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getid_pais() {
        return id_pais;
    }

    public void setid_pais(int id_pais) {
        this.id_pais = id_pais;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getClave_acceso() {
        return clave_acceso;
    }

    public void setClave_acceso(String clave_acceso) {
        this.clave_acceso = clave_acceso;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}
