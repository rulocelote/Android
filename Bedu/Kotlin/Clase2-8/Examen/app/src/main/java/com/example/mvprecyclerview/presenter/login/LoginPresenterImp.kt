package com.example.mvprecyclerview.presenter.login

import android.util.Log
import com.example.mvprecyclerview.model.LoginModel
import com.example.mvprecyclerview.model.login.LoginModelImp
import com.example.mvprecyclerview.view.login.LoginView
import java.util.regex.Pattern

class LoginPresenterImp(var view: LoginView):
    LoginPresenter {
    val modelo: LoginModel = LoginModelImp()

    override fun Registrar(usuario: String, email: String, telefono: String) {
        //recibir datos
        var registroCorreo = modelo.CompruebaRegistro(email)

        if(!usuario.isEmpty() && !telefono.isEmpty() && !email.isEmpty()){
            if(registroCorreo){
                view.onLoginExist()
                Log.d("Prueba","" + modelo.RetornaDatos(email))
            }else{
                if(!validarEmail(email)){
                    view.onLoginEmailFail()
                }else{
                    view.onLoginSuccess()
                }
            }
        }else{
            view.onLoginFail()
        }
    }

    private fun validarEmail(email: String): Boolean {
        val pattern: Pattern = EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }

    val EMAIL_ADDRESS = Pattern.compile(
        "[a-z][a-z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "+((gmail)|(yahoo)|(hotmail)|(outlook))" +
                "(" +
                "." +
                "com" +
                ")"
    )
}