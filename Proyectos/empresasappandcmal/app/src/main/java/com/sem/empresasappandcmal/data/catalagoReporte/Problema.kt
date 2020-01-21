package com.sem.empresasappandcmal.data.catalagoReporte

import com.google.gson.annotations.SerializedName

data class Problema(
    @SerializedName("idProblema") val idProblema :String,
    @SerializedName("descripcionProblema") val descripcionProblema :String

)