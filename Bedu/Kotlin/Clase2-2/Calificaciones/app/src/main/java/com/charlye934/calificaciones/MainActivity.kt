package com.charlye934.calificaciones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.TableLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var alumnos:ArrayList<Array<String>> = arrayListOf(arrayOf("Carmen","Maria","Adalberto"), arrayOf("carlos","alberto","andrea"))
    var calificaciones:ArrayList<Array<String>> = arrayListOf(arrayOf("8","8","9","7"), arrayOf("8","8","9","7"), arrayOf("8","8","9","7"),arrayOf("8","8","9","7"), arrayOf("8","8","9","7"), arrayOf("8","8","9","7"))
    var materias:Array<String> = arrayOf("matematicas","historia","programacion","bases")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var a:MutableMap<String,String> = mutableMapOf()

        for (i in 0..alumnos.size - 1) {
           for (j in 0..alumnos[i].size-1) {
               for(k in 0..calificaciones.size-1){
                   for(l in 0..calificaciones[i].size-1){
                       val d = Log.d("tag", " + ${alumnos[i][j]} = ${calificaciones[k][l]}")
                   }
               }
           }
        }
    }
}
