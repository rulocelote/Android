package com.sem.empresasappandcmal.data.notificaciones

import com.google.gson.annotations.SerializedName

data class Avisos (

    @SerializedName("codigoOperacion") val codigoOperacion :String,
    @SerializedName("descripcion") val descripcion :String,
    @SerializedName("listaAvisosPersonales") val listaAvisosPersonales :ArrayList<ListaAvisos>
)