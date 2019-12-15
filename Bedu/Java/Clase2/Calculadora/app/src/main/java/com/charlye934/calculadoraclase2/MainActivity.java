package com.charlye934.calculadoraclase2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtNum1, txtNum2;
    Button btnSuma, btnResta, btnMultiplicar, btnDividir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNum1 = (EditText)findViewById(R.id.txtNum1);
        txtNum2 = (EditText)findViewById(R.id.txtNum2);

        btnSuma = (Button)findViewById(R.id.btnSumar);
        btnResta =(Button)findViewById(R.id.btnRestar);
        btnMultiplicar = (Button)findViewById(R.id.btnMultiplicar);
        btnDividir = (Button)findViewById(R.id.btnDividir);



        btnSuma.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        int num1Int = Integer.parseInt(txtNum1.getText().toString());
                        int num2Int = Integer.parseInt(txtNum2.getText().toString());
                        Toast.makeText(getApplicationContext(),"Suma: " + (num1Int+num2Int),Toast.LENGTH_LONG).show();
                    }
                }
        );

        btnResta.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        int num1Int = Integer.parseInt(txtNum1.getText().toString());
                        int num2Int = Integer.parseInt(txtNum2.getText().toString());
                        Toast.makeText(getApplicationContext(),"Resta: " + (num2Int-num2Int),Toast.LENGTH_LONG).show();
                    }
                }
        );

        btnMultiplicar.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        int num1Int = Integer.parseInt(txtNum1.getText().toString());
                        int num2Int = Integer.parseInt(txtNum2.getText().toString());
                        Toast.makeText(getApplicationContext(),"Multiplicacion: " + (num2Int*num2Int),Toast.LENGTH_LONG).show();
                    }
                }
        );

        btnDividir.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        int num1Int = Integer.parseInt(txtNum1.getText().toString());
                        int num2Int = Integer.parseInt(txtNum2.getText().toString());
                        Toast.makeText(getApplicationContext(),"Division: " + (num2Int/num2Int),Toast.LENGTH_LONG).show();
                    }
                }
        );

    }
}
