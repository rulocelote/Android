package com.charlye934.cambiarimagenes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btnAtras, btnSig;
    ImageView img1, img2, img3, img4;
    int contador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1 = (ImageView)findViewById(R.id.img1);
        img2 = (ImageView)findViewById(R.id.img2);
        img3 = (ImageView)findViewById(R.id.img3);
        img4 = (ImageView)findViewById(R.id.img4);

        btnAtras = (Button)findViewById(R.id.btnAtras);
        btnSig = (Button)findViewById(R.id.btnSig);

        btnSig.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imageSig();
                    }
                }
        );

        btnAtras.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //TODO hacer codigo mas optimo
                    }
                }
        );
    }

    void imageSig(){
        if(img1.getVisibility() == View.VISIBLE){
            img1.setVisibility(View.INVISIBLE);
            img2.setVisibility(View.VISIBLE);
            img3.setVisibility(View.INVISIBLE);
            img4.setVisibility(View.INVISIBLE);
        }else if(img2.getVisibility() == View.VISIBLE){
            img1.setVisibility(View.INVISIBLE);
            img2.setVisibility(View.INVISIBLE);
            img3.setVisibility(View.VISIBLE);
            img4.setVisibility(View.INVISIBLE);
        }else if(img3.getVisibility() == View.VISIBLE){
            img1.setVisibility(View.INVISIBLE);
            img2.setVisibility(View.INVISIBLE);
            img3.setVisibility(View.INVISIBLE);
            img4.setVisibility(View.VISIBLE);
        }else{
            img1.setVisibility(View.VISIBLE);
            img2.setVisibility(View.INVISIBLE);
            img3.setVisibility(View.INVISIBLE);
            img4.setVisibility(View.INVISIBLE);
        }
    }

    void imageAtras(){
        if(img1.getVisibility() == View.VISIBLE){

        }else if(img2.getVisibility() == View.VISIBLE){

        }else if(img3.getVisibility() == View.VISIBLE){

        }else{

        }
    }
}
