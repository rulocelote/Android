package com.example.minitwitter.modules.login.presenter

import com.example.minitwitter.retrofit.api.data.response.ResponseAuth

interface LoginPresenter {
    fun validaDatos(email:String,password:String)
    fun responseSucceful(response:ResponseAuth)
    fun responseFail()
    fun responseErrorInternet()
}