package com.example.bodega;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.bodega.entidades.Productos;
import com.example.bodega.utilidades.Utilidades;

import java.util.ArrayList;

public class ListarProductos extends AppCompatActivity {
    ListView listViewProd;
    ArrayList<String> listaInformacion;
    ArrayList<Productos> listaProductos;
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_productos);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bodega",null,1);

        listViewProd=(ListView) findViewById(R.id.listViewProd);

        consultarListaProd();

        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);
        listViewProd.setAdapter(adapter);
    }

    private void consultarListaProd() {
        SQLiteDatabase database=conn.getReadableDatabase();
        Productos productos=null;
        listaProductos=new ArrayList<Productos>();

        Cursor cursor=database.rawQuery("select * from "+ Utilidades.tabla_productos,null);

        while (cursor.moveToNext()){
            productos=new Productos();
            productos.setId(cursor.getInt(0));
            productos.setNomProd(cursor.getString(1));
            productos.setPrecio(cursor.getInt(2));
            productos.setCantidad(cursor.getInt(3));

            listaProductos.add(productos);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion=new ArrayList<String>();

        for (int i=0;i<listaProductos.size();i++){
            listaInformacion.add(listaProductos.get(i).getId()+" - "+listaProductos.get(i).getNomProd()+" - "+listaProductos.get(i).getPrecio()+" - "+listaProductos.get(i).getCantidad());
        }
    }
}
