package com.example.registromvp.presenter.usuarios

import android.util.Log
import com.example.registromvp.model.usuarios.UsuarioModelImp
import com.example.registromvp.model.usuarios.UsuarioModel
import com.example.registromvp.model.data.Datos
import com.example.registromvp.view.usuarios.UsuariosView

class ClientresPresenterImp(var view:UsuariosView):ClientesPresenter {
    var usuarioModel: UsuarioModel = UsuarioModelImp(this)

    override fun MostrarUsuarios(clientes: List<Datos>) {
        view.mostarUsuarios(clientes)
    }

    override fun ObtenerUsuarios() {
        usuarioModel.recuperaDatos()
    }

    override fun NoUser(mensaje: String) {
        view.NoUsers(mensaje)
    }
}