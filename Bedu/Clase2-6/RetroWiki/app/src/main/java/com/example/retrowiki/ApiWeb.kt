package com.example.retrowiki

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiWeb{
    @GET("api.php?action=query&prop=extracts&format=json&exintro=&titles=xbox")
    fun recuperaDatos():Call<Query>
}