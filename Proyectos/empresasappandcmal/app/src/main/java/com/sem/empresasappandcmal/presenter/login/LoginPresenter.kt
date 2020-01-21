package com.sem.empresasappandcmal.presenter.login

import com.google.android.material.textfield.TextInputLayout

interface LoginPresenter {
    fun deleteDatabase()
    fun compruebaCampos(numEmp: String, password: String)
    fun retornaRespuesta(codigo: String, descripcion:String,idEmpleado:String)
    fun conexionFail()
}