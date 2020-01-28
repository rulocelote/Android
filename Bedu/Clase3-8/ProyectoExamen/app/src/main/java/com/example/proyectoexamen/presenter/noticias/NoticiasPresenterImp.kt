package com.example.proyectoexamen.presenter.noticias

import android.util.Log
import com.example.proyectoexamen.adapter.Cuadros
import com.example.proyectoexamen.model.NoticiasModel
import com.example.proyectoexamen.model.NoticiasModelImp
import com.example.proyectoexamen.view.noticias.NoticiasFragment
import com.example.proyectoexamen.view.noticias.NoticiasView

class NoticiasPresenterImp(var view:NoticiasFragment):NoticiasPresenter {

    var noticiasModel:NoticiasModel = NoticiasModelImp(this)

    override fun MostrarDatos(listaCuadros:ArrayList<Cuadros>) {
        view.MuestraDatos(listaCuadros)
    }

    override fun RecuperarDatos() {
        noticiasModel.RecuperaDatos()
    }

}