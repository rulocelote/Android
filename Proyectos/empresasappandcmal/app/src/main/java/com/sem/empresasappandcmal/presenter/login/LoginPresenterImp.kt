package com.sem.empresasappandcmal.presenter.login

import android.content.Context
import com.sem.empresasappandcmal.model.realm.RealmUtils
import com.sem.empresasappandcmal.model.login.LoginModel
import com.sem.empresasappandcmal.model.login.LoginModelImp
import com.sem.empresasappandcmal.utils.Constants
import com.sem.empresasappandcmal.view.login.LoginView

class LoginPresenterImp(private val loginView: LoginView, private val context:Context): LoginPresenter {

    private val loginModel:LoginModel = LoginModelImp(this)

    override fun deleteDatabase() {
        RealmUtils.realmUser(context).eliminarUsuario()
    }

    override fun compruebaCampos(numEmp: String, password: String) {
        loginView.showProgres()
        loginModel.validaLogin(numEmp,password)
    }

    override fun retornaRespuesta(codigo: String,descripcion:String,idEmpleado:String){
        loginView.hideProgres()
        when(codigo){
            Constants.IDE_ONE-> loginView.onLoginSucces(descripcion, idEmpleado)
            Constants.IDE_TWO -> loginView.numEmpleadoFail(descripcion)
            Constants.IDE_THREE-> loginView.passwordFail(descripcion)
            Constants.IDE_FOUR -> loginView.conexionFail()
        }
    }

    override fun conexionFail() {
        loginView.hideProgres()
        loginView.conexionFail()
    }
}