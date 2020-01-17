package com.example.activityfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log

class MainActivity : AppCompatActivity() {
    private lateinit var timer: CountDownTimer
    val TAG = "TIMER";

    private fun setTimer(){
        timer = object: CountDownTimer(20000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished/1000;
                Log.d(TAG,"Tiempo restante: $seconds")
            }

            override fun onFinish() {
                Log.d(TAG,"Contador finalizado")
            }
        }
        timer.start()
    }

    private fun stopTimer(){
        timer.cancel()
        Log.d(TAG,"timer cancelado")
    }


    /**a) El contador sólo se debe iniciar al abrir la aplicación y se debe finalizar cuando se cierre o se minimice.
     * onCreate(), onPausa(),onStop(),onDestroy()
     * b) El contador se debe iniciar cada vez que la aplicación sea puesta en primer plano y finalizada cuando se cierre o se minimice.
     *onResume(), onPausa(),onStop(),onDestroy()
     * c) El contador sólo se debe iniciar al abrir la aplicación y se debe finalizar únicamente cuando la app se cierre.
     *onCreate, onDestroy()
     **/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()
        setTimer()
    }

    override fun onPause() {
        super.onPause()
        stopTimer()
    }

    override fun onDestroy() {
        super.onDestroy()
        stopTimer()
    }
}