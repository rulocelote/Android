package com.example.mvprecyclerview.model

interface LoginModel {
    fun CompruebaRegistro(email:String):Boolean
    fun RetornaDatos(email:String):String?
}