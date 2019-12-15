package com.charlye934.calculadoraclase2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        btnSumar.setOnClickListener{
            var n1 = txtNum1.text.toString().toDouble();
            var n2 = txtNum2.text.toString().toDouble();
            var res = n1+n2
            Toast.makeText(this,"La suma es: $res",Toast.LENGTH_SHORT).show()
        }

        btnRestar.setOnClickListener{
            var n1 = txtNum1.text.toString().toDouble();
            var n2 = txtNum2.text.toString().toDouble();
            var res = n1 - n2
            Toast.makeText(this,"La suma es: $res",Toast.LENGTH_SHORT).show()
        }

        btnMultiplicar.setOnClickListener{
            var n1 = txtNum1.text.toString().toDouble();
            var n2 = txtNum2.text.toString().toDouble();
            var res = n1*n2
            Toast.makeText(this,"La suma es: $res",Toast.LENGTH_SHORT).show()
        }

        btnDividir.setOnClickListener{
            var n1 = txtNum1.text.toString().toDouble();
            var n2 = txtNum2.text.toString().toDouble();
            var res = n1/n2
            Toast.makeText(this,"La suma es: $res",Toast.LENGTH_SHORT).show()
        }
    }
}
