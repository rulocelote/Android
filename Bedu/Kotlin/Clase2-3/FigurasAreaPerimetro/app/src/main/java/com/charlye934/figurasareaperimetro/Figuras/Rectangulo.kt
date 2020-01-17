package com.charlye934.figurasareaperimetro.Figuras

import android.content.Context
import android.widget.LinearLayout
import com.charlye934.figurasareaperimetro.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class Rectangulo(context: Context, var contenedor: LinearLayout):ElementosInteractivos(context) {
    val imagen = imagen(R.drawable.rectangulo)
    var botonPerimetro = botones("Perimetro")
    var botonArea = botones("Area")
    var botonCalcular = botones("Calcular")
    var base = txtDato("Ingrese la base del rectangulo")
    var altura = txtDato("Ingrese la altura del rectangulo")


    fun muestraElementos(){
        contenedor.addView(imagen)
        contenedor.addView(botonPerimetro)
        contenedor.addView(botonArea)

        botonArea.setOnClickListener{
            pedirDatos()
            botonCalcular.setOnClickListener {
                calculaArea(base.text.toString().toDouble(),altura.text.toString().toDouble())
            }
        }

        botonPerimetro.setOnClickListener{
            pedirDatos()
            botonCalcular.setOnClickListener {
                calculaPerimetro(base.text.toString().toDouble(),altura.text.toString().toDouble())
            }
        }
    }

    fun calculaArea(base:Double, altura:Double){
        var resultado = base.times(altura)
        contenedor.removeAllViews()
        contenedor.addView(imagen)
        contenedor.addView(tvResultado("area",resultado))
    }

    fun calculaPerimetro(base:Double, altura:Double){
        var resultado = base.plus(base.plus(altura.plus(altura)))
        contenedor.removeAllViews()
        contenedor.addView(imagen)
        contenedor.addView(tvResultado("perimetro",resultado))
    }

    fun pedirDatos(){
        contenedor.removeAllViews()
        contenedor.addView(imagen)
        contenedor.addView(base)
        contenedor.addView(altura)
        contenedor.addView(botonCalcular)
    }
}