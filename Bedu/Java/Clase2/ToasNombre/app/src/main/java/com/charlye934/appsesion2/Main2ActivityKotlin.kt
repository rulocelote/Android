package com.charlye934.appsesion2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class Main2ActivityKotlin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2_kotlin)

        btnEnviar.setOnClickListener{
            var nombre = txtNombre.text.toString()
            Toast.makeText(this,"Su nombre es: $nombre",Toast.LENGTH_SHORT).show()
        }
    }
}
