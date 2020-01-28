package com.example.loginmvp.presenter

import com.example.loginmvp.model.Login
import com.example.loginmvp.model.LoginImp
import com.example.loginmvp.view.LoginView

class LoginPresenterImp(var view:LoginView) : LoginPresenter{
    val modelo:Login = LoginImp()
    override fun iniciar(usuario: String, password: String) {
        //recibir datos
        var inicioCorreo = modelo.Login(usuario,password)

        if(inicioCorreo){
            view.onLoginSuccess()
        }else{
            view.onLoginFail()
        }
    }
}