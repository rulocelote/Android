package com.charlye934.ejemplo2

import android.util.Log

object miObjeto {
    var URL_BASE:String = "http://carlos.com"

    init {
        Log.d("Test","solo me ejecuto una vez")
    }

    fun saludar(){
        Log.d("Test","hola desde mi objeto")
    }
}