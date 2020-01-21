package com.sem.empresasappandcmal.data.perfil

import com.google.gson.annotations.SerializedName

data class PerfilAsistenciaResponse(
    @SerializedName("codigoOperacion") var codigoOperacion:String,
    @SerializedName("descripcion") var descripcion:String,
    @SerializedName("listaAsistencia") var asistencia:ArrayList<ListaAsistencia>
)