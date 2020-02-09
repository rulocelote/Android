package com.example.minitwitter.modules.tweet.presenter

import android.content.Context
import com.example.minitwitter.retrofit.api.data.response.Tweet

interface TweetPresenter {
    fun requestData(context: Context)
    fun responseSuccess(lista:List<Tweet>)
    fun responseFail()
    fun responseFailInternet()
}