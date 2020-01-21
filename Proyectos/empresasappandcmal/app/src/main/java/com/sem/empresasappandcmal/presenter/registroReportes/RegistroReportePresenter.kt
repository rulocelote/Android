package com.sem.empresasappandcmal.presenter.registroReportes

import com.sem.empresasappandcmal.data.catalagoReporte.Problema
import com.sem.empresasappandcmal.data.reporte.ListaReportes

interface RegistroReportePresenter {
    fun enviarReporteDatos(datos:Array<String>)
    fun retornaReporteRespuesta(codigo:String, descripcion:String)
    fun onFailReporteConection()

    fun getListReportesImp(numEmpleado:String)
    fun setListReportesImp(listReport : ArrayList<ListaReportes>)
    fun getListImp()
    fun setListImp(lst: ArrayList<Problema>)

}