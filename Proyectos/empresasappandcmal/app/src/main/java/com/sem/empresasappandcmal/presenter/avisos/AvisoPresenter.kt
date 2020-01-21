package com.sem.empresasappandcmal.presenter.avisos

import com.sem.empresasappandcmal.data.notificaciones.ListaAvisos

interface AvisoPresenter {
    fun getListAvisos(numEmpleado:String)
    fun setListAviso(adviceList : ArrayList<ListaAvisos>)
    fun errorFromConnection(message: String)
    fun notifyReadAdvice(ideEmploye: String, idGeneralAdvice: String, status: String)
    fun setInfoForAdviceRead(codigo: String, descripcion: String)
}