package com.example.minitwitter.modules.tweet.view

import com.example.minitwitter.retrofit.api.data.response.Tweet

interface TweetView {
    fun responseSuccess(lista:List<Tweet>)
    fun responseFail()
    fun responseFailInternet()
}