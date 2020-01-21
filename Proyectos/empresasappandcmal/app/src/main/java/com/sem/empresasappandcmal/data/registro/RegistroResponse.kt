package com.sem.empresasappandcmal.data.registro

import com.google.gson.annotations.SerializedName

data class RegistroResponse(
    @SerializedName("codigoOperacion") val codigoOperacion:String,
    @SerializedName("descripcion") val descripcion:String
)