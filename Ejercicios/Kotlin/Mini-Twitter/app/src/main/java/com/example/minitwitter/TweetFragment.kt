package com.example.minitwitter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.minitwitter.retrofit.api.response.Tweet
import com.example.minitwitter.utils.alertDialog
import kotlinx.android.synthetic.main.fragment_tweet.*

class TweetFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //loadTweetData()
        return inflater.inflate(R.layout.fragment_tweet,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    fun loadTweetData(lista:List<Tweet>){
        recyclerTweet.layoutManager = LinearLayoutManager(context)
        recyclerTweet.adapter = AdapterTweet(lista,context!!)
    }

    fun responseFail() {
        context!!.alertDialog(getString(R.string.error_data_title),getString(R.string.error_data_message),getString(R.string.btn_aceptar))

    }

    fun responseFailInternet() {
        context!!.alertDialog(getString(R.string.error_conexion_title),getString(R.string.error_conexion_message),getString(R.string.btn_aceptar))
    }
}
