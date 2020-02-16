package com.example.minitwitter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.minitwitter.data.TweetViweModel
import com.example.minitwitter.retrofit.api.response.Tweet
import com.example.minitwitter.utils.alertDialog
import kotlinx.android.synthetic.main.fragment_tweet.*

class TweetFragment : Fragment(){

    private lateinit var tweetViweModel:TweetViweModel
    private lateinit var tweetList: List<Tweet>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tweetViweModel = ViewModelProviders.of(this).get(TweetViweModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //loadTweetData()
        return inflater.inflate(R.layout.fragment_tweet,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    fun loadTweetData(lista:List<Tweet>){
        tweetViweModel.getTweets().observe(this,object : Observer<List<Tweet>> {
            override fun onChanged(tweets: List<Tweet>?) {
                tweetList = tweets!!
                
                recyclerTweet.layoutManager = LinearLayoutManager(context)
                recyclerTweet.adapter = AdapterTweet(lista,context!!)
            }
        })

    }

    fun responseFail() {
        context!!.alertDialog(getString(R.string.error_data_title),getString(R.string.error_data_message),getString(R.string.btn_aceptar))

    }

    fun responseFailInternet() {
        context!!.alertDialog(getString(R.string.error_conexion_title),getString(R.string.error_conexion_message),getString(R.string.btn_aceptar))
    }
}
