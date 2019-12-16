package com.charlye934.almacenamientokotlin

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sharePreferences:SharedPreferences = applicationContext.getSharedPreferences("llave", Context.MODE_PRIVATE)
        btnBorrar.setOnClickListener { sharePreferences.edit().clear().commit() }

        if(leerPreferencias(sharePreferences)){
            Toast.makeText(applicationContext,"ya iniciado",Toast.LENGTH_SHORT).show()
        }else{
            var editor: SharedPreferences.Editor = sharePreferences.edit()
            editor.putString("llaveCorreo","charlye934").commit()
            Toast.makeText(getApplicationContext(), "Guardando nuevo registro", Toast.LENGTH_SHORT).show();
        }
    }

    fun leerPreferencias(sharePreferences:SharedPreferences):Boolean{
        var correo = sharePreferences.getString("llaveCorreo",null)
        return correo != null
    }

}
