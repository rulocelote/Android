package com.example.minitwitter.modules.singup.model

import com.example.minitwitter.retrofit.api.MiniTwitterClient
import com.example.minitwitter.retrofit.api.data.request.RequestSignup
import com.example.minitwitter.retrofit.api.data.response.ResponseAuth
import com.example.minitwitter.modules.singup.presenter.SingUpPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SingUpModelImp(val singUpPresenter: SingUpPresenter):SingUpModel{

    private val api = MiniTwitterClient.miniTwitterService
    private val code = "UDEMYANDROID"

    override fun doRegistro(username: String, email: String, password: String) {
        api.doSingUp(RequestSignup(username,email,password,code)).enqueue(object : Callback<ResponseAuth>{
            override fun onFailure(call: Call<ResponseAuth>, t: Throwable) {
                singUpPresenter.responseErrorInternet()
            }

            override fun onResponse(call: Call<ResponseAuth>, response: Response<ResponseAuth>) {
                if (response.isSuccessful){
                    singUpPresenter.responseSucceful()
                }else{
                    singUpPresenter.responseFail()
                }
            }

        })
    }

}