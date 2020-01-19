package com.example.duckhunt.view.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.duckhunt.R
import com.example.duckhunt.presenter.login.LoginPresenter
import com.example.duckhunt.presenter.login.LoginPresenterImp
import com.example.duckhunt.utils.Constantes
import com.example.duckhunt.view.game.GameActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),LoginView, View.OnClickListener {

    lateinit private var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginPresenter =
            LoginPresenterImp(this)
        btnLoginIniciar.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view!!.id){
            R.id.btnLoginIniciar -> {loginPresenter.validaNick(etLoginNickName.text.toString())}
        }
    }

    override fun successLogin() {
        startActivity(Intent(this, GameActivity::class.java).putExtra(Constantes.EXTRA_NICK,etLoginNickName.text.toString()))
    }

    override fun errorLoginObligatorio() {
        etLoginNickName.error = getString(R.string.nombre_obligatorio)
    }

    override fun errorLoginCaracteres() {
        etLoginNickName.error = getString(R.string.nombre_min_caracteres)
    }
}
