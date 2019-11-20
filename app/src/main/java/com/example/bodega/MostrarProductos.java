package com.example.bodega;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bodega.utilidades.Utilidades;

public class MostrarProductos extends AppCompatActivity {
    EditText campoId,campoNomProd,campoPrecio,campoCantidad;
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_productos);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bodega",null,1);

        campoId=(EditText)findViewById(R.id.etId);
        campoNomProd=(EditText)findViewById(R.id.etNomProd);
        campoPrecio=(EditText)findViewById(R.id.etPrecio);
        campoCantidad=(EditText)findViewById(R.id.etCantidad);
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnBuscar:
                consultar();
                break;
            case R.id.btnActualizar:
                break;
            case R.id.btnEliminar:
                break;
        }
    }

    private void consultar() {
        SQLiteDatabase database=conn.getReadableDatabase();
        String[] parametros={campoId.getText().toString()};
        String[] campos={Utilidades.campo_nom_prod,Utilidades.campo_precio,Utilidades.campo_cantidad};

        try{
            Cursor cursor=database.query(Utilidades.tabla_productos,campos,Utilidades.campo_id+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            campoNomProd.setText(cursor.getString(0));
            campoPrecio.setText(cursor.getString(1));
            campoCantidad.setText(cursor.getString(2));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El producto no existe",Toast.LENGTH_SHORT).show();
            limpiar();
        }


    }

    private void limpiar() {
        campoNomProd.setText("");
        campoPrecio.setText("");
        campoCantidad.setText("");
    }
}
