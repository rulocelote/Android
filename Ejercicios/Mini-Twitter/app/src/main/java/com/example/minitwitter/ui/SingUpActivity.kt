package com.example.minitwitter.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.minitwitter.R
import com.example.minitwitter.retrofit.api.MiniTwitterClient
import com.example.minitwitter.retrofit.api.request.RequestSignup
import com.example.minitwitter.retrofit.api.response.ResponseAuth
import com.example.minitwitter.utils.Constantes
import com.example.minitwitter.utils.alertDialog
import kotlinx.android.synthetic.main.activity_sing_up.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SingUpActivity : AppCompatActivity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up)

        btn_registrar_registro.setOnClickListener(this)
        et_login_registro.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_registrar_registro ->{ validaDatos(et_nombre_registro.text.toString(),et_email_registro.text.toString(),et_password_regitro.text.toString())}
            R.id.et_login_registro -> { goToLogin() }
        }
    }

    fun validaDatos(userName: String, email: String, password: String) {
        if(userName.isEmpty()){
            this.alertDialog(getString(R.string.error_data_empty_title),getString(R.string.error_username_empty_message),getString(R.string.btn_aceptar))
        }else if(email.isEmpty()){
            this.alertDialog(getString(R.string.error_data_empty_title),getString(R.string.error_email_empty_message),getString(R.string.btn_aceptar))
        }else if(password.isEmpty()){
            this.alertDialog(getString(R.string.error_data_empty_title),getString(R.string.error_password_empty_message),getString(R.string.btn_aceptar))
        }else{
            doRegistro(userName,email,password)
        }
    }

    private val api = MiniTwitterClient.miniTwitterService

    fun doRegistro(username: String, email: String, password: String) {
        api.doSingUp(RequestSignup(username,email,password,Constantes.CODE)).enqueue(object :
            Callback<ResponseAuth> {
            override fun onFailure(call: Call<ResponseAuth>, t: Throwable) {
                responseErrorInternet()
            }

            override fun onResponse(call: Call<ResponseAuth>, response: Response<ResponseAuth>) {
                if (response.isSuccessful){
                    responseSucceful()
                }else{
                    responseFail()
                }
            }

        })
    }

    fun goToLogin(){
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    fun responseSucceful() {
        this.alertDialog(getString(R.string.enviar_datos_title),getString(R.string.enviar_datos_message),getString(R.string.btn_aceptar),getString(R.string.btn_cancelar),{
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        })
    }

    fun responseFail() {
        this.alertDialog(getString(R.string.error_data_title),getString(R.string.error_data_message),getString(R.string.btn_aceptar))
    }

    fun responseErrorInternet() {
        this.alertDialog(getString(R.string.error_conexion_title),getString(R.string.error_conexion_message),getString(R.string.btn_aceptar))
    }
}
