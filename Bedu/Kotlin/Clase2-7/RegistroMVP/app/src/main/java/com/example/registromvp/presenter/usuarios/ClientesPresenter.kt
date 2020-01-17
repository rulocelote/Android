package com.example.registromvp.presenter.usuarios

import com.example.registromvp.model.data.Datos

interface ClientesPresenter {
    fun MostrarUsuarios(clientes:List<Datos>)
    fun ObtenerUsuarios()
    fun NoUser(mensaje:String)
}