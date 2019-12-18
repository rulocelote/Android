package com.charlye934.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double res = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void CalculaRes(View view){
        Button btnResultado;
        double val = Double.parseDouble(String.valueOf(view.getTag()));
        res = res + val;

        btnResultado = (Button)findViewById(R.id.btnCalcular);
        btnResultado.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"resultado: " + res,Toast.LENGTH_SHORT).show();
                        res = 0;
                    }
                }
        );
    }
}
