package com.example.minitwitter.modules.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.minitwitter.R
import com.example.minitwitter.modules.tweet.view.TweetFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        setupNavigationBar(bottom_navigation)
    }

    private fun setupNavigationBar(navigationBar: BottomNavigationView){
        navigationBar.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.navigation_home ->{mostrarFragment(TweetFragment())}
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
