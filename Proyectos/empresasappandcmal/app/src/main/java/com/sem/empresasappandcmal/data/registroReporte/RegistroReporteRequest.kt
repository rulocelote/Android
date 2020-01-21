package com.sem.empresasappandcmal.data.registroReporte

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class RegistroReporteRequest (

    @SerializedName("idProblema") var idProblema:String,
    @SerializedName("descripcionProblema") var descripcionProblema:String,
    @SerializedName("fechaReporte") var fechaReporte: String,
    @SerializedName("idEmpleado") var idEmpleado:String

)


