package com.charlye934.cambiocolores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainMenorEdad extends AppCompatActivity {
    TextView txtMensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menor_edad);

        txtMensaje = (TextView)findViewById(R.id.txtEdad);
        Intent intent = getIntent();

        int edad = intent.getIntExtra("edad",18);
        String mensaje = "No puedes pasar con: " + edad + " años-";
        txtMensaje.setText(mensaje);

    }
}
