package com.example.bodega;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bodega.entidades.Productos;
import com.example.bodega.entidades.Usuario;
import com.example.bodega.utilidades.Utilidades;

import java.util.ArrayList;

public class Login extends AppCompatActivity {
    EditText campoUsuario,campoPassword;
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bodega",null,1);

        campoUsuario=(EditText)findViewById(R.id.etUsuario);
        campoPassword=(EditText)findViewById(R.id.etPassword);
    }

    public void onClick(View view){
        Intent intent=null;
        switch (view.getId()){
            case R.id.btnInicioSesion:
                iniciarSesion();
                break;
            case R.id.btnRegistroUsuario:
                Intent intent1=new Intent(Login.this,RegistroUsuario.class);
                startActivity(intent1);
                break;
            case R.id.btnQuienesSomos:
                Intent intent2=new Intent(Login.this,QuienesSomos.class);
                startActivity(intent2);
                break;
        }
    }

    private void iniciarSesion() {
        SQLiteDatabase database=conn.getReadableDatabase();
        String[] parametros={campoUsuario.getText().toString()};
        String[] campos={Utilidades.campo_password};

        try{
            Cursor cursor=conn.consultar(campoUsuario.getText().toString(),campoPassword.getText().toString());
            if (cursor.getCount()>0){
                Intent intent=null;
                intent=new Intent(Login.this,MainActivity.class);
                if (intent!=null){
                    startActivity(intent);
                }
            }else{
                Toast.makeText(getApplicationContext(),"Usuario y/o contraseña incorrecto(s)",Toast.LENGTH_SHORT).show();
            }
            cursor.close();
        }catch (Exception e) {
            Toast.makeText(getApplicationContext(), "El usuario no existe", Toast.LENGTH_SHORT).show();

        }
    }

    private void registrar() {
        SQLiteDatabase database=conn.getWritableDatabase();

        String insert="insert into "+Utilidades.tabla_usuario+" ("+Utilidades.campo_usuario+","+Utilidades.campo_password+") values('"+campoUsuario.getText().toString()+"','"+campoPassword.getText().toString()+"')";
        database.execSQL(insert);
        Toast.makeText(getApplicationContext(),"Registro exitoso!",Toast.LENGTH_SHORT).show();
        database.close();
    }
}
