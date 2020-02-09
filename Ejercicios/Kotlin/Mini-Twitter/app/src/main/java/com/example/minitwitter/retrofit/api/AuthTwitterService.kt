package com.example.minitwitter.retrofit.api

import com.example.minitwitter.retrofit.api.data.response.Tweet
import retrofit2.Call
import retrofit2.http.GET

interface AuthTwitterService {
    @GET("tweets/all")
    fun getAllTweets(): Call<List<Tweet>>
}