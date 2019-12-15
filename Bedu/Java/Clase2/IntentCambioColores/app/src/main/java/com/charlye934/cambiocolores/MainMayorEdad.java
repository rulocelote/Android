package com.charlye934.cambiocolores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainMayorEdad extends AppCompatActivity {

    TextView txtEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mayor_edad);

        txtEdad = (TextView)findViewById(R.id.txtEdad);
        Intent intent = getIntent();
        int edad = intent.getIntExtra("edad",18);

        String mensaje = "Puedes pasar con: " + edad +"años";
        txtEdad.setText(mensaje);


    }
}
