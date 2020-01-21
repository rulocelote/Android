package com.sem.empresasappandcmal.data.asistencia

import com.google.gson.annotations.SerializedName

data class AsistenciaRequest(
    @SerializedName("idEmpleado") var idEmpleado:String,
    @SerializedName("foto") var foto:String,
    @SerializedName("fechaAsistencia") var fechaAsistencia:String,
    @SerializedName("latitud") var latitud:Double,
    @SerializedName("longitud") var longitud:Double
)