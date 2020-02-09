package com.example.minitwitter.modules.tweet.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.minitwitter.R
import com.example.minitwitter.modules.tweet.presenter.TweetPresenter
import com.example.minitwitter.modules.tweet.presenter.TweetPresenterImp
import com.example.minitwitter.modules.tweet.view.AdapterTweet
import com.example.minitwitter.retrofit.api.data.response.Tweet
import com.example.minitwitter.utils.alertDialog
import kotlinx.android.synthetic.main.fragment_tweet.*

class TweetFragment : Fragment(),TweetView {

    private lateinit var tweetPresenter:TweetPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tweet,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tweetPresenter = TweetPresenterImp(this,context!!)

        tweetPresenter.requestData(context!!)
    }

    override fun responseSuccess(lista:List<Tweet>) {
        recyclerTweet.layoutManager = LinearLayoutManager(context)
        recyclerTweet.adapter = AdapterTweet(lista,context!!)
    }

    override fun responseFail() {
        context!!.alertDialog(getString(R.string.error_data_title),getString(R.string.error_data_message),getString(R.string.btn_aceptar))

    }

    override fun responseFailInternet() {
        context!!.alertDialog(getString(R.string.error_conexion_title),getString(R.string.error_conexion_message),getString(R.string.btn_aceptar))
    }
}
