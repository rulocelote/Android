package com.example.mvprecyclerview.presenter.user

import com.example.mvprecyclerview.model.data.Datos
import com.example.mvprecyclerview.model.user.UserModel
import com.example.mvprecyclerview.model.user.UserModelImp
import com.example.mvprecyclerview.view.user.UserView

class UserPresentImp(var view:UserView) :UserPresent{
    val userModel:UserModel = UserModelImp(this)

    override fun MostrarUsuarios(listaUsuarios: List<Datos>) {
        view.MostraUsuario(listaUsuarios)
    }

    override fun ObtenerUsuarios() {
        userModel.recuperaDatos()
    }

    override fun NoUser(mensaje: String) {
        view.FalloConexion(mensaje)
    }
}