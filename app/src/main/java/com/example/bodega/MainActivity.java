package com.example.bodega;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this, "bodega",null,1);
    }
    public void onClick(View view){
        Intent intent=null;
        switch (view.getId()){
            case R.id.btnRegistrar:
                intent=new Intent(MainActivity.this,IngresoProductos.class);
                break;
            case R.id.btnMostrar:
                intent=new Intent(MainActivity.this,MostrarProductos.class);
                break;
            case R.id.btnListar:
                intent=new Intent(MainActivity.this, ListarProductos.class);
                break;
        }
        if (intent!=null){
            startActivity(intent);
        }
    }
}
