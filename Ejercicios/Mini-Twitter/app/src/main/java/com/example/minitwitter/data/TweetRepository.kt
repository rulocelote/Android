package com.example.minitwitter.data

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.minitwitter.retrofit.api.AuthTwitterClient
import com.example.minitwitter.retrofit.api.AuthTwitterService
import com.example.minitwitter.retrofit.api.response.Tweet
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TweetRepository(){

    private lateinit var authTwitterService:AuthTwitterService
    private lateinit var authTwitterClient: AuthTwitterClient
    private lateinit var allTweets:LiveData<List<Tweet>>

    constructor(context:Context) : this() {
        authTwitterClient = AuthTwitterClient(context).getInstace()
        authTwitterService = authTwitterClient.getAuthTwitterService()
        allTweets = getAllTweets()
    }

    fun getAllTweets():LiveData<List<Tweet>>{
        val data:MutableLiveData<List<Tweet>> = MutableLiveData()

        authTwitterService.getAllTweets().enqueue(object : Callback<List<Tweet>>{
            override fun onFailure(call: Call<List<Tweet>>, t: Throwable) {
                Log.d("prueba 2", t.message.toString())

            }

            override fun onResponse(call: Call<List<Tweet>>, response: Response<List<Tweet>>) {
                if(response.isSuccessful){
                    Log.d("prueba 2", response.body()?.get(0)!!.mensaje)
                    data.value = response.body()
                }else{
                    Log.d("prueba 2", response.message())
                }
            }
        })
        return data
    }
}