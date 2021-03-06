package com.example.minitwitter.retrofit.api

import com.example.minitwitter.retrofit.api.request.RequestLogin
import com.example.minitwitter.retrofit.api.request.RequestSignup
import com.example.minitwitter.retrofit.api.response.ResponseAuth
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface MiniTwitterService {
    @POST("auth/login")
    fun doLogin(@Body requestLogin: RequestLogin): Call<ResponseAuth>

    @POST("auth/signup")
    fun doSingUp(@Body requestSignup: RequestSignup): Call<ResponseAuth>
}