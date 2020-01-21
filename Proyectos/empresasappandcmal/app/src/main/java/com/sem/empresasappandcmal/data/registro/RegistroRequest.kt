package com.sem.empresasappandcmal.data.registro

import com.google.gson.annotations.SerializedName

data class RegistroRequest(
    @SerializedName("idEmpleado") var idEmpleado:String,
    @SerializedName("nombre") var nombre:String,
    @SerializedName("apellidoPaterno") var apPaterno:String,
    @SerializedName("apellidoMaterno") var apMaterno:String,
    @SerializedName("fechaNacimiento") var fechaNacimiento:String,
    @SerializedName("celular") var celular:String,
    @SerializedName("correo") var correo:String,
    @SerializedName("contrasena") var contrasena:String,
    @SerializedName("foto") var foto:String
)