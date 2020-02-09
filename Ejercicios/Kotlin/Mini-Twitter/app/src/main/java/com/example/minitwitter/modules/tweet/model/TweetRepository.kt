package com.example.minitwitter.modules.tweet.model

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.minitwitter.modules.tweet.presenter.TweetPresenter
import com.example.minitwitter.retrofit.api.AuthTwitterClient
import com.example.minitwitter.retrofit.api.AuthTwitterService
import com.example.minitwitter.retrofit.api.data.response.Tweet
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TweetRepository(val tweetPresenter: TweetPresenter,val context: Context):TweetModel {

    private lateinit var authTwitterService:AuthTwitterService
    private lateinit var authTwitterClient: AuthTwitterClient
    private lateinit var allTweets:LiveData<List<Tweet>>

    override fun TweetRepository(){
        authTwitterClient = AuthTwitterClient(context).getInstace()
        authTwitterService = authTwitterClient.getAuthTwitterService()
        allTweets = getAllTweets()
    }

    private fun getAllTweets():LiveData<List<Tweet>>{
        val data:MutableLiveData<List<Tweet>> = MutableLiveData()

        authTwitterService.getAllTweets().enqueue(object : Callback<List<Tweet>>{
            override fun onFailure(call: Call<List<Tweet>>, t: Throwable) {
                tweetPresenter.responseFailInternet()
                Log.d("prueba 2", t.message.toString())

            }

            override fun onResponse(call: Call<List<Tweet>>, response: Response<List<Tweet>>) {
                if(response.isSuccessful){
                    Log.d("prueba 2", response.body()?.get(0)!!.mensaje)
                    data.value = response.body()
                    tweetPresenter.responseSuccess(response.body()!!)
                }else{
                    tweetPresenter.responseFail()
                    Log.d("prueba 2", response.message())
                }
            }
        })
        return data
    }
}