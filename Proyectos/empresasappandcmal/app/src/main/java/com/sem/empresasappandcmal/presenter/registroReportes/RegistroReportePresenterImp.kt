package com.sem.empresasappandcmal.presenter.registroReportes

import com.sem.empresasappandcmal.utils.Constants
import com.sem.empresasappandcmal.data.catalagoReporte.Problema
import com.sem.empresasappandcmal.data.reporte.ListaReportes
import com.sem.empresasappandcmal.model.registroReporte.RegistroReporteModel
import com.sem.empresasappandcmal.model.registroReporte.RegistroReporteModelImp
import com.sem.empresasappandcmal.view.reportes.AyudaView


class RegistroReportePresenterImp (private val view: AyudaView):RegistroReportePresenter{

    private val modelImpAsInteractor: RegistroReporteModel = RegistroReporteModelImp(this)

    override fun setListImp(lst: ArrayList<Problema>) {
        view.hideProgres()
        view.getList(lst)
    }

    override fun setListReportesImp(listReport: ArrayList<ListaReportes>) {
        view.hideProgres()
        view.getListReportes(listReport)
    }

    override fun getListReportesImp(numEmpleado: String) {
        view.showProgres()
        modelImpAsInteractor.getListReportes(numEmpleado)
    }

    override fun getListImp() {
        view.showProgres()
        modelImpAsInteractor.getList()
    }

    override fun enviarReporteDatos(datos: Array<String>) {
        view.showProgres()
        modelImpAsInteractor.validaRegistroReporte(datos[0], datos[1], datos[2], datos[3])
    }

    override fun retornaReporteRespuesta(codigo: String, descripcion:String) {
        view.hideProgres()
        when(codigo){
            Constants.IDE_ONE -> view.onRegistroReporteSucces(descripcion)
            Constants.IDE_FOUR -> view.onFailReporteConexionError()
            Constants.IDE_FIVE -> view.onFailReporteConexionError()
        }
    }

    override fun onFailReporteConection() {
        view.hideProgres()
        view.onFailReporteConexionError()
    }
}