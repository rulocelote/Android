package com.example.proyectoexamen.presenter.noticias

import com.example.proyectoexamen.adapter.Cuadros

interface NoticiasPresenter {
    fun MostrarDatos(listaCuadros:ArrayList<Cuadros>)
    fun RecuperarDatos()
}