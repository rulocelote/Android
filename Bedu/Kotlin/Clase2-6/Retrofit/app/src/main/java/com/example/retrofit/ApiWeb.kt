package com.example.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiWeb {
    @GET("{parametro}")
    fun recuperaComentarios(@Path("parametro") parametro:String):Call<List<Comentario>>
}

