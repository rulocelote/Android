package com.example.registromvp.model.api

import com.example.registromvp.model.data.Datos
import retrofit2.Call
import retrofit2.http.GET

interface ApiWeb {
    @GET("banco.json")
    fun datosBanco():Call<List<Datos>>
}