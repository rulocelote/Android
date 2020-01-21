package com.sem.empresasappandcmal.data.avisoGeneral

import com.google.gson.annotations.SerializedName
import com.sem.empresasappandcmal.data.notificaciones.ListaAvisos

data class AvisoGeneralResponse (
    @SerializedName ("codigoOperacion") val codigoOperacion    :String,
    @SerializedName ("descripcion") val descripcion            :String,
    @SerializedName ("listaAvisosPersonales") val listaAvisosPersonales :ArrayList<ListaAvisos>
)