package com.example.reto1

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnEnviar.setOnClickListener{
            var texto = etNombre.text.toString()
            txtMensaje.text = texto

            if(texto.toUpperCase() == "JOKER"){
                batman.visibility = View.VISIBLE
                ironman.visibility = View.INVISIBLE
            }else if(texto.toUpperCase() == "THANOS"){
                batman.visibility = View.INVISIBLE
                ironman.visibility = View.VISIBLE
            }
        }
    }
}
