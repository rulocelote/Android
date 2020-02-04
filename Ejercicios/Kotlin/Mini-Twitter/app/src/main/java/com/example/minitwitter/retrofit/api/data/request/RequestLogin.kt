package com.example.minitwitter.retrofit.api.data.request

import com.google.gson.annotations.SerializedName

data class RequestLogin(
    @SerializedName("email") var email:String,
    @SerializedName("password") var password:String
)