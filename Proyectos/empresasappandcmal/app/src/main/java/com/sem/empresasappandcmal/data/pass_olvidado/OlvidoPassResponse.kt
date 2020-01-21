package com.sem.empresasappandcmal.data.pass_olvidado

import com.google.gson.annotations.SerializedName

data class OlvidoPassResponse(
    @SerializedName("codigoOperacion") val codigo:String,
    @SerializedName("descripcion") val descripcion:String
)