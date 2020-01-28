package com.charlye934.figurasareaperimetro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.charlye934.figurasareaperimetro.Figuras.Circulo
import com.charlye934.figurasareaperimetro.Figuras.ElementosInteractivos
import com.charlye934.figurasareaperimetro.Figuras.Rectangulo
import com.charlye934.figurasareaperimetro.Figuras.Triangulo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcula(view:View){
        if(circulo.isChecked){
            contenedor.removeAllViews()
            Circulo(this,contenedor).muestraElementos()
        }else if(rectangulo.isChecked){
            contenedor.removeAllViews()
            Rectangulo(this,contenedor).muestraElementos()
        }else if(triangulo.isChecked){
            contenedor.removeAllViews()
            Triangulo(this,contenedor).muestraElementos()
        }
    }
}
