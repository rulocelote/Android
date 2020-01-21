package com.sem.empresasappandcmal.data.login

import com.google.gson.annotations.SerializedName
import retrofit2.http.Field

data class LoginResponse(
    @SerializedName("codigoOperacion") val codigoOperacion:String,
    @SerializedName("descripcion") val descripcion:String,
    @SerializedName("idEmpleado") val idEmpleado:String
)