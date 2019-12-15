package com.charlye934.almacenamiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharePref;
    Button btnBorrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBorrar = (Button)findViewById(R.id.btnBorrar);
        btnBorrar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        borrar();
                    }
                }
        );

        sharePref = getApplicationContext().getSharedPreferences(getString(R.string.shared_llave), Context.MODE_PRIVATE);
        if(leerPreferencias()){
            Toast.makeText(getApplicationContext(), "Ya iniciado", Toast.LENGTH_SHORT).show();
        }else{
            SharedPreferences.Editor editor = sharePref.edit();
            editor.putString(getString(R.string.shared_llave_correo),"charlye@gmail.com");
            editor.commit();
            Toast.makeText(getApplicationContext(), "Guardando nuevo registro", Toast.LENGTH_SHORT).show();
        }
    }

    Boolean leerPreferencias(){
        String correo = sharePref.getString(getString(R.string.shared_llave_correo),null);
        return correo != null;
    }

    void borrar(){
        sharePref.edit().clear().commit();
    }
}
