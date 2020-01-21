package com.sem.empresasappandcmal.data.reporte

import com.google.gson.annotations.SerializedName

data class Reporte (
    @SerializedName("codigoOperacion") val codigoOperacion :String,
    @SerializedName("descripcion") val descripcion :String,
    @SerializedName("listaReportes") val listaReportes :ArrayList<ListaReportes>
)

