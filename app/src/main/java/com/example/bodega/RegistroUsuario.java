package com.example.bodega;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bodega.utilidades.Utilidades;

public class RegistroUsuario extends AppCompatActivity {

    EditText campoNombre,campoApellido,campoRut,campoUsuario,campoPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);


        campoNombre=(EditText)findViewById(R.id.txtNombre);
        campoApellido=(EditText)findViewById(R.id.txtApellido);
        campoRut=(EditText)findViewById(R.id.txtRut);
        campoPassword=(EditText)findViewById(R.id.txtContra);
        campoUsuario=(EditText)findViewById(R.id.txtUsuario);
    }



    public void registrarUsuario(View view) {

        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this, "bodega",null,1);

        SQLiteDatabase database=conn.getWritableDatabase();

        String insert1="insert into "+Utilidades.tabla_usuario+" ("+Utilidades.campo_usuario+","+Utilidades.campo_password+") values('"+campoUsuario.getText().toString()+"','"+campoPassword.getText().toString()+"')";


        database.execSQL(insert1);

        Toast.makeText(getApplicationContext(),"Registro exitoso!",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(RegistroUsuario.this,Login.class);
        startActivity(intent);
        database.close();
    }
}
