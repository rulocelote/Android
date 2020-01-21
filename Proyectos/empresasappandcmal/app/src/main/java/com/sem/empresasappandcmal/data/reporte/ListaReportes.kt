package com.sem.empresasappandcmal.data.reporte

import com.google.gson.annotations.SerializedName

data class ListaReportes (
    @SerializedName("idReporte") val idReporte :String,
    @SerializedName("descripcionProblema") val descripcionProblema :String,
    @SerializedName("fechaReporte") val fechaReporte :String

)