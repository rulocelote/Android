package com.example.registromvp.model.login

interface LoginModel {
    fun CompruebaRegistro(email:String):Boolean
    fun RetornaDatos(email:String):String?
}