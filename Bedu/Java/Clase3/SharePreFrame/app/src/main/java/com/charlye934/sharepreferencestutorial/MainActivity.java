package com.charlye934.sharepreferencestutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSig,btnGuardar;
    ImageView img1, img2, img3;
    EditText txtNombre, txtPass;
    LinearLayout linearLayout;
    SharedPreferences sharePref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharePref = getApplicationContext().getSharedPreferences("archivo", Context.MODE_PRIVATE);

        if(leerPreferencias()) {
            Toast.makeText(getApplicationContext(), "Ya iniciado", Toast.LENGTH_SHORT).show();
            cambiarPagina();
        }else{

            img1 = (ImageView) findViewById(R.id.img1);
            img2 = (ImageView) findViewById(R.id.img2);
            img3 = (ImageView) findViewById(R.id.img3);
            txtNombre = (EditText) findViewById(R.id.txtNombre);
            txtPass = (EditText) findViewById(R.id.txtPass);
            linearLayout = (LinearLayout) findViewById(R.id.linerLayout);
            btnSig = (Button) findViewById(R.id.btnSig);
            btnGuardar = (Button) findViewById(R.id.btnGuardar);

            btnSig.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            opcSig();
                        }
                    }
            );

            btnGuardar.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            guardar();
                        }
                    }
            );
        }
    }

    void opcSig(){
        if(img1.getVisibility() == View.VISIBLE) {
            img1.setVisibility(View.INVISIBLE);
            img2.setVisibility(View.VISIBLE);
        }else if(img2.getVisibility() == View.VISIBLE){
            img2.setVisibility(View.INVISIBLE);
            img3.setVisibility(View.VISIBLE);
        }else if(img3.getVisibility() == View.VISIBLE){
            img3.setVisibility(View.INVISIBLE);
            btnSig.setVisibility(View.INVISIBLE);
            linearLayout.setVisibility(View.VISIBLE);
        }
    }

    void guardar(){
        String nombre = txtNombre.getText().toString();
        String pass = txtPass.getText().toString();

        if(nombre.length() != 0 && pass.length() != 0){
            SharedPreferences.Editor obj_editor = sharePref.edit();
            obj_editor.putString("nombre", nombre);
            obj_editor.putString("pass", pass);
            obj_editor.commit();
            Toast.makeText(getApplicationContext(),"Se guardaron correctamente los datos", Toast.LENGTH_SHORT).show();
            cambiarPagina();
        }else{
            Toast.makeText(getApplicationContext(),"Se deben de llenar los campos", Toast.LENGTH_SHORT).show();
        }
    }

    Boolean leerPreferencias(){
        String nombres = sharePref.getString("nombre",null);
        return nombres != null;
    }

    void cambiarPagina(){
        Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
        startActivity(intent);
    }

}
