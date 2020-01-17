package com.example.loginmvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.example.loginmvp.R
import com.example.loginmvp.presenter.LoginPresenter
import com.example.loginmvp.presenter.LoginPresenterImp
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),LoginView {

    val presenter:LoginPresenter = LoginPresenterImp(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onLoginSuccess() {
        var t = Toast.makeText(applicationContext,"Inicio exitoso",Toast.LENGTH_SHORT)
        //t.setGravity(Gravity.CENTER_VERTICAL,0,0)
        //t.show()
    }

    override fun onLoginFail() {
        Toast.makeText(applicationContext,"usuario o password incorrectos",Toast.LENGTH_SHORT)
    }

    fun Iniciar(view:View){
        val usuario = txtUsuario.text.toString()
        val password = txtPassord.text.toString()
        presenter.iniciar(usuario,password)
    }
}
