
package com.sem.empresasappandcmal.presenter

import android.content.Context
import com.sem.empresasappandcmal.model.realm.RealmUtils

class MainPresenterImp(private val context:Context):MainPresenter {

    override fun deleteDatabase() {
        RealmUtils.realmUser(context).eliminarUsuario()
    }
}