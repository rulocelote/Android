package com.example.viewmodellivedata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewmodellivedata.ui.ViewModelActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpView()
    }

    fun setUpView(){
        startActivity(Intent(applicationContext,ViewModelActivity::class.java))
    }
}
