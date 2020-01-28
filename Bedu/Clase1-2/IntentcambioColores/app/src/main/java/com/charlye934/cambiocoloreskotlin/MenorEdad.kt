package com.charlye934.cambiocoloreskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_menor_edad.*

class MenorEdad : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menor_edad)

        var edad = intent.getIntExtra("edad",18)
        txtEdadMenor.setText("No puedes pasar con: \n $edad años")
    }
}
