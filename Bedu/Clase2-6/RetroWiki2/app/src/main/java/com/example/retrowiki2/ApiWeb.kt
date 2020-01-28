package com.example.retrowiki2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Path

interface ApiWeb {
    @GET("api.php?action=query&prop=extracts&format=json&exintro=&titles=xbox")
    fun datosXbox():Call<Querys>

    @GET("api.php?action=query&prop=extracts&format=json&exintro=&titles=wii")
    fun datosWii():Call<Querys>

    @GET("api.php?action=query&prop=extracts&format=json&exintro=&titles=nintendo")
    fun datosNintendo():Call<Querys>
}