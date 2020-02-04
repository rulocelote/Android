package com.example.minitwitter.retrofit.api.data.response

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id") private var id:Int,
    @SerializedName("username") private var username:String,
    @SerializedName("descripcion") private var descripcion:String,
    @SerializedName("website") private var website:String,
    @SerializedName("photoUrl") private var photoUrl:String,
    @SerializedName("created") private var created:String
)