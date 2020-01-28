package com.example.mvprecyclerview.view.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvprecyclerview.R
import com.example.mvprecyclerview.model.data.Datos
import com.example.mvprecyclerview.presenter.user.UserPresent
import com.example.mvprecyclerview.presenter.user.UserPresentImp
import kotlinx.android.synthetic.main.activity_user.*

class UserViewImp : AppCompatActivity(),UserView {

    val userPresent:UserPresent = UserPresentImp(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        userPresent.ObtenerUsuarios()
    }

    override fun MostraUsuario(listaUsuarios: List<Datos>) {
        recyclerViewUsuarios.layoutManager = LinearLayoutManager(this)
        recyclerViewUsuarios.adapter = UserAdapter(listaUsuarios)
    }

    override fun FalloConexion(mensaje: String) {
        Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show()
    }
}
