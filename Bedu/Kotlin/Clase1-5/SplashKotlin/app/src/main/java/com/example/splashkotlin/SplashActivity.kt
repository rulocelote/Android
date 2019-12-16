package com.example.splashkotlin

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var handler = Handler()
        handler.postDelayed({ abrirMain() }, 3000)
    }

    fun abrirMain(){
        var intent = Intent(applicationContext,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
