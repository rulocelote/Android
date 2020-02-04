package com.example.minitwitter.modules.singup.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.minitwitter.R
import com.example.minitwitter.modules.login.view.LoginActivity
import com.example.minitwitter.modules.singup.presenter.SingUpPresenter
import com.example.minitwitter.modules.singup.presenter.SingUpPresenterImp
import com.example.minitwitter.utils.alertDialog
import kotlinx.android.synthetic.main.activity_sing_up.*

class SingUpActivity : AppCompatActivity(), View.OnClickListener, SingUpView {

    private lateinit var singUpPresenter:SingUpPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up)

        singUpPresenter = SingUpPresenterImp(this)

        btn_registrar_registro.setOnClickListener(this)
        et_login_registro.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_registrar_registro ->{ singUpPresenter.validaDatos(et_nombre_registro.text.toString(),et_email_registro.text.toString(),et_password_regitro.text.toString())}
            R.id.et_login_registro -> { goToLogin() }
        }
    }

    fun goToLogin(){
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    override fun userEmpty() {
        this.alertDialog(getString(R.string.error_data_empty_title),getString(R.string.error_username_empty_message),getString(R.string.btn_aceptar))
    }

    override fun emailEmpty() {
        this.alertDialog(getString(R.string.error_data_empty_title),getString(R.string.error_email_empty_message),getString(R.string.btn_aceptar))
    }

    override fun passwordEmpty() {
        this.alertDialog(getString(R.string.error_data_empty_title),getString(R.string.error_password_empty_message),getString(R.string.btn_aceptar))
    }

    override fun responseSucceful() {
        this.alertDialog(getString(R.string.enviar_datos_title),getString(R.string.enviar_datos_message),getString(R.string.btn_aceptar),getString(R.string.btn_cancelar),{
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        })
    }

    override fun responseFail() {
        this.alertDialog(getString(R.string.error_data_title),getString(R.string.error_data_message),getString(R.string.btn_aceptar))
    }

    override fun responseErrorInternet() {
        this.alertDialog(getString(R.string.error_conexion_title),getString(R.string.error_conexion_message),getString(R.string.btn_aceptar))
    }
}
