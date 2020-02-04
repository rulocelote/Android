package com.example.minitwitter.modules.singup.view

interface SingUpView {
    fun userEmpty()
    fun emailEmpty()
    fun passwordEmpty()
    fun responseSucceful()
    fun responseFail()
    fun responseErrorInternet()
}