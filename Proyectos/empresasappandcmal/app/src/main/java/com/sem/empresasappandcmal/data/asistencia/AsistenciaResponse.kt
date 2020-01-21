package com.sem.empresasappandcmal.data.asistencia

import com.google.gson.annotations.SerializedName

data class AsistenciaResponse (
    @SerializedName("codigoOperacion") var codigoOperacion:String,
    @SerializedName("descripcion") var descripcion:String
)