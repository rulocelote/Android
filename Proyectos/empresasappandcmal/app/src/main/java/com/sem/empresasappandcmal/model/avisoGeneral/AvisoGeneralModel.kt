package com.sem.empresasappandcmal.model.avisoGeneral

interface AvisoGeneralModel {
    fun getListAdvise(numEmploye: String)
    fun validaAvisoGeneral(idEmpleado: String, idAvisoGral: String, status: String)
}