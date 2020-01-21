package com.sem.empresasappandcmal.data.perfil

import com.google.gson.annotations.SerializedName

data class PerfilResponse(
    @SerializedName("idEmpleado") var idEmpleado:String,
    @SerializedName("nombre") var nombre:String,
    @SerializedName("apellidoPaterno") var apellido:String,
    @SerializedName("foto") var foto:String
)