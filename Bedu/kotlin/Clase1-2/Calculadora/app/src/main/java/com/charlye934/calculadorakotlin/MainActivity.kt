package com.charlye934.calculadorakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun operacion(view: View) {
        var num1_String = txtNum1.text.toString()
        var num2_String = txtNum2.text.toString()
        var result:String
        var tag = view.tag

        if(num1_String.isEmpty() || num2_String.isEmpty())
            result = "Favor de agregar un valor en ambos campos"
        else{
            var num1 = num1_String.toDouble()
            var num2 = num2_String.toDouble()
            result = when(tag){
                "suma" -> "suma = " + (num1 + num2)
                "resta" -> "resta = " + (num1 - num2)
                "multi" -> "multiplicacion = " + (num1 * num2)
                "divi" -> "division = " + (num1 / num2)
                else -> ""
            }
        }
        Toast.makeText(this,result,Toast.LENGTH_SHORT).show()
    }
}
