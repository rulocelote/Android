package com.charlye934.sharepreferencestutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    TextView tvBienvenida;
    TextView btnBorrra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sharedPreferences = getApplicationContext().getSharedPreferences("archivo", Context.MODE_PRIVATE);
        String nombre = sharedPreferences.getString("nombre","");

        tvBienvenida = (TextView)findViewById(R.id.tvBienvenida);
        tvBienvenida.setText("Bienvenido " + nombre);

        btnBorrra = (Button)findViewById(R.id.btnBorrar);
        btnBorrra.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        borrar();
                    }
                }
        );
    }

    void borrar(){
        sharedPreferences.edit().clear().commit();
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(),"Se han borrado los datos",Toast.LENGTH_SHORT).show();
    }
}
