package com.sem.empresasappandcmal.data.registroReporte

import com.google.gson.annotations.SerializedName

data class RegistroReporteResponse (

    @SerializedName("codigoOperacion") val codigoOperacion:String,
    @SerializedName("descripcion") val descripcion:String

)

