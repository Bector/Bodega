package com.example.bodega.utilidades;

public class Utilidades {

    public static final String tabla_usuario="usuario";
    public static final String campoNombre="nombre";
    public static final String campoApellido="apellido";
    public static final String campoRut="rut";
    public static final String campo_usuario="nomUsuario";
    public static final String campo_password="password";

    public static final String crearTablaUsuario="create table "+tabla_usuario+" ("+campoNombre+" text, "+campoApellido+" text," +campoRut+" text,"+campo_usuario+" text,"+campo_password+")";


    public static final String tabla_productos="productos";
    public static final String campo_id="id";
    public static final String campo_nom_prod="nomProd";
    public static final String campo_precio="precio";
    public static final String campo_cantidad="cantidad";

    public static final String crearTablaProd="create table "+tabla_productos+" ("+campo_id+" int, "+campo_nom_prod+" text, "+campo_precio+" int, "+campo_cantidad+" int)";




}
