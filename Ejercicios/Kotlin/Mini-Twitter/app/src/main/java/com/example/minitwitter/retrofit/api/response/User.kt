package com.example.minitwitter.retrofit.api.response

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id") var id:Int,
    @SerializedName("username")  var username:String,
    @SerializedName("descripcion") var descripcion:String,
    @SerializedName("website") var website:String,
    @SerializedName("photoUrl") var photoUrl:String,
    @SerializedName("created") var created:String
)