package com.example.minitwitter.data

import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.minitwitter.retrofit.api.response.Tweet

class TweetViweModel:ViewModel{
    private var tweetRepository:TweetRepository
    private var tweets:LiveData<List<Tweet>>

    constructor(){
        tweetRepository = TweetRepository()
        tweets = tweetRepository.getAllTweets()
    }

    fun getTweets():LiveData<List<Tweet>>{
        return tweets
    }
}