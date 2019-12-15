package com.charlye934.animalessonidos;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Map<String, Integer> animalesList = new HashMap<>();
    MediaPlayer sonido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        animalesList.put("caballo", R.raw.caballo);
        animalesList.put("cabra", R.raw.cabra);
        animalesList.put("cerdo", R.raw.cerdo);
        animalesList.put("gallo", R.raw.gallo);
        animalesList.put("mono", R.raw.mono);
        animalesList.put("perro", R.raw.perro);
        animalesList.put("serpiente", R.raw.serpiente);
        animalesList.put("tigre", R.raw.tigre);
    }

    public void ejecutaSonido(String nombreAnimal){
        int ani = animalesList.get(nombreAnimal);
        if(sonido != null){
            sonido.stop();
        }
        sonido = MediaPlayer.create(getApplicationContext(), ani);
        sonido.start();

    }

    public void seleccionaAnimal(View view){
        ImageView v = (ImageView)view;
        String animal = String.valueOf(v.getTag());
        ejecutaSonido(animal);
    }
}
