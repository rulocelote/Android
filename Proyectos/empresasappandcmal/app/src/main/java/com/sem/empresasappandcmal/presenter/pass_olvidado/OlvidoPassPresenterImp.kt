package com.sem.empresasappandcmal.presenter.pass_olvidado

import com.sem.empresasappandcmal.model.pass_olvidado.OlvidoPassModel
import com.sem.empresasappandcmal.model.pass_olvidado.OlvidoPassModelImp
import com.sem.empresasappandcmal.utils.Constants
import com.sem.empresasappandcmal.view.pass_olvidado.OlvidoPassView

class OlvidoPassPresenterImp(private val olvidoPassView:OlvidoPassView):OlvidoPassPresenter{

    private val olvidoPassModel:OlvidoPassModel = OlvidoPassModelImp(this)

    override fun enviarDatos(numEmpleado:String,correo:String,password:String) {
        olvidoPassView.showProgres()
        olvidoPassModel.cambiarPassword(numEmpleado,correo,password)
    }

    override fun requestSuccess(codigo:String,descripcion: String){
        olvidoPassView.hideProgres()
        when(codigo){
            Constants.IDE_ONE ->  olvidoPassView.requestSuccess(descripcion)
            else -> olvidoPassView.requestFail(descripcion)
        }
    }

    override fun requestFail(){
        olvidoPassView.hideProgres()
        olvidoPassView.errorConexion()
    }

}