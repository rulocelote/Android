package com.example.minitwitter.modules.login.presenter

import android.content.Context
import com.example.minitwitter.retrofit.api.data.response.ResponseAuth
import com.example.minitwitter.modules.login.model.LoginModel
import com.example.minitwitter.modules.login.model.LoginModelImp
import com.example.minitwitter.modules.login.view.LoginView
import com.example.minitwitter.realm.RealmUtils

class LoginPresenterImp(val loginView: LoginView, val context: Context): LoginPresenter {

    private val loginModel:LoginModel = LoginModelImp(this)

    override fun validaDatos(email: String, password: String) {
        RealmUtils.realmData(context).eliminarData()
        if(email.isEmpty()){
            loginView.emailEmpty()
        }else if(password.isEmpty()){
            loginView.passwordEmpty()
        }else{
            loginModel.doLogin(email, password)
        }
    }

    override fun responseSucceful(response: ResponseAuth) {
        RealmUtils.realmData(context).crearToken(response.token)
        loginView.responseSuccesful(response)
    }

    override fun responseFail() {
        loginView.responseFail()
    }

    override fun responseErrorInternet() {
        loginView.responseErrorInternet()
    }

}