package com.charlye934.scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Map<String,Integer> animalesList = new HashMap<>();
    String animales[] = {"caballo","cabra","cerdo","gallo","mono","perro", "serpiente","tigre"};
    int sonidoAnimales[] = {R.raw.caballo,R.raw.cabra,R.raw.cerdo,R.raw.gallo,R.raw.mono,R.raw.perro,R.raw.serpiente,R.raw.tigre};
    MediaPlayer sonidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0; i<animales.length; i++){
            animalesList.put(animales[i],sonidoAnimales[i]);
        }

        //Pondremos el icono en el action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_foreground);
    }

    public void seleccionaAnimal(View view){
        ImageButton v = (ImageButton)view;
        String animal = String.valueOf(v.getTag());
        ejecutaSonido(animal);
    }

    public void ejecutaSonido(String nombreAnimal){
        int ani = animalesList.get(nombreAnimal);
        if(sonidos != null ){
            sonidos.stop();
        }
        sonidos = MediaPlayer.create(getApplicationContext(),ani);
        sonidos.start();
    }
}
