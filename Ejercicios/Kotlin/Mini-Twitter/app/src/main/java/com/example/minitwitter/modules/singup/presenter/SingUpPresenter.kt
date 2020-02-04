package com.example.minitwitter.modules.singup.presenter

interface SingUpPresenter{
    fun validaDatos(userName:String, email:String, password:String)
    fun responseSucceful()
    fun responseFail()
    fun responseErrorInternet()
}