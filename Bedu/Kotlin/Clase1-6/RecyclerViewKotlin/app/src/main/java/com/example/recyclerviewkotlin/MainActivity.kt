package com.example.recyclerviewkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val lista = ArrayList<Cuadros>()
        val nombre = arrayOf(getString(R.string.nombre_uno),getString(R.string.nombre_dos),getString(R.string.nombre_tres),getString(R.string.nombre_cuatro),getString(R.string.nombre_cinco),getString(R.string.nombre_seis),getString(R.string.nombre_siete),getString(R.string.nombre_ocho),getString(R.string.nombre_nueve))
        val imagenes = arrayOf(R.drawable.cuadro1, R.drawable.cuadro2, R.drawable.cuadro3, R.drawable.cuadro4, R.drawable.cuadro5, R.drawable.cuadro6, R.drawable.cuadro7, R.drawable.cuadro8, R.drawable.cuadro9)
        val fotos = arrayOf(R.drawable.per1,R.drawable.per4,R.drawable.per2,R.drawable.per3,R.drawable.per5,R.drawable.per6,R.drawable.per7,R.drawable.per8,R.drawable.per9)
        val frases = arrayOf(getString(R.string.frase_uno),getString(R.string.frase_dos),getString(R.string.frase_tres),getString(R.string.frase_cuatro),getString(R.string.frase_cinco),getString(R.string.frase_seis),getString(R.string.frase_siete),getString(R.string.frase_ocho),getString(R.string.frase_nueve))

        for(i in 0..nombre.size-1)
            lista.add(Cuadros(imagenes[i],fotos[i],nombre[i],frases[i]))

        val miManager = LinearLayoutManager(this)
        myRecycler.layoutManager = miManager
        myRecycler.adapter = miAdaptador(lista,this)
    }

}
