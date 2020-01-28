package com.example.recyclerdefinitivo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        llenarRecycler()
    }

    fun llenarRecycler(){
        var lista = ArrayList<Fruta>()
        lista.add(Fruta("platano","amaraillo","dulce", "Mediano"))
        lista.add(Fruta("fresa","rojo","dulce", "peque"))
        lista.add(Fruta("naranga","naranja","dulce", "peque"))
        lista.add(Fruta("sandia","verde","dulce","grande"))
        lista.add(Fruta("platano","amaraillo","dulce", "Mediano"))
        lista.add(Fruta("fresa","rojo","dulce", "peque"))
        lista.add(Fruta("naranga","naranja","dulce", "peque"))
        lista.add(Fruta("sandia","verde","dulce","grande"))
        lista.add(Fruta("platano","amaraillo","dulce", "Mediano"))
        lista.add(Fruta("fresa","rojo","dulce", "peque"))
        lista.add(Fruta("naranga","naranja","dulce", "peque"))
        lista.add(Fruta("sandia","verde","dulce","grande"))
        lista.add(Fruta("platano","amaraillo","dulce", "Mediano"))
        lista.add(Fruta("fresa","rojo","dulce", "peque"))
        lista.add(Fruta("naranga","naranja","dulce", "peque"))
        lista.add(Fruta("sandia","verde","dulce","grande"))
        lista.add(Fruta("platano","amaraillo","dulce", "Mediano"))
        lista.add(Fruta("fresa","rojo","dulce", "peque"))
        lista.add(Fruta("naranga","naranja","dulce", "peque"))
        lista.add(Fruta("sandia","verde","dulce","grande"))
        lista.add(Fruta("platano","amaraillo","dulce", "Mediano"))
        lista.add(Fruta("fresa","rojo","dulce", "peque"))
        lista.add(Fruta("naranga","naranja","dulce", "peque"))
        lista.add(Fruta("sandia","verde","dulce","grande"))

        var miManager = LinearLayoutManager(this)
        //miManager = GridLayoutManager(this,2)
        //var miManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        miRecycler.layoutManager = miManager
        miRecycler.adapter = miAdaptador(lista)

    }
}
