package com.charlye934.figurasareaperimetro.Figuras

import android.content.Context
import android.widget.LinearLayout
import com.charlye934.figurasareaperimetro.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class Circulo(context: Context, var contenedor:LinearLayout):ElementosInteractivos(context){

    var imagen = imagen(R.drawable.circulo)
    var botonPerimetro = botones("Perimetro")
    var botonArea = botones("Area")
    var botonCalcular = botones("Calcular")
    var radio = txtDato("Ingrese el radio del circulo")

    fun muestraElementos(){
        contenedor.addView(imagen)
        contenedor.addView(botonPerimetro)
        contenedor.addView(botonArea)

        botonArea.setOnClickListener{
            pedirDatos()
            botonCalcular.setOnClickListener{
                determinaArea(radio.text.toString().toDouble())
            }
        }

        botonPerimetro.setOnClickListener{
            pedirDatos()
            botonCalcular.setOnClickListener{
                determinaPerimetro(radio.text.toString().toDouble())
            }
        }
    }

    fun determinaArea(radio:Double){
        val pi = 3.1416
        var result = pi.times(radio.pow(2))
        contenedor.removeAllViews()
        contenedor.addView(imagen)
        contenedor.addView(tvResultado("area",result))
    }

    fun determinaPerimetro(radio:Double){
        val pi = 3.1416
        var result:Double = 2.times(pi.times(radio))
        contenedor.removeAllViews()
        contenedor.addView(imagen)
        contenedor.addView(tvResultado("perimetro",result))
    }

    fun pedirDatos(){
        contenedor.removeAllViews()
        contenedor.addView(imagen)
        contenedor.addView(radio)
        contenedor.addView(botonCalcular)
    }
}