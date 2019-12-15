package com.charlye934.cambiocoloreskotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnValidar.setOnClickListener {
            var edad = txtEdad.text.toString()
            if (edad.isEmpty()){
                Toast.makeText(this,"Favor de ingresar su edad",Toast.LENGTH_SHORT).show()
            }else{
                if(edad.toInt()>18){
                    val intent = Intent(this, MayorEdad::class.java).apply {
                        putExtra("edad",edad)
                    }
                    startActivity(intent)
                }else{
                    val intent = Intent(this,MenorEdad::class.java).apply {
                        putExtra("edad",edad)
                    }
                    startActivity(intent)
                }
            }
        }
    }
}
