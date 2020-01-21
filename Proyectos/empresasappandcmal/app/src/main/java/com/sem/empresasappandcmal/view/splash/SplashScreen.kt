package com.sem.empresasappandcmal.view.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.sem.empresasappandcmal.MainActivity
import com.sem.empresasappandcmal.presenter.splash.SplashPresenter
import com.sem.empresasappandcmal.presenter.splash.SplashPresenterImp
import com.sem.empresasappandcmal.view.login.LoginActivity

class SplashScreen : AppCompatActivity(),
    SplashView {

    private lateinit var splashPresenter:SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        splashPresenter = SplashPresenterImp(this, applicationContext)
        splashPresenter.comprobarUsuarios()
    }

    override fun intentLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    override fun intentMain(numEmpleado:String) {
        startActivity(Intent(this, MainActivity::class.java).putExtra("idEmpleado",numEmpleado))
        finish()
    }

}