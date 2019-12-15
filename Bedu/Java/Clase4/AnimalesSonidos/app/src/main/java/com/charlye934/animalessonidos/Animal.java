package com.charlye934.animalessonidos;

import android.media.MediaPlayer;
import android.util.Log;

public class Animal {
    private String animal;
    private int sonido;

    public Animal(String animal, int sonido) {
        this.animal = animal;
        this.sonido = sonido;
    }

    public int getSonido(){
        return sonido;
    }
}
