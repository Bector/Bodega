package com.example.bodega.utilidades;

public class Utilidades {

    public static final String tabla_usuario="usuario";
    public static final String campoNombre="nombre";
    public static final String campoApellido="apellido";
    public static final String campoRut="rut";
    public static final String campo_usuario="nomUsuario";
    public static final String campo_password="password";

    public static final String crearTablaUsuario="create table "+tabla_usuario+" ("+campoNombre+" text, "+campoApellido+" text," +campoRut+" text,"+campo_usuario+" text,"+campo_password+" text)";


    public static final String tabla_categoria="categoria";

    public static final String campo_id_cat="idCat";
    public static final String campo_nom_cat="nomCat";
    public static final String crearTablaCat="create table "+tabla_categoria+" ("+campo_id_cat+" int, "+campo_nom_cat+" text)";


    public static final String insertarDatos1="INSERT INTO "+tabla_categoria+" ("+campo_id_cat+","+campo_nom_cat+") VALUES(1, 'bebestible')";
    public static final String insertarDatos2="INSERT INTO "+tabla_categoria+" ("+campo_id_cat+","+campo_nom_cat+") VALUES(2, 'snack')";
    public static final String insertarDatos3="INSERT INTO "+tabla_categoria+" ("+campo_id_cat+","+campo_nom_cat+") VALUES(3, 'pasteles')";
    public static final String insertarDatos4="INSERT INTO "+tabla_categoria+" ("+campo_id_cat+","+campo_nom_cat+") VALUES(4, 'alcohol')";


    public static final String tabla_productos="productos";
    public static final String campo_id="id";
    public static final String campo_nom_prod="nomProd";
    public static final String campo_precio="precio";
    public static final String campo_cantidad="cantidad";

    public static final String crearTablaProd="create table "+tabla_productos+" ("+campo_id+" integer not null primary key autoincrement, "+campo_nom_prod+" text, "+campo_precio+" int, "+campo_cantidad+" int, "+campo_id_cat+" int, foreign key('"+campo_id_cat+"') references "+tabla_categoria+"('"+campo_id_cat+"'))";




}
