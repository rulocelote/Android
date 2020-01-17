package com.example.registromvp.view.login

interface LoginView {
    fun onLoginSuccess()
    fun onLoginFail()
    fun onLoginExist()
    fun onLoginEmailFail()
}