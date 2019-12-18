package com.example.proyectoexamen.presenter

import androidx.fragment.app.Fragment
import com.example.proyectoexamen.MainActivity
import com.example.proyectoexamen.view.noticias.NoticiasFragment
import com.example.proyectoexamen.view.perfil.PerfilFragment
import com.example.proyectoexamen.R

class PrincipalImp(var view:MainActivity):Principal {
    override fun mostrarIntent(opcion: String) {
        val opcBar:Map<String,Fragment> = mapOf("perfil" to PerfilFragment(), "noticias" to NoticiasFragment())
        val fragmentManager = view.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        opcBar[opcion]?.let { fragmentTransaction.remove(it) }
        opcBar[opcion]?.let { fragmentTransaction.replace(R.id.contenedorFragment, it,opcion) }
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}