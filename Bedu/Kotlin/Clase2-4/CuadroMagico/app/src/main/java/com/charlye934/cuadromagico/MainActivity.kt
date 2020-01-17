package com.charlye934.cuadromagico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcula(view:View){
        var valorET = arrayOf(valor1,valor2,valor3,valor4,valor5,valor6,valor7,valor8,valor9)
        var valorDouble:DoubleArray = doubleArrayOf(0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0)
        var matriz = Array(valorET.size) { arrayOfNulls<Double>(valorET.size) }
        var contador = 0
        var resultado = 0.0

        for(i in 0..2){
            for(j in 0..2){
                valorDouble[contador] = valorET[contador].text.toString().toDouble()
                matriz[i][j] = valorDouble[contador]
                if(i == j){
                    resultado += matriz[i][j]!!
                }
                contador++
            }
        }
        Toast.makeText(this,"Numero mayor = ${valorDouble.max()}",Toast.LENGTH_SHORT).show()
        Toast.makeText(this,"Numero menor = ${valorDouble.min()}",Toast.LENGTH_SHORT).show()
        Toast.makeText(this,"Suma Diagonal = $resultado",Toast.LENGTH_SHORT).show()
    }

    fun calcular(view: View) {
        var etValor = arrayOf(valor1,valor2,valor3,valor4,valor5,valor6,valor7,valor8,valor9)
        lateinit var valor:DoubleArray
        for(i in 0..etValor.size-1){
            valor[i] = etValor[i].text.toString().toDouble()
        }
        Log.d("tag","tamaño = ${valor.max()}")
        Log.d("tag","tamaño = ${valor.min()}")
    }

    fun calcularMatriz(view: View) {
        var etValor1 = arrayOf(valor1.text.toString().toDouble(),valor2.text.toString().toDouble(),valor3.text.toString().toDouble())
        var etValor2 = arrayOf(valor4.text.toString().toDouble(),valor5.text.toString().toDouble(),valor6.text.toString().toDouble())
        var etValor3 = arrayOf(valor7.text.toString().toDouble(),valor8.text.toString().toDouble(),valor9.text.toString().toDouble())
        var valor = arrayOf(etValor1,etValor2,etValor3)
        var mayorMenor = doubleArrayOf(0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0)
        var resultado = 0.0
        var contador = 0

        for(i in 0..valor.size-1){
            for(j in 0..valor[i].size-1){
                mayorMenor[contador] = valor[i][j]
                if(i == j){
                    resultado = valor[i][j] + resultado
                }
                contador++
            }
        }
        Toast.makeText(this,"Numero mayor = ${mayorMenor.max()}",Toast.LENGTH_SHORT).show()
        Toast.makeText(this,"Numero menor = ${mayorMenor.min()}",Toast.LENGTH_SHORT).show()
        Toast.makeText(this,"Suma Diagonal = $resultado",Toast.LENGTH_SHORT).show()
    }
}
