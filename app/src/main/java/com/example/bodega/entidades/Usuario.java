package com.example.bodega.entidades;

public class Usuario {

    private String nombre;
    private String apellido;
    private String rut;
    private String nomUsuario;
    private String password;


    public Usuario(){

    }

    public Usuario(String nombre, String apellido, String rut, String nomUsuario, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.nomUsuario = nomUsuario;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
       this.rut = rut;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
