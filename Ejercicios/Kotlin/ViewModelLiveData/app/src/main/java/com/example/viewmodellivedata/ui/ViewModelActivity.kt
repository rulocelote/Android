package com.example.viewmodellivedata.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.viewmodellivedata.R
import com.example.viewmodellivedata.utils.Sumar
import com.example.viewmodellivedata.viewmodel.SumarViewModel
import kotlinx.android.synthetic.main.activity_view_model.*

class ViewModelActivity : AppCompatActivity() {

    lateinit var sumarViewModel: SumarViewModel
    var resultado:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TAG1", "onStart()")
        setContentView(R.layout.activity_view_model)

        setUpView()
    }

    @SuppressLint("SetTextI18n")
    fun setUpView(){
        sumarViewModel = ViewModelProvider(this).get(SumarViewModel::class.java)
        tvSumar.text = "$resultado"
        tvSumarViewModel.text = "${sumarViewModel.resultado}"

        btnSumar.setOnClickListener {
            resultado = Sumar.sumar(resultado)
            tvSumar.text = "$resultado"

            sumarViewModel.resultado = Sumar.sumar(sumarViewModel.resultado)
            tvSumarViewModel.text = "${sumarViewModel.resultado}"
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("TAG1", "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG1", "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG1", "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG1", "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG1", "onDestroy()")
    }
}
