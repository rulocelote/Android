package com.sem.empresasappandcmal.view.reportes

import com.sem.empresasappandcmal.data.catalagoReporte.Problema
import com.sem.empresasappandcmal.data.reporte.ListaReportes

interface AyudaView {
    fun enviarReporteDatos()
    fun obtenerReporteDatos():Array<String>
    fun getListReportes(listReport : ArrayList<ListaReportes>)
    fun getList(lst : ArrayList<Problema>)
    fun onRegistroReporteSucces(descripcion:String)
    fun onFailReporteConexionError()
    fun onError (error :String)
    fun showProgres()
    fun hideProgres()
}