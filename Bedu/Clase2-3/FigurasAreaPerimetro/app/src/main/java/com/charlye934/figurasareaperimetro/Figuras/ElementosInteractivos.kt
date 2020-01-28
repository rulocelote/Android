package com.charlye934.figurasareaperimetro.Figuras

import android.content.Context
import android.text.InputType
import android.widget.*
import android.widget.LinearLayout.LayoutParams
import kotlinx.android.synthetic.main.activity_main.*

open class ElementosInteractivos(var context:Context){
    val params = LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT)
    val paramsImage = LayoutParams(500,500)

    fun imagen(tipo:Int):ImageView{
        val img = ImageView(context)
        img.setImageResource(tipo)
        img.layoutParams = paramsImage
        return img
    }

    fun botones(texto:String):Button{
        val boton = Button(context)
        var tipo = ""
        boton.layoutParams = params
        boton.text = texto
        return boton
    }

    fun tvResultado(tipo:String, resultado:Double):TextView{
        val txtView = TextView(context)
        txtView.layoutParams = params
        txtView.setTextSize(25F)
        txtView.text = "El $tipo es: $resultado"
        return txtView
    }

    fun txtDato(texto: String):EditText{
        val edText = EditText(context)
        edText.layoutParams = params
        edText.hint = texto
        edText.inputType = InputType.TYPE_CLASS_NUMBER
        return edText
    }
}