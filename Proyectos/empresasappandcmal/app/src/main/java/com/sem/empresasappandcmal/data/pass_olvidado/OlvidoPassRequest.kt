package com.sem.empresasappandcmal.data.pass_olvidado

import com.google.gson.annotations.SerializedName

data class OlvidoPassRequest(
    @SerializedName("idEmpleado") val idEmpleado:String,
    @SerializedName("correo") val correo:String,
    @SerializedName("nuevaContrasena") val password:String
)