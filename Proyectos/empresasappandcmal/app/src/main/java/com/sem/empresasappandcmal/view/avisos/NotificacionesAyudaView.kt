package com.sem.empresasappandcmal.view.avisos

import com.sem.empresasappandcmal.data.notificaciones.ListaAvisos
import java.text.FieldPosition

interface NotificacionesAyudaView {

    fun onFailAvisoConexionError(descripcion: String)

    fun setListToAdapter(listaAvisosPersonales : ArrayList<ListaAvisos>)
    fun showProgress()
    fun hideProgress()

}