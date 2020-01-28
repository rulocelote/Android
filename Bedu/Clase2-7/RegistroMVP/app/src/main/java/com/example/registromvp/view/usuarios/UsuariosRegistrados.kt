package com.example.registromvp.view.usuarios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.registromvp.R
import com.example.registromvp.model.data.Datos
import com.example.registromvp.presenter.usuarios.ClientesPresenter
import com.example.registromvp.presenter.usuarios.ClientresPresenterImp

class UsuariosRegistrados() : AppCompatActivity(),UsuariosView {

    var presenter:ClientesPresenter = ClientresPresenterImp(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuarios_registrados)

        presenter.ObtenerUsuarios()
    }

    override fun mostarUsuarios(listaUsuarios: List<Datos>) {
        Log.d("MENSAJE","${listaUsuarios[1]}")
    }

    override fun NoUsers(mensaje: String) {
        NoUsers(mensaje)
    }

}
