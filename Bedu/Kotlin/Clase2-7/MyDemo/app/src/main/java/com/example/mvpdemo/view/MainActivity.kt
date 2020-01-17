package com.example.mvpdemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvpdemo.presenter.MensajePresenter
import com.example.mvpdemo.presenter.MensajePresenterImp
import com.example.mydemo.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MainView {

    val presenter:MensajePresenter = MensajePresenterImp(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.saludar("Carlos Arteaga")
    }

    override fun mostrarSaludo(saludo: String) {
        txtSaludo.text = saludo
    }
}
