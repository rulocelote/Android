package com.example.duckhunt.presenter.game

import android.widget.ImageView

interface GamePresenter {
    fun initPantalla()
    fun moveDuck(img:ImageView)
    fun initCuentaAtras()
}