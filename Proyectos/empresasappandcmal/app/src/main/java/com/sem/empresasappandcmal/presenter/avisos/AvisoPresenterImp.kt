package com.sem.empresasappandcmal.presenter.avisos

import android.content.Context
import com.sem.empresasappandcmal.data.notificaciones.ListaAvisos
import com.sem.empresasappandcmal.model.avisoGeneral.AvisoGeneralModelImp
import com.sem.empresasappandcmal.utils.Constants
import com.sem.empresasappandcmal.view.avisos.NotificacionesAyudaView

class AvisoPresenterImp (private var mView: NotificacionesAyudaView, context: Context) : AvisoPresenter  {

    private val modelImpAsInteractor: AvisoGeneralModelImp = AvisoGeneralModelImp(this,context)

    override fun getListAvisos(numEmpleado: String) {
        mView.showProgress()
        modelImpAsInteractor.getListAdvise(numEmpleado)
    }

    override fun setListAviso(adviceList: ArrayList<ListaAvisos>) {
        mView.hideProgress()
        mView.setListToAdapter(adviceList)
    }

    override fun errorFromConnection(message: String) {
        mView.hideProgress()
        mView.onFailAvisoConexionError(message)
    }

    override fun notifyReadAdvice(ideEmploye: String, idGeneralAdvice: String, status: String) {
        mView.showProgress()
        modelImpAsInteractor.validaAvisoGeneral(ideEmploye, idGeneralAdvice, status)
    }

    override fun setInfoForAdviceRead(codigo: String, descripcion: String) {
        when(codigo){

            Constants.IDE_ONE -> {
                mView.hideProgress()
            }
            Constants.IDE_FOUR -> {
                mView.hideProgress()
                mView.onFailAvisoConexionError(descripcion)
            }
        }
    }

}