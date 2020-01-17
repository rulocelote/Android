package com.example.retrofit

import com.google.gson.annotations.SerializedName

data class Comentario(
    @SerializedName("postId") var postId:Int,
    @SerializedName("Id") var id:Int,
    @SerializedName("name") var name:String,
    @SerializedName("email") var email:String,
    @SerializedName("body") var body:String){

}