package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var cont = 0
        var tag = ""
        cambiarFragment.setOnClickListener{
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()//obteniendo el objeto Transaction
            if(cont%2==0){
                fragmentTransaction.replace(R.id.fragment,Fragment2(),"f2")//REMPLAZANDO EL FRAGMENTO
                tag = "f1"
            }else{
                fragmentTransaction.replace(R.id.fragment,Fragment1(),"f1")
                tag = "f2"
            }
            fragmentTransaction.addToBackStack(tag)//la transacción se recordará después de que se confirme, y se revertirá su operación cuando se saque de la pila.
            fragmentTransaction.commit()//confirma los cambios
            cont++
        }
    }
}
