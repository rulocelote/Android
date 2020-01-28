package com.example.mvprecyclerview.view.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mvprecyclerview.R
import com.example.mvprecyclerview.presenter.login.LoginPresenter
import com.example.mvprecyclerview.presenter.login.LoginPresenterImp
import com.example.mvprecyclerview.view.user.UserViewImp
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    LoginView {

    val presenter: LoginPresenter = LoginPresenterImp(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onLoginSuccess() {
        Toast.makeText(applicationContext,"Registro Exitoso", Toast.LENGTH_SHORT).show()
    }

    override fun onLoginExist() {
        val intent: Intent = Intent(applicationContext, UserViewImp::class.java)
        Toast.makeText(applicationContext,"El usuario ya existe", Toast.LENGTH_SHORT).show()
        startActivity(intent)
    }

    override fun onLoginEmailFail(){
        Toast.makeText(applicationContext,"El email ingresado no es valido", Toast.LENGTH_SHORT).show()
    }

    override fun onLoginFail() {
        Toast.makeText(applicationContext,"Error al registrar faltan datos", Toast.LENGTH_SHORT).show()
    }

    fun registrar(view: View){
        val nombre = txtNombre.text.toString()
        val email = txtEmail.text.toString()
        val telefono = txtTelefono.text.toString()
        presenter.Registrar(nombre,email,telefono)
    }
}
