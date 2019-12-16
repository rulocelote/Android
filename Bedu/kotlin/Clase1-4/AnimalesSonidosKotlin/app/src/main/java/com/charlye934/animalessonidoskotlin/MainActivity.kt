package com.charlye934.animalessonidoskotlin

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    var animalesList: MutableMap<String, Int> = HashMap()
    var sonido: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        animalesList["caballo"] = R.raw.caballo
        animalesList["cabra"] = R.raw.cabra
        animalesList["cerdo"] = R.raw.cerdo
        animalesList["gallo"] = R.raw.gallo
        animalesList["mono"] = R.raw.mono
        animalesList["perro"] = R.raw.perro
        animalesList["serpiente"] = R.raw.serpiente
        animalesList["tigre"] = R.raw.tigre
    }

    fun ejecutaSonido(nombreAnimal: String) {
        val ani: Int? = animalesList.get(nombreAnimal)
        if (sonido != null) {
            sonido!!.stop()
        }
        if(ani != null) MediaPlayer.create(applicationContext, ani).start()
    }

    fun seleccionaAnimal(view: View) {
        val v = view as ImageView
        val animal = v.tag.toString()
        ejecutaSonido(animal)
    }
}
