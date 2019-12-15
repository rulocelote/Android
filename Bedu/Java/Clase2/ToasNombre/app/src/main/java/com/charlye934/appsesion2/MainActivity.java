package com.charlye934.appsesion2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {

    EditText txtNombre;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        String nombre = txtNombre.getText().toString();
                        Toast.makeText(getApplicationContext(),"Hola" + nombre, LENGTH_LONG).show();

                    }
                }
        );
    }
}
