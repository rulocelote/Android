package com.example.duckhunt.view.game

import android.annotation.SuppressLint
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

class GameActivity : AppCompatActivity(),View.OnClickListener {

    private var gamePresenter: GamePresenter = GamePresenterImp(this)
    lateinit var aleatorio:Random
    var anchoPantalla by Delegates.notNull<Int>()
    var altoPantalla by Delegates.notNull<Int>()
    var counter = 0


    @SuppressLint("DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        gamePresenter.initPantalla()

        tvGameUserName.text = intent.extras!!.getString(Constantes.EXTRA_NICK)!!.toUpperCase()
        imgGameDuck.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view!!.id){
            R.id.imgGameDuck -> {
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
