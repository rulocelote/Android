package com.sem.empresasappandcmal.data.notificaciones

import com.google.gson.annotations.SerializedName

data class ListaAvisos (

    @SerializedName("idAvisoPersonal") val idAvisoPersonal :String,
    @SerializedName("idEmpleado") val idEmpleado :String,
    @SerializedName("idAvisoGral") val idAvisoGral :String,
    @SerializedName("tituloAviso") val tituloAviso :String,
    @SerializedName("descripcionAviso") val descripcionAviso :String,
    @SerializedName("status") val status :Int
)