package com.example.mvprecyclerview.view.user

import com.example.mvprecyclerview.model.data.Datos

interface UserView {
    fun MostraUsuario(listaUsuarios:List<Datos>)
    fun FalloConexion(mensaje:String)
}