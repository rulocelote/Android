package com.example.minitwitter.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.minitwitter.R
import com.example.minitwitter.retrofit.api.response.ResponseAuth
import com.example.minitwitter.utils.alertDialog
import com.example.minitwitter.modules.login.presenter.LoginPresenter
import com.example.minitwitter.modules.login.presenter.LoginPresenterImp
import com.example.minitwitter.modules.login.view.LoginView
import com.example.minitwitter.utils.realm.RealmUtils
import com.example.minitwitter.retrofit.api.MiniTwitterClient
import com.example.minitwitter.retrofit.api.request.RequestLogin
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_entrar_login.setOnClickListener(this)
        et_registro_login.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_entrar_login ->{validaDatos(et_email_login.text.toString(),et_password_login.text.toString())}
            R.id.et_registro_login -> { goToSingUp() }
        }
    }

    fun validaDatos(email: String, password: String) {
        RealmUtils.realmData(this).eliminarData()
        if(email.isEmpty()){
            this.alertDialog(getString(R.string.error_data_empty_title),getString(R.string.error_email_empty_message),getString(R.string.btn_aceptar))
        }else if(password.isEmpty()){
            this.alertDialog(getString(R.string.error_data_empty_title),getString(R.string.error_password_empty_message),getString(R.string.btn_aceptar))
        }else{
            doLogin(email, password)
        }
    }

    private val api = MiniTwitterClient.miniTwitterService

    fun doLogin(email: String, password: String) {
        api.doLogin(RequestLogin(email, password)).enqueue(object : Callback<ResponseAuth> {
            override fun onFailure(call: Call<ResponseAuth>, t: Throwable) {
                responseErrorInternet()
            }

            override fun onResponse(call: Call<ResponseAuth>, response: Response<ResponseAuth>) {
                if(response.isSuccessful){
                    response.body()?.let { responseSuccesful(it) }
                }else{
                    responseFail()
                }
            }
        })
    }

    fun goToSingUp(){
        startActivity(Intent(this, SingUpActivity::class.java))
        finish()
    }

    fun responseSuccesful(response: ResponseAuth) {
        RealmUtils.realmData(this).crearToken(response.token)
        startActivity(Intent(this, DashboardActivity::class.java))
        finish()
    }

    fun responseFail() {
        this.alertDialog(getString(R.string.error_data_title),getString(R.string.error_data_message),getString(R.string.btn_aceptar))
    }

    fun responseErrorInternet() {
        this.alertDialog(getString(R.string.error_conexion_title),getString(R.string.error_conexion_message),getString(R.string.btn_aceptar))
    }
}
