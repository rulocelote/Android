package com.charlye934.pruebaframe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img1, img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1 = (ImageView)findViewById(R.id.img1);
        img2 = (ImageView)findViewById(R.id.img2);

        img1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cambiarImagen();
                    }
                }
        );

        img2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cambiarImagen();
                    }
                }
        );
    }

    void cambiarImagen(){
        if(img1.getVisibility() == View.VISIBLE){
            img1.setVisibility(View.INVISIBLE);
            img2.setVisibility(View.VISIBLE);
        }else{
            img1.setVisibility(View.VISIBLE);
            img2.setVisibility(View.INVISIBLE);
        }
    }
}
