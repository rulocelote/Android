package com.example.minitwitter.retrofit.api.data.response

import com.google.gson.annotations.SerializedName

data class ResponseAuth(
    @SerializedName("token") var token:String,
    @SerializedName("username") var username:String,
    @SerializedName("email") var email:String,
    @SerializedName("photoUrl") var photoUrl:String,
    @SerializedName("created") var created:String,
    @SerializedName("active") var active:Boolean
)