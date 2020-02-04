package com.example.minitwitter.retrofit.api

import com.example.minitwitter.utils.Constantes.URL_BASE
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MiniTwitterClient{
    val miniTwitterService:MiniTwitterService by lazy{
        val retrofit:Retrofit = Retrofit
            .Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return@lazy retrofit.create(MiniTwitterService::class.java)
    }
}