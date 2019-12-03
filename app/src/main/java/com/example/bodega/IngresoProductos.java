package com.example.bodega;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.bodega.utilidades.Utilidades;

public class IngresoProductos extends AppCompatActivity {

    EditText campoId,campoNomProd,campoPrecio,campoCant;
    RadioButton rbBebestible,rbSnack,rbPasteles,rbAlcohol;
    RadioGroup rbCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_productos);

        campoId=(EditText)findViewById(R.id.etId);
        campoNomProd=(EditText)findViewById(R.id.etNomProd);
        campoPrecio=(EditText)findViewById(R.id.etPrecio);
        campoCant=(EditText)findViewById(R.id.etCantidad);

        rbBebestible=(RadioButton)findViewById(R.id.rbBebestible);
        rbSnack=(RadioButton)findViewById(R.id.rbSnack);
        rbPasteles=(RadioButton)findViewById(R.id.rbPasteles);
        rbAlcohol=(RadioButton)findViewById(R.id.rbAlcohol);

        rbCategoria=(RadioGroup)findViewById(R.id.rbCategoria);

    }

   public void onClick(View view){
        //registrarProd();
        registrarPordSql();
    }

    private void registrarPordSql() {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this, "bodega",null,1);
        SQLiteDatabase database=conn.getWritableDatabase();
        if(rbBebestible.isChecked()==true){

            String insert="insert into "+Utilidades.tabla_productos+" ("+Utilidades.campo_nom_prod+","+Utilidades.campo_precio+","+Utilidades.campo_cantidad+","+Utilidades.campo_id_cat+") values('"
                    +campoNomProd.getText().toString()+"',"+campoPrecio.getText().toString()+","+campoCant.getText().toString()+",1)";
            database.execSQL(insert);
            Toast.makeText(getApplicationContext(),"Registro exitoso!",Toast.LENGTH_SHORT).show();
            database.close();

        }else if(rbSnack.isChecked()==true){

            String insert="insert into "+Utilidades.tabla_productos+" ("+Utilidades.campo_nom_prod+","+Utilidades.campo_precio+","+Utilidades.campo_cantidad+","+Utilidades.campo_id_cat+") values('"
                    +campoNomProd.getText().toString()+"',"+campoPrecio.getText().toString()+","+campoCant.getText().toString()+",2)";
            database.execSQL(insert);
            Toast.makeText(getApplicationContext(),"Registro exitoso!",Toast.LENGTH_SHORT).show();
            database.close();

        }else if(rbPasteles.isChecked()==true){

            String insert="insert into "+Utilidades.tabla_productos+" ("+Utilidades.campo_nom_prod+","+Utilidades.campo_precio+","+Utilidades.campo_cantidad+","+Utilidades.campo_id_cat+") values('"
                    +campoNomProd.getText().toString()+"',"+campoPrecio.getText().toString()+","+campoCant.getText().toString()+",3)";
            database.execSQL(insert);
            Toast.makeText(getApplicationContext(),"Registro exitoso!",Toast.LENGTH_SHORT).show();
            database.close();

        }else if(rbAlcohol.isChecked()==true){

            String insert="insert into "+Utilidades.tabla_productos+" ("+Utilidades.campo_nom_prod+","+Utilidades.campo_precio+","+Utilidades.campo_cantidad+","+Utilidades.campo_id_cat+") values('"
                    +campoNomProd.getText().toString()+"',"+campoPrecio.getText().toString()+","+campoCant.getText().toString()+",4)";
            database.execSQL(insert);
            Toast.makeText(getApplicationContext(),"Registro exitoso!",Toast.LENGTH_SHORT).show();
            database.close();

        }
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
