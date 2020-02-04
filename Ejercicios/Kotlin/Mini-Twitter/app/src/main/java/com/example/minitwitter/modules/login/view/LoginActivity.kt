package com.example.minitwitter.modules.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.minitwitter.R
import com.example.minitwitter.retrofit.api.data.response.ResponseAuth
import com.example.minitwitter.utils.alertDialog
import com.example.minitwitter.modules.dashboard.DashboardActivity
import com.example.minitwitter.modules.login.presenter.LoginPresenter
import com.example.minitwitter.modules.login.presenter.LoginPresenterImp
import com.example.minitwitter.modules.singup.view.SingUpActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),View.OnClickListener, LoginView {

    private lateinit var loginPresenter:LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginPresenter = LoginPresenterImp(this, applicationContext)

        btn_entrar_login.setOnClickListener(this)
        et_registro_login.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_entrar_login ->{loginPresenter.validaDatos(et_email_login.text.toString(),et_password_login.text.toString())}
            R.id.et_registro_login -> { goToSingUp() }
        }
    }

    fun goToSingUp(){
        startActivity(Intent(this, SingUpActivity::class.java))
        finish()
    }

    override fun emailEmpty() {
        this.alertDialog(getString(R.string.error_data_empty_title),getString(R.string.error_email_empty_message),getString(R.string.btn_aceptar))
    }

    override fun passwordEmpty() {
        this.alertDialog(getString(R.string.error_data_empty_title),getString(R.string.error_password_empty_message),getString(R.string.btn_aceptar))
    }

    override fun responseSuccesful(response: ResponseAuth) {
        startActivity(Intent(this, DashboardActivity::class.java))
        finish()
    }

    override fun responseFail() {
        this.alertDialog(getString(R.string.error_data_title),getString(R.string.error_data_message),getString(R.string.btn_aceptar))
    }

    override fun responseErrorInternet() {
        this.alertDialog(getString(R.string.error_conexion_title),getString(R.string.error_conexion_message),getString(R.string.btn_aceptar))
    }
}
