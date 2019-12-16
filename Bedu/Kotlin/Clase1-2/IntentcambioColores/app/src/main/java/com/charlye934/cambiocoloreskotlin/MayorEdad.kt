package com.charlye934.cambiocoloreskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_mayor_edad.*

class MayorEdad : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mayor_edad)

        var edad = intent.getStringExtra("edad")
        txtEdadMayor.setText("Adelante con: \n $edad años")
    }
}
