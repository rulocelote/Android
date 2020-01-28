package com.charlye934.figurasareaperimetro.Figuras

import android.content.Context
import android.widget.LinearLayout
import com.charlye934.figurasareaperimetro.R

class Triangulo(context:Context, var contenedor:LinearLayout):ElementosInteractivos(context){
    val imagen = imagen(R.drawable.triangulo)
    var botonPerimetro = botones("Perimetro")
    var botonArea = botones("Area")
    var botonCalcular = botones("Calcular")
    var lado1 = txtDato("Ingrese el lado 1")
    var lado2 = txtDato("Ingrese el lado 2")
    var lado3 = txtDato("Ingrese el lado 3")
    var base = txtDato("Ingrese la base del triangulo")
    var altura = txtDato("Ingrese la altura del triangulo")

    fun muestraElementos(){
        contenedor.addView(imagen)
        contenedor.addView(botonPerimetro)
        contenedor.addView(botonArea)

        botonArea.setOnClickListener{
            contenedor.removeAllViews()
            contenedor.addView(imagen)
            contenedor.addView(base)
            contenedor.addView(altura)
            contenedor.addView(botonCalcular)
            botonCalcular.setOnClickListener {
                calculaArea(base.text.toString().toDouble(),altura.text.toString().toDouble())
            }
        }

        botonPerimetro.setOnClickListener{
            contenedor.removeAllViews()
            contenedor.addView(imagen)
            contenedor.addView(lado1)
            contenedor.addView(lado2)
            contenedor.addView(lado3)
            contenedor.addView(botonCalcular)
            botonCalcular.setOnClickListener {
                calculaPerimetro(lado1.text.toString().toDouble(),lado2.text.toString().toDouble(),lado3.text.toString().toDouble())
            }
        }
    }

    fun calculaArea(base:Double,altura:Double){
        var resultado = base.times(altura)/2
        contenedor.removeAllViews()
        contenedor.addView(imagen)
        contenedor.addView(tvResultado("area",resultado))
    }

    fun calculaPerimetro(lado1:Double, lado2:Double,lado3:Double){
        var resultado = lado1.plus(lado2.plus(lado3))
        contenedor.removeAllViews()
        contenedor.addView(imagen)
        contenedor.addView(tvResultado("perimetro",resultado))
    }
}