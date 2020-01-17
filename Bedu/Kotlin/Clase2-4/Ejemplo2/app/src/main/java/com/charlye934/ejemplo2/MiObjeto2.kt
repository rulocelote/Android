package com.charlye934.ejemplo2

import android.util.Log

class MiObjeto2(var nombre:String) {
    init {
        Log.d("Test","init de la clase")
        cont++
    }
    companion object{
        var cont=0
        init {
            Log.d("Test","Log del companio")
        }

        fun saludar(name:String):MiObjeto2{
            Log.d("Test","Hola $name")
            return MiObjeto2(name)
        }
    }
}