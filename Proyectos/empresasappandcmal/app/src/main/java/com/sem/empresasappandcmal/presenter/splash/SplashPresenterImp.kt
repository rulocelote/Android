package com.sem.empresasappandcmal.presenter.splash

import android.content.Context
import com.sem.empresasappandcmal.model.realm.RealmUtils
import com.sem.empresasappandcmal.view.splash.SplashView

class SplashPresenterImp(private val splashView: SplashView, private val context: Context):SplashPresenter {
    override fun comprobarUsuarios(){
        val usuario = RealmUtils.realmUser(context).obtenerUsuario()

        if(usuario != null)
            splashView.intentMain(usuario.numEmpleado)
        else
            splashView.intentLogin()
    }
}