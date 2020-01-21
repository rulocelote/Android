package com.sem.empresasappandcmal.view.login

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sem.empresasappandcmal.CustomProgressDialog
import com.sem.empresasappandcmal.MainActivity
import com.sem.empresasappandcmal.R
import com.sem.empresasappandcmal.presenter.login.LoginPresenter
import com.sem.empresasappandcmal.presenter.login.LoginPresenterImp
import com.sem.empresasappandcmal.utils.*
import com.sem.empresasappandcmal.view.pass_olvidado.OlvidoPassActivity
import com.sem.empresasappandcmal.view.registro.RegistroActivity
import kotlinx.android.synthetic.main.login_main.*

class LoginActivity : AppCompatActivity(), LoginView,View.OnClickListener{

    private lateinit var loginPresenter: LoginPresenter
    private lateinit var progresBar:CustomProgressDialog

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_main)

        loginPresenter = LoginPresenterImp(this,applicationContext)

        etNumEmpLogin.textWatcher{habilitaBoton()}
        etPassLogin.textWatcher{habilitaBoton()}

        btnEntrar.setOnClickListener(this)
        txtRegistro.setOnClickListener(this)
        txtPassOlvidado.setOnClickListener(this)

        txtPassOlvidado.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
    }

    override fun onLoginSucces(descripcion: String,idEmpleado:String) {
        loginPresenter.deleteDatabase()
        startActivity(Intent(this, MainActivity::class.java).putExtra("idEmpleado",idEmpleado))
        finish()
    }

    override fun numEmpleadoFail(descripcion:String) {
        this.alertDialog(getString(R.string.title_alert_login_id_fail),descripcion,getString(R.string.btn_aceptar))
    }

    override fun passwordFail(descripcion: String) {
        this.alertDialog(getString(R.string.title_alert_login_pass_fail),descripcion,getString(R.string.btn_aceptar))
    }

    override fun conexionFail() {
        this.alertDialog(getString(R.string.title_alert_conexion_fail), getString(R.string.error_conexion), getString(R.string.btn_aceptar))
    }

    override fun showProgres() {
        progresBar = CustomProgressDialog(this)
        progresBar.showCustomProgressDialog()
    }

    override fun hideProgres() {
        progresBar.dismissCustomProgressDialog()
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnEntrar -> {
                if(tilNumEmpleadoLogin.validaLong(etNumEmpLogin,6) && tilPassLogin.validaPassword(etPassLogin))
                    loginPresenter.compruebaCampos(etNumEmpLogin.text.toString(), etPassLogin.text.toString())
                else
                    etNumEmpLogin.textWatcher { tilNumEmpleadoLogin.validaLong(etNumEmpLogin,6) }
                    etPassLogin.textWatcher { tilPassLogin.validaPassword(etPassLogin) }
            }
            R.id.txtRegistro -> startActivity(Intent(this, RegistroActivity::class.java))
            R.id.txtPassOlvidado ->  startActivity(Intent(this,OlvidoPassActivity::class.java))
        }
    }

    private fun habilitaBoton() {
        val validacion = etNumEmpLogin.validaVacios() && etPassLogin.validaVacios()
        btnEntrar.isEnabled = validacion
        if(validacion)
            btnEntrar.setBackgroundColor(getColor(R.color.colorPrimary))
        else
            btnEntrar.setBackgroundColor(getColor(R.color.colorGris))
    }
}