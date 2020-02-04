package com.example.minitwitter.retrofit.api.data.response

import com.google.gson.annotations.SerializedName

data class Tweet(
    @SerializedName("id") private var id:Int,
    @SerializedName("mensaje") private var mensaje:String,
    @SerializedName("likes") private var likes:List<Like>,
    @SerializedName("user") private var user:User
)