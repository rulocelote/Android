package com.example.duckhunt.view.game

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.duckhunt.R
import com.example.duckhunt.utils.Constantes
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    @SuppressLint("DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        tvGameUserName.text = intent.extras!!.getString(Constantes.EXTRA_NICK)!!.toUpperCase()
    }
}
