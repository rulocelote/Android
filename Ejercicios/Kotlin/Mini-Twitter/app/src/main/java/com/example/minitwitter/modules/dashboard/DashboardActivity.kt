package com.example.minitwitter.modules.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.Fragment
import com.example.minitwitter.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
    }

    private fun setupNavigationBar(navigationBar: BottomNavigationView){
        navigationBar.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.navigation_home ->{}
                R.id.navigation_dashboard -> {}
                R.id.navigation_perfil -> {}
            }
        }
    }

    override fun onBackPressed() {
        val count = supportFragmentManager.backStackEntryCount

        if(count == 1) finish()
        else super.onBackPressed()
    }

    private fun mostrarFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.contenedor_fragment,fragment)
            .addToBackStack(null)
            .commit()
    }
}
