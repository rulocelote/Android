package com.example.scrollviewanimales

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var animaList:Map<String,Int> = mapOf("caballo" to R.raw.caballo,"cabra" to R.raw.cabra,"cerdo" to R.raw.cerdo,"gallo" to R.raw.gallo,"mono" to R.raw.mono,"perro" to R.raw.perro, "serpiente" to R.raw.serpiente,"tigre" to R.raw.tigre)
    var sonidos:MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Pondremos el icono en el action bar
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setIcon(R.mipmap.ic_launcher_foreground)
    }

    fun seleccionaAnimal(view:View){
        val animal = view.tag.toString()
        ejecutaSOnido(animal)
    }

    fun ejecutaSOnido(nombreAnimal:String){
        var animal = animaList.get(nombreAnimal)
        if(sonidos != null){
            sonidos!!.stop()
        }
        sonidos = MediaPlayer.create(applicationContext,animal!!)
        sonidos!!.start()
    }


}
