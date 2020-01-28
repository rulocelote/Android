package com.example.proyectoexamen

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectoexamen.presenter.Principal
import com.example.proyectoexamen.presenter.PrincipalImp
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val principal:Principal = PrincipalImp(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupNavigation(bottom_navigation)
    }

    fun setupNavigation(navigationBar: BottomNavigationView) {
        navigationBar.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_perfil -> {
                    principal.mostrarIntent("perfil")
                    true
                }
                R.id.action_noticias -> {
                    principal.mostrarIntent("noticias")
                    true
                }
                R.id.action_camara -> {
                    principal.mostrarIntent("camara")
                    true
                }
                else -> false
            }
        }
    }
}
