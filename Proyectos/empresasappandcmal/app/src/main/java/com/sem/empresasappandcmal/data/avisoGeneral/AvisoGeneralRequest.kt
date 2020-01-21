package com.sem.empresasappandcmal.data.avisoGeneral

import com.google.gson.annotations.SerializedName

data class AvisoGeneralRequest (
    @SerializedName ("idEmpleado") var idEmpleado   :String,
    @SerializedName ("idAvisoGral") var idAvisoGral   :String,
    @SerializedName ("status") var status   :String
)