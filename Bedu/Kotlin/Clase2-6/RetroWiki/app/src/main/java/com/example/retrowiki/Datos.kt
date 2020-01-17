package com.example.retrowiki

import com.google.gson.annotations.SerializedName

class Datos (
    @SerializedName("pageid") var pageid:Int,
    @SerializedName("ns") var ns:Int,
    @SerializedName("title") var title:String,
    @SerializedName("extract") var extract:String
){}
