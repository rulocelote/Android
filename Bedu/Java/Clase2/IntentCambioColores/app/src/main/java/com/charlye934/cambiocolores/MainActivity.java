package com.charlye934.cambiocolores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtEdad;
    Button btnValidar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEdad = (EditText)findViewById(R.id.txtEdad);

        btnValidar = (Button)findViewById(R.id.btnValidar);
        btnValidar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int edad = Integer.parseInt(txtEdad.getText().toString());

                        if(edad > 18){
                            Intent intent = new Intent(getApplicationContext(),MainMayorEdad.class);
                            intent.putExtra("edad",edad);
                            startActivity(intent);
                        }else{
                            Intent intent = new Intent(getApplicationContext(),MainMenorEdad.class);
                            intent.putExtra("edad",edad);
                            startActivity(intent);

                        }
                    }
                }
        );


    }
}
