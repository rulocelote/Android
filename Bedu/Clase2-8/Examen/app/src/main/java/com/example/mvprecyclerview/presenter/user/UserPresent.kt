package com.example.mvprecyclerview.presenter.user

import com.example.mvprecyclerview.model.data.Datos

interface UserPresent {
    fun MostrarUsuarios(clientes:List<Datos>)
    fun ObtenerUsuarios()
    fun NoUser(mensaje:String)
}