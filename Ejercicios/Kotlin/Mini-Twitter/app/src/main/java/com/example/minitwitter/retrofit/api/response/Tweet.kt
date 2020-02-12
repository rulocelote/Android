package com.example.minitwitter.retrofit.api.response

import com.google.gson.annotations.SerializedName

data class Tweet(
    @SerializedName("id") var id:Int,
    @SerializedName("mensaje") var mensaje:String,
    @SerializedName("likes") var likes:List<Like>,
    @SerializedName("user") var user: User
)