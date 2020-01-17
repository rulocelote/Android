package com.example.registromvp.view.usuarios

import com.example.registromvp.model.data.Datos

interface UsuariosView{
    fun mostarUsuarios(listaUsuarios:List<Datos>)
    fun NoUsers(mensaje:String)
}