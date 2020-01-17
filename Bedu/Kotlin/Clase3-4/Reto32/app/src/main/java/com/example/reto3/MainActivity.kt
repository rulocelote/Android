package com.example.reto3

import android.content.DialogInterface
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    var imgG = arrayListOf(R.drawable.grafica1,R.drawable.grafica2,R.drawable.grafica3,R.drawable.grafica4,R.drawable.grafica5,R.drawable.grafica6,R.drawable.grafica8)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button6.setOnClickListener {
            mensaje()
        }

        button2.setOnClickListener{
            mensaje()
        }

        val bottomNavigationView = bottom_navigation as BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.getItemId()) {
                    R.id.action_perfil -> Toast.makeText(this@MainActivity, "Recents", Toast.LENGTH_SHORT).show()
                    R.id.action_favorites -> Toast.makeText(this@MainActivity, "Favorites", Toast.LENGTH_SHORT).show()
                    R.id.action_nearby -> Toast.makeText(this@MainActivity, "Nearby", Toast.LENGTH_SHORT).show()
                    R.id.action_prueba -> Toast.makeText(this@MainActivity, "Prueba", Toast.LENGTH_SHORT).show()
                }
                return true
            }
        })
    }

    fun cambio(view:View){
        var tag = view.tag.toString()
        txtEmpresa.text = "Histograma \n $tag"
        imgGrafica.setImageResource(imgG[Random.nextInt(7)])
    }

    fun mensaje(){
        var builder = AlertDialog.Builder(this)

        builder.setIcon(R.drawable.ic_action_prueba)
            .setTitle("Hola")
            .setMessage("Este es un mensaje")
            .setPositiveButton("Aceptar", DialogInterface.OnClickListener { dialog, id ->
                // FIRE ZE MISSILES!
            })
            .setNegativeButton("Cancelar",
                DialogInterface.OnClickListener { dialog, id ->
                    dialog.cancel()
                })
        var alerta = builder.create()
        alerta.show()
    }
}
