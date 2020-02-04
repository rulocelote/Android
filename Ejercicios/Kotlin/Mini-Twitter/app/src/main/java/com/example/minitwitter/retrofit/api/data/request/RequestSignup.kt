package com.example.minitwitter.retrofit.api.data.request

import com.google.gson.annotations.SerializedName

data class RequestSignup(
    @SerializedName("username") var userName:String,
    @SerializedName("email") var email:String,
    @SerializedName("password") var password:String,
    @SerializedName("code") var code:String
)