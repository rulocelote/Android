package com.example.mvprecyclerview.view.login

interface LoginView {
    fun onLoginSuccess()
    fun onLoginFail()
    fun onLoginExist()
    fun onLoginEmailFail()
}