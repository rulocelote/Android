package com.example.minitwitter.modules.login.model

import com.example.minitwitter.retrofit.api.MiniTwitterClient
import com.example.minitwitter.retrofit.api.data.request.RequestLogin
import com.example.minitwitter.retrofit.api.data.response.ResponseAuth
import com.example.minitwitter.modules.login.presenter.LoginPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginModelImp(val loginPresenter: LoginPresenter):LoginModel {

    private val api = MiniTwitterClient.miniTwitterService

    override fun doLogin(email: String, password: String) {
        api.doLogin(RequestLogin(email, password)).enqueue(object : Callback<ResponseAuth>{
            override fun onFailure(call: Call<ResponseAuth>, t: Throwable) {
                loginPresenter.responseErrorInternet()
            }

            override fun onResponse(call: Call<ResponseAuth>, response: Response<ResponseAuth>) {
                if(response.isSuccessful){
                    response.body()?.let { loginPresenter.responseSucceful(it) }
                }else{
                    loginPresenter.responseFail()
                }
            }
        })
    }
}