package com.sem.empresasappandcmal.data.login

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("idEmpleado") var idEmpleado:String,
    @SerializedName("contrasena") var constrasena:String
)