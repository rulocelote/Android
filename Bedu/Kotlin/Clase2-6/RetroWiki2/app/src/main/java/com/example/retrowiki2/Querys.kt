package com.example.retrowiki2

import com.google.gson.annotations.SerializedName

data class Querys(
    @SerializedName("query") var query:Pages
)

data class Pages(
    @SerializedName("pages") var pages:TipoPage
)

data class TipoPage(
    @SerializedName("58676") var xbox:Datos,
    @SerializedName("364001") var wii:Datos,
    @SerializedName("23599") var nintendo:Datos

)

data class Datos(
    @SerializedName("pageid") var pageid:Int,
    @SerializedName("ns") var ns:Int,
    @SerializedName("title") var title:String,
    @SerializedName("extract") var extract:String
)