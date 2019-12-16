package com.charlye934.sesion2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtUno.text = "Hola Carlos :)"
        btnUno.setOnClickListener{
            Toast.makeText(applicationContext,"Hola mundo",Toast.LENGTH_SHORT).show()
            if(radioButton.isChecked){
                Toast.makeText(applicationContext,"radio1 uno chequeado",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext,"radio2 dos chequeado",Toast.LENGTH_SHORT).show()
            }
        }
        editText.setText("texto editable")

    }
}
