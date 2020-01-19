package com.example.duckhunt.presenter.login

import com.example.duckhunt.view.login.LoginView

class LoginPresenterImp(private val loginView:LoginView):
    LoginPresenter {

    override fun validaNick(nickname: String) {
        when {
            nickname.isEmpty() -> loginView.errorLoginObligatorio()
            nickname.length < 3 -> loginView.errorLoginCaracteres()
            else -> loginView.successLogin()
        }

    }

}