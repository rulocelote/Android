package com.charlye934.sharepreferencestutorialkotlin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var sharedPreferences = applicationContext.getSharedPreferences("archivo",Context.MODE_PRIVATE)
        var nombre = sharedPreferences.getString("nombre","")

        tvBienvenida.text = "Bienvenido $nombre"
    }

    fun borrar(view:View){
        var sharedPreferences:SharedPreferences = applicationContext.getSharedPreferences("archivo",Context.MODE_PRIVATE)
        sharedPreferences.edit().clear().commit()
        intent = Intent(applicationContext,MainActivity::class.java)
        startActivity(intent)
        Toast.makeText(applicationContext,"Se han borrado los datos",Toast.LENGTH_SHORT).show()
    }
}
