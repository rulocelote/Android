package com.example.duckhunt.view.game

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.duckhunt.R
import com.example.duckhunt.presenter.game.GamePresenter
import com.example.duckhunt.presenter.game.GamePresenterImp
import com.example.duckhunt.utils.Constantes
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*
import kotlin.properties.Delegates

class GameActivity : AppCompatActivity(),View.OnClickListener,GameView {

    private var gamePresenter: GamePresenter = GamePresenterImp(this)
    lateinit var aleatorio:Random
    var anchoPantalla by Delegates.notNull<Int>()
    var altoPantalla by Delegates.notNull<Int>()
    var counter = 0
    var gameOver = false


    @SuppressLint("DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        gamePresenter.initPantalla()
        gamePresenter.initCuentaAtras()

        tvGameUserName.text = intent.extras!!.getString(Constantes.EXTRA_NICK)!!.toUpperCase()
        imgGameDuck.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if(!gameOver){
            when(view!!.id){
                R.id.imgGameDuck -> {
                    if(!gameOver)
                        counter++
                    tvGameCounter.text = counter.toString()
                    imgGameDuck.setImageResource(R.drawable.duck_clicked)

                    Handler().postDelayed({
                        imgGameDuck.setImageResource(R.drawable.duck)
                        gamePresenter.moveDuck(imgGameDuck)
                    }, 500)
                }
            }
        }
    }

    override fun cuentaAtras(segundos:String){
        tvGameTimer.text = segundos
    }

    override fun gameOver1() {
        val builder = AlertDialog.Builder(applicationContext)
        builder.setMessage("Has conseguido cazar $counter patos")
            .setTitle("Game over")

        builder.setPositiveButton("Reiniciar") { dialog, id -> }
        builder.setNegativeButton("Salir") { dialog, id -> dialog.dismiss() }
        val dialog = builder.create()
        dialog.setCancelable(false)
        dialog.show()
    }
}
