package com.charlye934.palindromox

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcula.setOnClickListener{
            cambiaVocales()
            Toast.makeText(applicationContext,"Palindromo? = ${palindromo()} ", Toast.LENGTH_SHORT).show()
        }

    }

    @SuppressLint("DefaultLocale")
    fun palindromo():Boolean{
        val lista: String = txtPalabras.text.toString().toLowerCase().trim().replace(" ","")
        var dec:Int = lista.length-1
        var inc = 0
        var res = true

        while (inc<dec && res){
            if(lista[inc] == lista[dec]){
                dec -=1
                inc += 1
            }else{
                res = false
            }
        }
        return res
    }

    fun cambiaVocales(){
        var lista: String = txtPalabras.text.toString().toLowerCase()
        var listaNueva = ""
        var inc:Int = lista.length-1
        var vocales = listOf('a','e','i','o','u')
        for(i in 0..inc){
            if(lista[i] in vocales){
                listaNueva += "x"
            }else{
                listaNueva += lista[i]
            }
        }
        tvResultado.setText(listaNueva)
    }
}
