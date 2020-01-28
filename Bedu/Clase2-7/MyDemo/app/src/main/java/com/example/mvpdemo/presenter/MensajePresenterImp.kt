package com.example.mvpdemo.presenter

import com.example.mvpdemo.model.Mensaje
import com.example.mvpdemo.model.MensajeImp
import com.example.mvpdemo.view.MainView

class MensajePresenterImp(var view:MainView): MensajePresenter{

    var modelMensaje:Mensaje = MensajeImp()

    override fun saludar(nombre: String) {
        //Se recibe la info de la vista
        var saludo = modelMensaje.saludar(nombre)

        //Actualizar la vista
        view.mostrarSaludo(saludo)
    }
}