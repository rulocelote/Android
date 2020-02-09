package com.example.minitwitter.modules.tweet.presenter

import android.content.Context
import com.example.minitwitter.modules.tweet.model.TweetModel
import com.example.minitwitter.modules.tweet.model.TweetRepository
import com.example.minitwitter.modules.tweet.view.TweetView
import com.example.minitwitter.retrofit.api.data.response.Tweet

class TweetPresenterImp(val tweetView: TweetView, val context: Context):TweetPresenter {

    private val tweetModel:TweetModel = TweetRepository(this,context)

    override fun requestData(context: Context) {
        tweetModel.TweetRepository()
    }

    override fun responseSuccess(lista:List<Tweet>) {
        tweetView.responseSuccess(lista)
    }

    override fun responseFail() {
        tweetView.responseFail()
    }

    override fun responseFailInternet() {
        tweetView.responseFailInternet()
    }

}