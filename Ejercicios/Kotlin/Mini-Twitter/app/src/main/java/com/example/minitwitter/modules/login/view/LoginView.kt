package com.example.minitwitter.modules.login.view

import com.example.minitwitter.retrofit.api.data.response.ResponseAuth

interface LoginView {
    fun emailEmpty()
    fun passwordEmpty()
    fun responseSuccesful(response: ResponseAuth)
    fun responseFail()
    fun responseErrorInternet()
}