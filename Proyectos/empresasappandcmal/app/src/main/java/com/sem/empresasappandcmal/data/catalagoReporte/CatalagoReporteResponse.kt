package com.sem.empresasappandcmal.data.catalagoReporte

import com.google.gson.annotations.SerializedName

data class CatalagoReporteResponse (
    @SerializedName("codigoOperacion") val codigoOperacion :String,
    @SerializedName("descripcion") val descripcion :String,
    @SerializedName("listaProblemas") val listaProblemas :ArrayList<Problema>
)
