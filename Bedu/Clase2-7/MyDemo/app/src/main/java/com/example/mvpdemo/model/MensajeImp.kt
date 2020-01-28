package com.example.mvpdemo.model

class MensajeImp:Mensaje {
    override fun saludar(nombre: String): String {
        return "Hola $nombre, estas usando MVP"
    }

}