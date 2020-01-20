package com.example.duckhunt.presenter.game

import android.graphics.Point
import android.view.Display
import android.widget.ImageView
import com.example.duckhunt.view.game.GameActivity
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*

class GamePresenterImp(val gameView: GameActivity):GamePresenter{

    override fun initPantalla() {
        // 1. Obtener el tamaño de la pantalla del dispositivo en el que estamos ejecutando la app
        val display: Display = gameView.windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        gameView.anchoPantalla = size.x
        gameView.altoPantalla = size.y

        // 2. Inicializamos el objeto para generar números aleatorios
        gameView.aleatorio = Random()
    }

    override fun moveDuck(img:ImageView) {
        val min = 0
        val maximoX = gameView.anchoPantalla - img.width
        val maximoY = gameView.altoPantalla - img.height

        //generamos numeros aletaorios para x y y
        val randomX = gameView.aleatorio.nextInt(((maximoX - min) + 1) + min)
        val randomY = gameView.aleatorio.nextInt(((maximoY - min) + 1) + min)

        img.x = randomX.toFloat()
        img.y = randomY.toFloat()
    }

}