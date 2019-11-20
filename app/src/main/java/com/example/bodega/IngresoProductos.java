package com.example.bodega;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bodega.utilidades.Utilidades;

public class IngresoProductos extends AppCompatActivity {

    EditText campoId,campoNomProd,campoPrecio,campoCant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_productos);

        campoId=(EditText)findViewById(R.id.etId);
        campoNomProd=(EditText)findViewById(R.id.etNomProd);
        campoPrecio=(EditText)findViewById(R.id.etPrecio);
        campoCant=(EditText)findViewById(R.id.etCantidad);

    }

    public void onClick(View view){
        //registrarProd();
        registrarPordSql();
    }

    private void registrarPordSql() {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this, "bodega",null,1);
        SQLiteDatabase database=conn.getWritableDatabase();

        String insert="insert into "+Utilidades.tabla_productos+" ("+Utilidades.campo_id+","+Utilidades.campo_nom_prod+","+Utilidades.campo_precio+","+Utilidades.campo_cantidad+") values("
        +campoId.getText().toString()+",'"+campoNomProd.getText().toString()+"',"+campoPrecio.getText().toString()+","+campoCant.getText().toString()+")";
        database.execSQL(insert);
        Toast.makeText(getApplicationContext(),"Registro exitoso!",Toast.LENGTH_SHORT).show();
        database.close();
    }

    private void registrarProd() {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this, "bodega",null,1);
        SQLiteDatabase database=conn.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Utilidades.campo_id,campoId.getText().toString());
        values.put(Utilidades.campo_nom_prod,campoNomProd.getText().toString());
        values.put(Utilidades.campo_precio,campoPrecio.getText().toString());
        values.put(Utilidades.campo_cantidad,campoCant.getText().toString());

        Long idResultante=database.insert(Utilidades.tabla_productos,Utilidades.campo_id,values);
        Toast.makeText(getApplicationContext(),"Id registro:"+idResultante,Toast.LENGTH_SHORT).show();

        database.close();
    }

}
