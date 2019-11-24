package com.example.bodega;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.bodega.utilidades.Utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {


    public ConexionSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.crearTablaUsuario);
        db.execSQL(Utilidades.crearTablaProd);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists usuario");
        db.execSQL("drop table if exists productos");

    }

    public Cursor consultar(String usu, String pass) throws SQLException{
        Cursor mcursor=null;

        mcursor=this.getReadableDatabase().query("usuario",new String[]{"nomUsuario","password"},"nomUsuario like '"+usu+"' and password like '"+pass+"'",null,null,null,null);

        return mcursor;
    }
}
