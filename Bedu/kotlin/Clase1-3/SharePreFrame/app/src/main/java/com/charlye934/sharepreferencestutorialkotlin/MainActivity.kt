package com.charlye934.sharepreferencestutorialkotlin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharePreferences:SharedPreferences = applicationContext.getSharedPreferences("archivo", Context.MODE_PRIVATE)
        if (leerPreferencias(sharePreferences)) {
            Toast.makeText(applicationContext, "Ya iniciado", Toast.LENGTH_LONG).show()
            cambiarPagina()
        } else {
            btnSig.setOnClickListener{opcSig()}
            btnGuardar.setOnClickListener { guardar(sharePreferences) }
        }
    }

    fun leerPreferencias(sharedPreferences: SharedPreferences ): Boolean {
        var nombres = sharedPreferences.getString("nombre", null)
        return nombres != null
    }

    fun opcSig(){
        if(img1.visibility == View.VISIBLE){
            img1.setVisibility(View.INVISIBLE)
            img2.setVisibility(View.VISIBLE)
        }else if(img2.visibility == View.VISIBLE){
            img2.setVisibility(View.INVISIBLE)
            img3.setVisibility(View.VISIBLE)
        }else if(img3.visibility == View.VISIBLE){
            img3.visibility = View.INVISIBLE
            btnSig.visibility = View.INVISIBLE
            linerLayout.setVisibility(View.VISIBLE)
        }
    }

    fun guardar(sharedPreferences: SharedPreferences){
        var nombre = txtNombre.text.toString()
        var pass = txtPass.text.toString()
        if(!nombre.isEmpty() && !pass.isEmpty()){
            var objEditor = sharedPreferences.edit()
            objEditor.putString("nombre", nombre)
            objEditor.commit()
            Toast.makeText(applicationContext, "Se guardaron correctamente los datos", Toast.LENGTH_SHORT).show()
            cambiarPagina()
        }else{
            Toast.makeText(applicationContext, "Se deben de llenar los campos", Toast.LENGTH_SHORT).show()
        }
    }

    fun cambiarPagina() {
        val intent = Intent(this, Main2Activity::class.java)
        startActivity(intent)
    }
}
