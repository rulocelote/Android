package com.sem.empresasappandcmal.data.perfil

import com.google.gson.annotations.SerializedName

data class ListaAsistencia(
    @SerializedName("fechaAsistencia") var fechaAsistencia:String
)