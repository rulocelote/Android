package com.example.minitwitter.retrofit.api

import android.content.Context
import com.example.minitwitter.utils.Constantes
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AuthTwitterClient(val context:Context) {
    private var authTwitterService: AuthTwitterService
    private val retrofit: Retrofit
    private var instace:AuthTwitterClient? = null

    init { // Incluir en la cabecera de la petición el TOKEN que autoriza al usuario
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.addInterceptor(AuthIntercpetor(context))
        val cliente = okHttpClientBuilder.build()
        retrofit = Retrofit.Builder()
            .baseUrl(Constantes.URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .client(cliente)
            .build()
        authTwitterService = retrofit.create(AuthTwitterService::class.java)
    }

    fun getInstace():AuthTwitterClient{
        if(instace == null) instace = AuthTwitterClient(context)
        return instace as AuthTwitterClient
    }

    fun getAuthTwitterService():AuthTwitterService = authTwitterService

}