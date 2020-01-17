package com.charlye934.figuras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.LinearLayout.LayoutParams

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calculaArea(view: View) {
        contenedor.removeAllViews()
        var tag = view.tag.toString()
        muestraImagen(tag)
        botonesCalcula()

        if(circulo.isChecked){
            areaCirculo()
        }else if(rectangulo.isChecked){

        }else if(triangulo.isChecked){

        }
    }

    fun areaCirculo(){
        var editText = EditText(this)
        var params = LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT)
        editText.layoutParams = params
        editText.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20F)
        editText.hint = "Ingrese el radio"
        editText.id
        contenedor.addView(editText)
    }

    fun muestraImagen(figura:String){
        var tipo:Int = when(figura){
            "circulo1" -> R.drawable.circ
            "rectangulo1" -> R.drawable.rect
            "triangulo1" -> R.drawable.trian
            else -> 0
        }
        val img = ImageView(this)
        val params = LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT)
        img.setImageResource(tipo)
        img.layoutParams = params
        contenedor.addView(img)
    }

    fun botonesCalcula(){
        var btnArea = Button(this)
        var btnPerimetro = Button(this)
        val params = LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT)
        btnArea.layoutParams = params
        btnArea.text = "Calcula area"
        btnPerimetro.text = "Calcula perimetro"
        btnPerimetro.layoutParams = params
        contenedor.addView(btnArea)
        contenedor.addView(btnPerimetro)
    }


}
